package org.statistic.output.interfaces;

import java.io.IOException;
import java.util.HashMap;

/**
 * Интерфейс для вывода статистики
 */
public interface OutputStatisticnterf {
    /**
     * Метод для вывода статистики
     *
     * @param result результат вычислений
     * @param title  название вычислений
     * @throws IOException
     */
    public void output(HashMap<String, Integer> result, String title) throws IOException;
}
