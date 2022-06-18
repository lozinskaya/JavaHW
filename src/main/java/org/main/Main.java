package org.main;

import org.model.*;
import org.model.result.ResultFactory;
import org.source.implementations.EmployeeInterfImpl;
//import org.dao.implementations.OrderAcceptanceToWorkInterfImpl;
//import org.dao.interfaces.OrderAcceptanceToWorkInterf;
import org.jdbc.PostgreSQLConnUtils;
import org.source.implementations.SourceInterfImpl;
import org.source.interfaces.EmployeeInterf;
import org.source.interfaces.SourceInterf;
import org.menu.implementations.MenuInterfImpl;
import org.statistic.implementations.StatisticInterfImpl;
import org.menu.interfaces.MenuInterf;
import org.model.result.interfaces.ResultInterf;
import org.statistic.interfaces.StatisticInterf;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        char simple;
        try {
            MenuInterf menu = new MenuInterfImpl();
            menu.run();

            ResultInterf resultInterf = ResultFactory.getResult(menu.getResultTo());

            Connection conn = PostgreSQLConnUtils.getMySQLConnection();

            SourceInterf sourceInterf = new SourceInterfImpl(conn, menu.getSimple());
            List<Document> documents = sourceInterf.fetchData();

            EmployeeInterf employeeInterf = new EmployeeInterfImpl(conn);
            List<Employee> employees = employeeInterf.findAll();

            StatisticInterf statistic = new StatisticInterfImpl(menu.getOutputTo());
            statistic.countDocByType(documents);
            statistic.countEmployees(employees, documents);

            resultInterf.print(documents, "Документы");
            resultInterf.print(employees, "Сотрудники");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}