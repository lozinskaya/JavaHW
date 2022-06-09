package org.classes;

import java.io.IOException;

/**
 * Класс Приказ со свойствами <b>employee</b>, <b>text</b> и <b>status</b>.
 * @author Наталья Лозинская
 * @version 1.0
 */
public abstract class Order extends Document{

    /** Поле сотрудник на которого назначен приказ*/
    private final String employee;
    /** Поле текст приказа*/
    private String text;
    /** Поле статус приказа*/
    private String status;

    /**
     * Конструктор - создание нового объекта "Приказ"
     * @param number номер документа
     * @param simple формат вывода
     * @param employee сотрудник
     * @see Document#Document(int, char)
     */
    public Order(int number, char simple, String employee) {
        super(number, simple);
        this.employee = employee;
    }

    /**
     * Функция получения значения поля {@link Order#employee}
     * @return возвращает сотрудника
     */
    public String getEmployee() {
        return employee;
    }

    /**
     * Функция получения значения поля {@link Order#text}
     * @return возвращает текст приказа
     */
    public String getText() {
        return text;
    }

    /**
     * Процедура определения текста приказа {@link Order#text}
     * @param text текст приказа
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Функция получения значения поля {@link Order#status}
     * @return возвращает статус приказа
     */
    public String getStatus() {
        return status;
    }

    /**
     * Процедура определения статуса приказа {@link Order#status}
     * @param status статус
     */
    public void setStatus(String status) throws Exception {
        if (this.status != null ) {
            if (this.status.equals("ИСПОЛНЕН")) {
                throw new Exception("Статус исполнен нельзя изменить");
            }
        } else if (status.equals("СОЗДАН") || status.equals("ИСПОЛНЕН")) {
                this.status = status;
        } else {
            throw new Exception("Такого статуса нет");
        }
    }

    /**
     * Функция получения значения полей объекта Приказ ({@link Order#employee}, {@link Order#text}, {@link Order#status}) и полей родительского объекта {@link Document}
     * @return возвращает поля объектов Приказ и Документ
     */
    public String getOrder(){
        return this.getDocument() +
                (this.simple == 'y' ? "" :
                ", employee='" + employee + '\'' +
                ", text='" + text + '\'' +
                ", status='" + status + '\'');
    }

    @Override
    public String toString() {
        return "Order{" +
                this.getDocument() +
                (this.simple == 'y' ? "" :
                        ", employee='" + employee + '\'' +
                        ", text='" + text + '\'' +
                        ", status='" + status + '\''
                )
                + '}';
    }
}
