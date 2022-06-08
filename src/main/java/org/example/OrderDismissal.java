package org.example;

public class OrderDismissal extends Order{

    private String reasonDismissal;

    public OrderDismissal(int number, char simple, String employee) {
        super(number, simple, employee);
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
                (this.simple == 'y' ? "" :
                        " reasonDismissal='" + reasonDismissal + '\''
                )
                + '}';
    }
}
