package org.model;

/**
 * Класс Письмо со свойствами <b>from</b> и <b>to</b>.
 * @author Наталья Лозинская
 * @version 1.0
 */
public class Letter extends Document{

    /** Поле от кого письмо */
    private String from;
    /** Поле кому письмо */
    private String to;

    /**
     * Конструктор - создание нового объекта "Письмо"
     * @param number номер документа
     * @param simple формат вывода
     * @see Document#Document(int, char)
     */
    public Letter(int number, char simple) {
        super(number, simple);
    }

    /**
     * Функция получения значения поля {@link Letter#from}
     * @return возвращает от кого письмо
     */
    public String getFrom() {
        return from;
    }

    /**
     * Процедура определения адресанта письма {@link Letter#from}
     * @param from адресант
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Функция получения значения поля {@link Letter#to}
     * @return возвращает кому письмо
     */
    public String getTo() {
        return to;
    }

    /**
     * Процедура определения адресата письма {@link Letter#to}
     * @param to адресат
     */
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
