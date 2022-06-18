package org.model.result.implementations;

import org.model.result.interfaces.ResultInterf;

import java.util.List;

/**
 * Класс для вывода данных в консоль
 */
public class ResultToConsole implements ResultInterf {
    @Override
    public <T> void print(List<T> elements, String title) {
        System.out.println(title + ':');
        for (T element : elements) {
            System.out.println(element);
        }
    }
}
