package org.model.result.implementations;

import org.model.result.interfaces.ResultInterf;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Класс для вывода данных в файл
 */
public class ResultToFile implements ResultInterf {
    private final String type = ".txt";

    @Override
    public <T> void print(List<T> elements, String title) {
        try (FileWriter writer = new FileWriter(title + type, false)) {
            for (T element : elements) {
                writer.write(element.toString());
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
