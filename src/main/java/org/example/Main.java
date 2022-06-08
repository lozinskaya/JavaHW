package org.example;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        char simple;
        try {
            System.out.print("Выводить краткую информацию о документах ? (y/n) ");
            simple = (char) System.in.read();
            if (simple != 'y' & simple != 'n') throw new IOException("Введены неверные данные");
            System.out.print("Ввели ");
            System.out.println(simple);

            OrderAcceptanceToWork orderAcceptanceToWork = new OrderAcceptanceToWork(1, simple,"Лозинская Н.Я");
            orderAcceptanceToWork.setTitle("Приём на работу");
            orderAcceptanceToWork.setText("Прошу принять на работу Лозинскую Наталью");
            System.out.println(orderAcceptanceToWork);

            Letter letter = new Letter(2, simple);
            letter.setTitle("Письмо начальнику");
            letter.setFrom("От Лозинской Натальи");
            letter.setTo("Щипанову Дмитрию");
            System.out.println(letter);

            OrderDismissal orderDismissal = new OrderDismissal(3, simple,"Петров Иван");
            orderDismissal.setTitle("Увольнение");
            orderDismissal.setText("Прошу уволить Петрова Ивана");
            orderDismissal.setReasonDismissal("Невыполнение должностных обязанностей");
            System.out.println(orderDismissal);

            System.out.println("ИЗМЕНЕНИЕ СТАТУСОВ");

            orderAcceptanceToWork.setStatus("ИСПОЛНЕН");
            orderDismissal.setStatus("ИСПОЛНЕН");

            System.out.println(orderAcceptanceToWork);
            System.out.println(orderDismissal);

            System.out.println("ПОВТОРНАЯ ПОПЫТКА ИЗМЕНЕНИЯ СТАТУСОВ");

            orderAcceptanceToWork.setStatus("СОЗДАН");
            orderDismissal.setStatus("СОЗДАН");

            System.out.println(orderAcceptanceToWork);
            System.out.println(orderDismissal);
        }
        catch (IOException e){
            System.out.println(e);
        }


    }
}