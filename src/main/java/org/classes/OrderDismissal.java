package org.classes;

/**
 * Класс Приказ об увольнении со свойством <b>reasonDismissal</b>.
 * @author Наталья Лозинская
 * @version 1.0
 */
public class OrderDismissal extends Order{

    /** Поле причина увольнения*/
    private String reasonDismissal;

    /**
     * Конструктор - создание нового объекта "Приказ об увольнении"
     * @param number номер документа
     * @param simple формат вывода
     * @param employee сотрудник
     * @see Order#Order(int, char, String)
     */
    public OrderDismissal(int number, char simple, String employee) {
        super(number, simple, employee);
    }

    /**
     * Функция получения значения поля {@link OrderDismissal#reasonDismissal}
     * @return возвращает причину увольнения
     */
    public String getReasonDismissal() {
        return reasonDismissal;
    }

    /**
     * Процедура определения причины увольнения {@link OrderDismissal#reasonDismissal}
     * @param reasonDismissal причина увольнения
     */
    public void setReasonDismissal(String reasonDismissal) {
        this.reasonDismissal = reasonDismissal;
    }


    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public void setText(String text) {
        super.setText(text);
    }

    @Override
    public void setStatus(String status) throws Exception {
        super.setStatus(status);
    }

    @Override
    public String toString() {
        return "OrderDismissal{" +
                this.getOrder() +
                (this.simple == 'y' ? "" :
                        ", reasonDismissal='" + reasonDismissal + '\''
                )
                + '}';
    }
}
