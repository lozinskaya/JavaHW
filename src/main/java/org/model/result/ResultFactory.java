package org.model.result;

import org.model.result.implementations.ResultToConsole;
import org.model.result.implementations.ResultToFile;
import org.model.result.interfaces.ResultInterf;

/**
 * Фабрика для определения формата вывода данных
 */
public class ResultFactory {
    public static ResultInterf getResult(String to) {
        if (to.equals("file")) {
            return new ResultToFile();
        }
        if (to.equals("console")) {
            return new ResultToConsole();
        }
        throw new IllegalArgumentException("Неверный тип вывода");
    }
}
