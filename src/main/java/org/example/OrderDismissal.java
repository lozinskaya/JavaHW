package org.example;

public class OrderDismissal extends Order{

    private String reasonDismissal;

    public OrderDismissal(int number, String employee) {
        super(number, employee);
    }


    public String getReasonDismissal() {
        return reasonDismissal;
    }

    public void setReasonDismissal(String reasonDismissal) {
        this.reasonDismissal = reasonDismissal;
    }

    @Override
    public String toString() {
        return "OrderDismissal{" +
                this.getOrder() +
                " reasonDismissal='" + reasonDismissal + '\'' +
                '}';
    }
}
