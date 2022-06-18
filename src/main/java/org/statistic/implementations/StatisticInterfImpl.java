package org.statistic.implementations;

import org.model.*;
import org.statistic.output.interfaces.OutputStatisticnterf;
import org.statistic.output.OutputFactoryStatistic;
import org.statistic.interfaces.StatisticInterf;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс статистики
 */
public class StatisticInterfImpl implements StatisticInterf {
    private final HashMap<String, Integer> resultDoc = new HashMap<>();
    private final HashMap<String, Integer> resultEmp = new HashMap<>();
    private final OutputStatisticnterf outputInterf;

    public StatisticInterfImpl(String outputType) {
        this.outputInterf = OutputFactoryStatistic.getOutput(outputType);
    }

    /**
     * Метод для вычисления кол-ва документов в разрезе типов документов
     *
     * @param documents список документов
     */
    @Override
    public void countDocByType(List<Document> documents) throws IOException {
        Integer countLetters = Math.toIntExact(documents.stream().filter(i -> i instanceof Letter).count());
        resultDoc.put("Количество писем ", countLetters);

        Integer countOrdersAccept = Math.toIntExact(documents.stream().filter(i -> i instanceof OrderAcceptanceToWork).count());
        resultDoc.put("Количество приказов о приёме на работу ", countOrdersAccept);

        Integer countOrdersDismiss = Math.toIntExact(documents.stream().filter(i -> i instanceof OrderDismissal).count());
        resultDoc.put("Количество приказов на увольнение ", countOrdersDismiss);

        outputInterf.output(resultDoc, "Стастистика по документам");
    }

    /**
     * Метод для вычисления кол-ва приказов для каждого сотрудника
     *
     * @param employees список сотрудников
     * @param documents список документов
     */
    @Override
    public void countEmployees(List<Employee> employees, List<Document> documents) throws IOException {
        List<Order> orders = (List) documents.stream().filter(i -> i instanceof Order).collect(Collectors.toList());

        int count;
        for (Employee employee : employees) {
            count = (int) orders.stream().filter(i -> i.getEmployee().equals(employee.getFullName())).count();
            resultEmp.put(employee.getFullName(), count);
            employee.setCountOrders(count);
        }

        outputInterf.output(resultEmp, "Статистика по сотрудникам");
    }
}
