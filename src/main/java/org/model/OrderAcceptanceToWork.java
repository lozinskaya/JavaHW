package org.model;

/**
 * Класс Приказ о приеме на работу со свойствами родительского класса {@link Order}.
 * @author Наталья Лозинская
 * @version 1.0
 */
public class OrderAcceptanceToWork extends Order{

    /**
     * Конструктор - создание нового объекта "Приказ о приеме на работу"
     * @param number номер документа
     * @param simple формат вывода
     * @param employee сотрудник
     * @see Order#Order(int, char, String)
     */
    public OrderAcceptanceToWork(int number, char simple, String employee) {
        super(number, simple, employee);
    }

    @Override
    public void setText(String text) {
        super.setText(text);
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public void setStatus(String status) throws Exception {
        super.setStatus(status);
    }
}
