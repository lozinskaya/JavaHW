package org.example;

public class OrderDismissal extends Order{

    private String reasonDismissal;

    public OrderDismissal(int number, String employee, String reasonDismissal) {
        super(number, employee);
    }

    public String getReasonDismissal() {
        return reasonDismissal;
    }

    public void setReasonDismissal(String reasonDismissal) {
        this.reasonDismissal = reasonDismissal;
    }
}
