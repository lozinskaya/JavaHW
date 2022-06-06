package org.example;

public class Letter extends Document{

    private String from;
    private String to;

    public Letter(int number) {
        super(number);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
