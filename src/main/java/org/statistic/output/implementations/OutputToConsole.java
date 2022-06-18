package org.statistic.output.implementations;

import org.statistic.output.interfaces.OutputStatisticnterf;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс для вывода статистики в консоль
 */
public class OutputToConsole implements OutputStatisticnterf {
    @Override
    public void output(HashMap<String, Integer> result, String title) {
        System.out.println(title + ':');
        for (Map.Entry entry : result.entrySet()) {
            System.out.println((String) entry.getKey() + ' ' + entry.getValue());
        }
    }
}
