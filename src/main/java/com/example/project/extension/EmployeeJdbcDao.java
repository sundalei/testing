package com.example.project.extension;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeJdbcDao {

    private Connection connection;

    public EmployeeJdbcDao(Connection connection) {
        this.connection = connection;
    }

    public void createTable() throws SQLException {
        // create employee table
    }

    public void add(Employee employee) throws SQLException {
        // add employee record
    }

    public List<Employee> findAll() throws SQLException {
        // query all employee records
        return null;
    }
}
