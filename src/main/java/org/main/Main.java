package org.main;
import org.model.*;
import org.source.implementations.EmployeeInterfImpl;
import org.source.implementations.LetterInterfImpl;
//import org.dao.implementations.OrderAcceptanceToWorkInterfImpl;
import org.source.implementations.OrderInterfImpl;
//import org.dao.interfaces.OrderAcceptanceToWorkInterf;
import org.jdbc.PostgreSQLConnUtils;
import org.source.interfaces.EmployeeInterf;
import org.source.interfaces.LetterInterf;
import org.source.interfaces.OrderInterf;
import org.utils.implementations.MenuInterfImpl;
import org.utils.implementations.ResultInterfImpl;
import org.utils.implementations.StatisticInterfImpl;
import org.utils.interfaces.ResultInterf;
import org.utils.interfaces.StatisticInterf;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Задание 1
//        char simple;
//        try {
//            System.out.print("Выводить краткую информацию о документах ? (y/n) ");
//            simple = (char) System.in.read();
//            if (simple != 'y' & simple != 'n') throw new IOException("Введены неверные данные");
//            System.out.print("Ввели ");
//            System.out.println(simple);
//
//            OrderAcceptanceToWork orderAcceptanceToWork = new OrderAcceptanceToWork(1, simple,"Лозинская Н.Я");
//            orderAcceptanceToWork.setTitle("Приём на работу");
//            orderAcceptanceToWork.setText("Прошу принять на работу Лозинскую Наталью");
//            System.out.println(orderAcceptanceToWork);
//
//            Letter letter = new Letter(2, simple);
//            letter.setTitle("Письмо начальнику");
//            letter.setFrom("От Лозинской Натальи");
//            letter.setTo("Щипанову Дмитрию");
//            System.out.println(letter);
//
//            OrderDismissal orderDismissal = new OrderDismissal(3, simple,"Петров Иван");
//            orderDismissal.setTitle("Увольнение");
//            orderDismissal.setText("Прошу уволить Петрова Ивана");
//            orderDismissal.setReasonDismissal("Невыполнение должностных обязанностей");
//            System.out.println(orderDismissal);
//
//            System.out.println("ИЗМЕНЕНИЕ СТАТУСОВ");
//
//            orderAcceptanceToWork.setStatus("ИСПОЛНЕН");
//            orderDismissal.setStatus("ИСПОЛНЕН");
//
//            System.out.println(orderAcceptanceToWork);
//            System.out.println(orderDismissal);
//
//            System.out.println("ПОВТОРНАЯ ПОПЫТКА ИЗМЕНЕНИЯ СТАТУСОВ");
//
//            orderAcceptanceToWork.setStatus("СОЗДАН");
//            orderDismissal.setStatus("СОЗДАН");
//
//            System.out.println(orderAcceptanceToWork);
//            System.out.println(orderDismissal);
//        }
//        catch (IOException e){
//            System.out.println(e);
//        }

        //Задание итоговое

        char simple;
        try {
            MenuInterfImpl menu = new MenuInterfImpl();
            simple = menu.run();

            ResultInterf resultInterf = new ResultInterfImpl();
            List<Document> Documents = new ArrayList<>();

            Connection conn = PostgreSQLConnUtils.getMySQLConnection();

            LetterInterf letterInterf = new LetterInterfImpl(conn, simple);
            List<Letter> letters = letterInterf.findAll();
            resultInterf.print(letters);
            Documents.addAll(letters);

            OrderInterf orderInterf = new OrderInterfImpl(conn, simple, OrderAcceptanceToWork.class);
            List<OrderAcceptanceToWork> ordersAccept = orderInterf.findAll("accept");
            resultInterf.print(ordersAccept);
            Documents.addAll(ordersAccept);

            orderInterf.setTargetClass(OrderDismissal.class);
            List<OrderDismissal> ordersDismiss = orderInterf.findAll("dismiss");
            resultInterf.print(ordersDismiss);
            Documents.addAll(ordersDismiss);

            EmployeeInterf employeeInterf = new EmployeeInterfImpl(conn);
            List<Employee> employees = employeeInterf.findAll();
            resultInterf.print(employees);

            StatisticInterf statistic = new StatisticInterfImpl(Documents,employees);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}