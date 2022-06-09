package org.example;
import org.jdbc.PostgreSQLConnUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        char simple;
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

        List<Letter> result = new ArrayList<>();
        String SQL_SELECT = "Select * from javahw.public.letters l left join javahw.public.document d on l.document_id=d.id";
        Connection conn = PostgreSQLConnUtils.getMySQLConnection();

        try {
            System.out.print("Выводить краткую информацию о документах ? (y/n) ");
            simple = (char) System.in.read();
            if (simple != 'y' & simple != 'n') throw new IOException("Введены неверные данные");
            System.out.print("Ввели ");
            System.out.println(simple);

            PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int number = resultSet.getInt("document_id");
                String title = resultSet.getString("title");
                String from = resultSet.getString("letter_from");
                String to = resultSet.getString("letter_to");

                Letter letter = new Letter(number, simple);
                letter.setTo(to);
                letter.setFrom(from);
                letter.setTitle(title);
                result.add(letter);
            }

            for (Letter letter : result) {
                System.out.println(letter);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}