package org.example;

public class Main {
    public static void main(String[] args) {
        OrderAcceptanceToWork orderAcceptanceToWork = new OrderAcceptanceToWork(1, "Лозинская Н.Я");
        orderAcceptanceToWork.setTitle("Приём на работу");
        orderAcceptanceToWork.setText("Прошу принять на работу Лозинскую Наталью");
        System.out.println(orderAcceptanceToWork);

        Letter letter = new Letter(2);
        letter.setTitle("Письмо начальнику");
        letter.setFrom("От Лозинской Натальи");
        letter.setTo("Щипанову Дмитрию");
        System.out.println(letter);

        OrderDismissal orderDismissal = new OrderDismissal(3, "Петров Иван");
        orderDismissal.setTitle("Увольнение");
        orderDismissal.setText("Прошу уволить Петрова Ивана");
        orderDismissal.setReasonDismissal("Невыполнение должностных обязанностей");
        System.out.println(orderDismissal);

        orderAcceptanceToWork.setStatus("ИСПОЛНЕН");
        orderDismissal.setStatus("ИСПОЛНЕН");

        System.out.println(orderAcceptanceToWork);
        System.out.println(orderDismissal);

        orderAcceptanceToWork.setStatus("СОЗДАН");
        orderDismissal.setStatus("СОЗДАН");

        System.out.println(orderAcceptanceToWork);
        System.out.println(orderDismissal);
    }
}