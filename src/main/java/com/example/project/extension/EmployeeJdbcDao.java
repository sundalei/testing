package com.example.project.extension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJdbcDao {

    private Connection connection;

    public EmployeeJdbcDao(Connection connection) {
        this.connection = connection;
    }

    public void createTable() throws SQLException {
        String createQuery = "CREATE TABLE IF NOT EXISTS employees(id BIGINT PRIMARY KEY, first_name VARCHAR(50));";
        PreparedStatement pstmt = connection.prepareStatement(createQuery);

        pstmt.execute();
    }

    public void add(Employee employee) throws SQLException {
        String insertQuery = "INSERT INTO employees(id, first_name) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setLong(1, employee.getId());
        preparedStatement.setString(2, employee.getFirstName());

        preparedStatement.executeUpdate();
    }

    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM employees";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setFirstName(rs.getString("first_name"));
            employees.add(employee);
        }

        return employees;
    }
}
