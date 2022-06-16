package org.model;

public class Employee {
    private String firstname;
    private String lastname;
    private String middlename;
    private Integer countOrders;

    public Employee(String firstname, String lastname, String middlename) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
    }

    public void setCountOrders(Integer countOrders) {
        this.countOrders = countOrders;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public Integer getCountOrders() {
        return countOrders;
    }

    public String getFullName() {
        return lastname + ' ' + firstname + ' ' + middlename;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", countOrders=" + countOrders +
                '}';
    }
}
