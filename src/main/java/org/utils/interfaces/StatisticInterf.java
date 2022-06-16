package org.utils.interfaces;

import org.model.Document;
import org.model.Employee;

import java.util.HashMap;
import java.util.List;

public interface StatisticInterf {
    public void countDocByType(List<Document> documents);

    public void countEmployees(List<Employee> employees, List<Document> documents);

    public void print(String fileName, HashMap<String, Integer> result);
}
