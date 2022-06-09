package org.dao.implementations;

import org.classes.Order;
import org.classes.OrderDismissal;
import org.dao.interfaces.LetterInterf;
import org.dao.interfaces.OrderInterf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс имплементирующий интерфейс {@link OrderInterf} с определенным методом <b>findAll</b>.
 * @author Наталья Лозинская
 * @version 1.0
 */
public class OrderInterfImpl<T> implements OrderInterf {

    /** Соединение с БД */
    private Connection conn;
    /** Формат вывода */
    private char simple;
    /** Класс получаемого объекта из БД */
    private Class<T> targetClass;

    /**
     * Метод для получения всех приказов из базы данных
     * @param type тип приказа
     * @see OrderInterf#findAll
     */
    public List<T> findAll(String type) throws InstantiationException, IllegalAccessException {
        List<T> result = new ArrayList<>();
        String SQL_SELECT = "Select * from javahw.public.orders o left join javahw.public.document d on o.document_id=d.id left join employers e on o.employee_id=e.id left join ordersdismiss o2 on o.id = o2.order_id left join reasonsdismiss r on r.id = o2.reason_id where o.type=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
            preparedStatement.setString(1, type);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int number = resultSet.getInt("document_id");
                String title = resultSet.getString("title");
                String employee = resultSet.getString("lastname") + ' ' + resultSet.getString("firstname") + ' ' + resultSet.getString("middlename");
                String text = resultSet.getString("text");
                String status = resultSet.getString("status");

                T order = targetClass.getDeclaredConstructor(int.class, char.class, String.class).newInstance(number, simple, employee);
                Method setText = targetClass.getDeclaredMethod("setText", String.class);
                setText.invoke(order, text);
                Method setTitle = targetClass.getDeclaredMethod("setTitle", String.class);
                setTitle.invoke(order, title);
                Method setStatus = targetClass.getDeclaredMethod("setStatus", String.class);
                setStatus.invoke(order, status);

                if (targetClass == OrderDismissal.class) {
                    String reason = resultSet.getString("reason");
                    Method setReasonDismissal = targetClass.getDeclaredMethod("setReasonDismissal", String.class);
                    setReasonDismissal.invoke(order, reason);
                }
                result.add(order);
            }


        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * Процедура определения класса получаемого объекта из БД {@link OrderInterfImpl#targetClass}
     * @param targetClass получаемый класс
     */
    public void setTargetClass(Class<T> targetClass) {
        this.targetClass = targetClass;
    }

    /**
     * Процедура определения соединения с БД {@link OrderInterfImpl#conn}
     * @param conn соединение с бд
     */
    public void setConn(Connection conn) {
        this.conn = conn;
    }

    /**
     * Процедура определения формата вывода {@link OrderInterfImpl#simple}
     * @param simple формат вывода
     */
    public void setSimple(char simple) {
        this.simple = simple;
    }
}
