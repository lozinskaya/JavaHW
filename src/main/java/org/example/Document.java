package org.example;

public abstract class Document {

    private int number;
    private String title;
    char simple;

    public Document(int number, char simple) {
        this.number = number;
        this.simple = simple;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDocument() {
        return "number=" + number +
                ", title='" + title + '\'';
    }

    @Override
    public String toString() {
        return "Document{" +
                "number=" + number +
                ", title='" + title + '\'' +
                '}';
    }
}
