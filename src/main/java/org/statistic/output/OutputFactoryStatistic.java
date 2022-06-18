package org.statistic.output;

import org.statistic.output.implementations.OutputToConsole;
import org.statistic.output.implementations.OutputToFile;
import org.statistic.output.interfaces.OutputStatisticnterf;

/**
 * Фабрика для определения формата вывода статистики
 */
public class OutputFactoryStatistic {

    public static OutputStatisticnterf getOutput(String to) {
        if (to.equals("file")) {
            return new OutputToFile();
        }
        if (to.equals("console")) {
            return new OutputToConsole();
        }
        throw new IllegalArgumentException("Неверный тип вывода");
    }
}
