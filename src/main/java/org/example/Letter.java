package org.example;

public class Letter extends Document{

    private String from;
    private String to;

    public Letter(int number, char simple) {
        super(number, simple);
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
                this.getDocument() +
                (this.simple == 'y' ? "" :
                        ", from='" + from + '\'' +
                        ", to='" + to + '\''
                )
                + '}';
    }
}
