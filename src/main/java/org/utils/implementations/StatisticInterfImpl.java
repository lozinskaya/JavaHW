package org.utils.implementations;

import org.model.*;
import org.utils.interfaces.StatisticInterf;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс статистики
 */
public class StatisticInterfImpl implements StatisticInterf {
    private HashMap<String, Integer> resultDoc = new HashMap<>();
    private HashMap<String, Integer> resultEmp = new HashMap<>();

    /**
     * Метод для вычисления кол-ва документов в разрезе типов документов
     * @param documents список документов
     */
    @Override
    public void countDocByType(List<Document> documents) {
        Integer countLetters = Math.toIntExact(documents.stream().filter(i -> i instanceof Letter).count());
        resultDoc.put("Количество писем ", countLetters);

        Integer countOrdersAccept = Math.toIntExact(documents.stream().filter(i -> i instanceof OrderAcceptanceToWork).count());
        resultDoc.put("Количество приказов о приёме на работу ", countOrdersAccept);

        Integer countOrdersDismiss = Math.toIntExact(documents.stream().filter(i -> i instanceof OrderDismissal).count());
        resultDoc.put("Количество приказов на увольнение ", countOrdersDismiss);

        output("countDocByType.txt", resultDoc);
    }

    /**
     * Метод для вычисления кол-ва приказов для каждого сотрудника
     * @param employees список сотрудников
     * @param documents список документов
     */
    @Override
    public void countEmployees(List<Employee> employees, List<Document> documents) {
        List<Order> orders = (List) documents.stream().filter(i -> i instanceof Order).collect(Collectors.toList());

        int count;
        for (Employee employee : employees) {
            count = (int) orders.stream().filter(i -> i.getEmployee().equals(employee.getFullName())).count();
            resultEmp.put(employee.getFullName(), count);
            employee.setCountOrders(count);
        }

        output("countEmployees.txt", resultEmp);
    }

    /**
     * Метод для вывода результатов выичслений в файл
     * @param fileName название файла
     * @param result данные для вывода
     */
    @Override
    public void output(String fileName, HashMap<String, Integer> result) {
        try(FileWriter writer = new FileWriter(fileName, false))
        {
            for (Map.Entry entry: result.entrySet()) {
                writer.write((String) entry.getKey() + entry.getValue());
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
