package org.utils.implementations;

import org.model.*;
import org.utils.interfaces.StatisticInterf;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticInterfImpl implements StatisticInterf {
    private HashMap<String, Integer> resultDoc = new HashMap<>();
    private HashMap<String, Integer> resultEmp = new HashMap<>();
    private Integer countLetters = 0;
    private Integer countOrdersAccept = 0;
    private Integer countOrdersDismiss = 0;
    private Integer countOrders = 0;

    @Override
    public void countDocByType(List<Document> documents) {
        countLetters = Math.toIntExact(documents.stream().filter(i -> i instanceof Letter).count());
        resultDoc.put("Количество писем ", countLetters);

        countOrdersAccept = Math.toIntExact(documents.stream().filter(i -> i instanceof OrderAcceptanceToWork).count());
        resultDoc.put("Количество приказов о приёме на работу ", countOrdersAccept);

        countOrdersDismiss = Math.toIntExact(documents.stream().filter(i -> i instanceof OrderDismissal).count());
        resultDoc.put("Количество приказов на увольнение ", countOrdersDismiss);

        print("countDocByType.txt", resultDoc);
    }

    @Override
    public void countEmployees(List<Employee> employees, List<Document> documents) {
        List<Order> orders = (List) documents.stream().filter(i -> i instanceof Order).collect(Collectors.toList());

        int count;
        for (Employee employee : employees) {
            count = (int) orders.stream().filter(i -> i.getEmployee().equals(employee.getFullName())).count();
            resultEmp.put(employee.getFullName(), count);
            employee.setCountOrders(count);
        }


        print("countEmployees.txt", resultEmp);
    }

    @Override
    public void print(String fileName, HashMap<String, Integer> result) {
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
