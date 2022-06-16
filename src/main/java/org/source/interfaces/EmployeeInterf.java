package org.source.interfaces;

import org.model.Employee;
import org.source.implementations.EmployeeInterfImpl;

import java.sql.Connection;
import java.util.List;

/**
 * Интерфейс для работы с сотрудниками в БД
 */
public interface EmployeeInterf {
    /**
     * Метод для получения всех  сотрудников
     * @see EmployeeInterfImpl#findAll
     */
    public List<Employee> findAll();
}
