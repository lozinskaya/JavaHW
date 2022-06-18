package org.source.implementations;

import org.model.Document;
import org.model.Letter;
import org.model.OrderAcceptanceToWork;
import org.model.OrderDismissal;
import org.source.interfaces.LetterInterf;
import org.source.interfaces.OrderInterf;
import org.source.interfaces.SourceInterf;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для получения всех документов из БД
 */
public class SourceInterfImpl implements SourceInterf {
    /**
     * Соединение с БД
     */
    private final Connection conn;
    /**
     * Формат вывода
     */
    private final char simple;
    List<Document> Documents = new ArrayList<>();

    public SourceInterfImpl(Connection conn, char simple) {
        this.conn = conn;
        this.simple = simple;
    }

    /**
     * Методы для получения докуметнов из БД
     *
     * @return Список документов (приказы и письма)
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Override
    public List<Document> fetchData() throws InstantiationException, IllegalAccessException {
        LetterInterf letterInterf = new LetterInterfImpl(conn, simple);
        List<Letter> letters = letterInterf.findAll();
        Documents.addAll(letters);

        OrderInterf orderInterf = new OrderInterfImpl(conn, simple, OrderAcceptanceToWork.class);
        List<OrderAcceptanceToWork> ordersAccept = orderInterf.findAll("accept");
        Documents.addAll(ordersAccept);

        orderInterf.setTargetClass(OrderDismissal.class);
        List<OrderDismissal> ordersDismiss = orderInterf.findAll("dismiss");
        Documents.addAll(ordersDismiss);

        return Documents;
    }
}
