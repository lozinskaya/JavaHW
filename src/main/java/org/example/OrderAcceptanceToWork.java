package org.example;

public class OrderAcceptanceToWork extends Order{

    public OrderAcceptanceToWork(int number, String employee) {
        super(number, employee);
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
