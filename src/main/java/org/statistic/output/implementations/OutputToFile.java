package org.statistic.output.implementations;

import org.statistic.output.interfaces.OutputStatisticnterf;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для вывода сатистики в файл
 */
public class OutputToFile implements OutputStatisticnterf {
    private final String type = ".txt";

    @Override
    public void output(HashMap<String, Integer> result, String title) {
        try (FileWriter writer = new FileWriter(title + type, false)) {
            for (Map.Entry entry : result.entrySet()) {
                writer.write((String) entry.getKey() + ' ' + entry.getValue());
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
