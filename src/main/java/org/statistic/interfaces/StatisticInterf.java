package org.statistic.interfaces;

import org.model.Document;
import org.model.Employee;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * Интерфейс статистики
 */
public interface StatisticInterf {
    /**
     * Вычисление статистики по типу документов
     *
     * @param documents список документов
     * @throws IOException
     */
    public void countDocByType(List<Document> documents) throws IOException;

    /**
     * Вычисление статистики в разрезе сотрудников
     *
     * @param employees список сотрудников
     * @param documents список локументов
     * @throws IOException
     */
    public void countEmployees(List<Employee> employees, List<Document> documents) throws IOException;
}
