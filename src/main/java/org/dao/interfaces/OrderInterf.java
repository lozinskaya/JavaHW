package org.dao.interfaces;

import org.dao.implementations.OrderInterfImpl;

import java.util.List;

/**
 * Интерфейс объекта Приказ с методом <b>findAll</b>.
 * @author Наталья Лозинская
 * @version 1.0
 */
public interface OrderInterf<T> {

    // Найти все приказы по заданному типу.
    /**
     * Интерфейс для получения приказов
     * @param type тип приказа
     * @see OrderInterfImpl#findAll
     */
    public List<T> findAll(String type) throws InstantiationException, IllegalAccessException;

    public void countEmployers();
}
