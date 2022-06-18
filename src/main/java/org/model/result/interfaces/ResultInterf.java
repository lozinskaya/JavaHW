package org.model.result.interfaces;

import java.util.List;

/**
 * Интерфейс для вывода информации
 */
public interface ResultInterf {

    /**
     * Метод для вывода информации
     *
     * @param elements список элементов
     * @param title    название элементов
     * @param <T>      тип элементов
     */
    public <T> void print(List<T> elements, String title);
}
