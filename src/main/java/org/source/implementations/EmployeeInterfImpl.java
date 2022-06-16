package org.source.implementations;

import org.model.Employee;
import org.source.interfaces.EmployeeInterf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeInterfImpl implements EmployeeInterf {
    /** Соединение с БД */
    private Connection conn;

    public EmployeeInterfImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Employee> findAll() {
        String SQL_SELECT = "Select firstname, lastname, middlename from javahw.public.employees";
        List<Employee> result = new ArrayList<>();
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    String firstname = resultSet.getString("firstname");
                    String lastname = resultSet.getString("lastname");
                    String middlename = resultSet.getString("middlename");

                    Employee employee = new Employee(firstname, lastname, middlename);
                    result.add(employee);
                }

            } catch (SQLException e) {
                System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
            }
        return result;
    }
}
