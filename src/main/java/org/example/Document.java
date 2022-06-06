package org.example;

public abstract class Document {

    private int number;
    private String title;

    public Document(int number) {
        this.number = number;
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

    @Override
    public String toString() {
        return "Document{" +
                "number=" + number +
                ", title='" + title + '\'' +
                '}';
    }
}
