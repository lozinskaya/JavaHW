package org.example;

public class Main {
    public static void main(String[] args) {
        OrderAcceptanceToWork orderAcceptanceToWork = new OrderAcceptanceToWork('1', "Лозинская Н.Я");
        orderAcceptanceToWork.setTitle("Приём на работу");
        System.out.println(orderAcceptanceToWork);
    }
}