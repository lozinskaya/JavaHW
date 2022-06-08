package org.example;

public abstract class Order extends Document{

    private String employee;
    private String text;
    private String status;

    public Order(int number, String employee) {
        super(number);
        this.employee = employee;
        this.status = "СОЗДАН";
    }

    public String getEmployee() {
        return employee;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if ((this.status == "СОЗДАН") & (status == "ИСПОЛНЕН"))
            this.status = status;
        else
            System.out.println("Статус исполнен нельзя изменить");
    }

    public String getOrder(){
        return this.getDocument() +
                ", employee='" + employee + '\'' +
                ", text='" + text + '\'' +
                ", status='" + status + '\'' +
                ", title='" + this.getTitle() + '\'';
    }

    @Override
    public String toString() {
        return "Order{" +
                this.getDocument() +
                ", employee='" + employee + '\'' +
                ", text='" + text + '\'' +
                ", status='" + status + '\'' +
                ", title='" + this.getTitle() + '\'' +
                '}';
    }
}
