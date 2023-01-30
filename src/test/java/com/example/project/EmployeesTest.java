package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LoggingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.example.project.extension.Employee;
import com.example.project.extension.EmployeeDaoParameterResolver;
import com.example.project.extension.EmployeeDatabaseSetupExtension;
import com.example.project.extension.EmployeeJdbcDao;
import com.example.project.extension.EnvironmentExtension;
import com.example.project.extension.IgnoreFileNotFoundExceptionExtension;
import com.example.project.extension.LoggingExtension;

@ExtendWith({EnvironmentExtension.class, EmployeeDatabaseSetupExtension.class, EmployeeDaoParameterResolver.class})
@ExtendWith(LoggingExtension.class)
@ExtendWith(IgnoreFileNotFoundExceptionExtension.class)
public class EmployeesTest {
    
    private EmployeeJdbcDao employeeDao;
    private Logger logger;

    public EmployeesTest(EmployeeJdbcDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Test
    public void whenAddEmployee_thenGetEmployee() throws SQLException {
        Employee emp = new Employee(1, "john");
        employeeDao.add(emp);
        assertEquals(1, employeeDao.findAll().size());
    }

    @Test
    public void whenGetEmployees_thenEmployeeList() throws SQLException {
        assertEquals(0, employeeDao.findAll().size());
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
