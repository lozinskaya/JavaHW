package org.utils.interfaces;

import org.model.Document;
import org.model.Employee;

import java.util.HashMap;
import java.util.List;

/**
 * Интерфейс статистики
 */
public interface StatisticInterf {
    public void countDocByType(List<Document> documents);

    public void countEmployees(List<Employee> employees, List<Document> documents);

    public void output(String fileName, HashMap<String, Integer> result);
}
