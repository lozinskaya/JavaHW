package org.utils.implementations;

import org.model.OrderAcceptanceToWork;
import org.utils.interfaces.ResultInterf;

import java.util.List;

/**
 * Класс для вывода информации
 */
public class ResultInterfImpl implements ResultInterf {

    @Override
    public <T> void print(List<T> elements) {
        for (T element : elements) {
            System.out.println(element);
        }
    }
}
