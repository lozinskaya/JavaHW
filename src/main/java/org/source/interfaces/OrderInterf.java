package org.source.interfaces;

import org.source.implementations.LetterInterfImpl;
import org.source.implementations.OrderInterfImpl;

import java.sql.Connection;
import java.util.List;

/**
 * Интерфейс для работы с приказами в БД с методом <b>findAll</b>.
 * @author Наталья Лозинская
 * @version 1.0
 */
public interface OrderInterf<T> {

    /**
     * Метод для получения приказов
     * @param type тип приказа
     * @see OrderInterfImpl#findAll
     */
    public List<T> findAll(String type) throws InstantiationException, IllegalAccessException;

    /**
     * Метод для определения класса выгружаемых объектов
     * @param targetClass класс объектов
     */
    public void setTargetClass(Class<T> targetClass);
}
