package org.model;

/**
 * Класс Документ со свойствами <b>number</b>, <b>title</b> и <b>simple</b>.
 * @author Наталья Лозинская
 * @version 1.0
 */
public abstract class Document {

    /** Поле номер документа */
    private final int number;
    /** Поле название документа */
    private String title;
    /** Поле выбора формата вывода */
    char simple;

    /**
     * Конструктор - создание нового объекта "Документ"
     * @param number номер документа
     * @param simple формат вывода
     */
    public Document(int number, char simple) {
        this.number = number;
        this.simple = simple;
    }

    /**
     * Функция получения значения поля {@link Document#number}
     * @return возвращает номер документа
     */
    public int getNumber() {
        return number;
    }

    /**
     * Функция получения значения поля {@link Document#title}
     * @return возвращает название документа
     */
    public String getTitle() {
        return title;
    }

    /**
     * Процедура определения названия документа {@link Document#title}
     * @param title название
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Функция получения значения полей объекта Документ ({@link Document#number}, {@link Document#title})
     * @return возвращает статус приказа
     */
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
