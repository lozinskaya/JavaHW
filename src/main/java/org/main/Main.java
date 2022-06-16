package org.main;
import org.model.*;
import org.source.implementations.EmployeeInterfImpl;
import org.source.implementations.LetterInterfImpl;
//import org.dao.implementations.OrderAcceptanceToWorkInterfImpl;
import org.source.implementations.OrderInterfImpl;
//import org.dao.interfaces.OrderAcceptanceToWorkInterf;
import org.jdbc.PostgreSQLConnUtils;
import org.source.implementations.SourceInterfImpl;
import org.source.interfaces.EmployeeInterf;
import org.source.interfaces.LetterInterf;
import org.source.interfaces.OrderInterf;
import org.source.interfaces.SourceInterf;
import org.utils.implementations.MenuInterfImpl;
import org.utils.implementations.ResultInterfImpl;
import org.utils.implementations.StatisticInterfImpl;
import org.utils.interfaces.ResultInterf;
import org.utils.interfaces.StatisticInterf;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        char simple;
        try {
            MenuInterfImpl menu = new MenuInterfImpl();
            simple = menu.run();

            ResultInterf resultInterf = new ResultInterfImpl();

            Connection conn = PostgreSQLConnUtils.getMySQLConnection();

            SourceInterf sourceInterf = new SourceInterfImpl(conn, simple);
            List<Document> documents = sourceInterf.fetchData();

            EmployeeInterf employeeInterf = new EmployeeInterfImpl(conn);
            List<Employee> employees = employeeInterf.findAll();

            StatisticInterf statistic = new StatisticInterfImpl();
            statistic.countDocByType(documents);
            statistic.countEmployees(employees, documents);

            resultInterf.print(documents);
            resultInterf.print(employees);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}