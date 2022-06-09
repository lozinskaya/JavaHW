package org.main;
import org.classes.Letter;
import org.classes.OrderAcceptanceToWork;
import org.classes.OrderDismissal;
import org.dao.implementations.LetterInterfImpl;
//import org.dao.implementations.OrderAcceptanceToWorkInterfImpl;
import org.dao.implementations.OrderInterfImpl;
//import org.dao.interfaces.OrderAcceptanceToWorkInterf;
import org.jdbc.PostgreSQLConnUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            System.out.print("Выводить краткую информацию о документах ? (y/n) ");
            simple = (char) System.in.read();
            if (simple != 'y' & simple != 'n') throw new IOException("Введены неверные данные");
            System.out.print("Ввели ");
            System.out.println(simple);

            Connection conn = PostgreSQLConnUtils.getMySQLConnection();

            LetterInterfImpl letterInterf = new LetterInterfImpl();
            letterInterf.setConn(conn);
            letterInterf.setSimple(simple);
            List<Letter> letters = letterInterf.findAll();
            for (Letter letter : letters) {
                System.out.println(letter);
            }

            OrderInterfImpl orderInterf = new OrderInterfImpl();
            orderInterf.setConn(conn);
            orderInterf.setSimple(simple);
            orderInterf.setTargetClass(OrderAcceptanceToWork.class);
            List<OrderAcceptanceToWork> ordersAccept = orderInterf.findAll("accept");
            for (OrderAcceptanceToWork orderAccept : ordersAccept) {
                System.out.println(orderAccept);
            }

            orderInterf.setTargetClass(OrderDismissal.class);
            List<OrderDismissal> ordersDismiss = orderInterf.findAll("dismiss");
            for (OrderDismissal orderDismiss : ordersDismiss) {
                System.out.println(orderDismiss);
            }

            orderInterf.countEmployers();

            // Кол-во документов для каждого типа
            HashMap<String, Integer> statistics = new HashMap<>();
            statistics.put("Количество писем ", (int) letters.size());
            statistics.put("Количество приказов о приёме на работу ", (int) ordersAccept.size());
            statistics.put("Количество приказов на увольнение ", (int) ordersDismiss.size());

            try(FileWriter writer = new FileWriter("statistics.txt", false))
            {
                for (Map.Entry entry: statistics.entrySet()) {
                    writer.write((String) entry.getKey() + entry.getValue());
                    writer.append('\n');

                }
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}