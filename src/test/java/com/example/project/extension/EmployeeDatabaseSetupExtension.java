package com.example.project.extension;

import java.sql.Connection;
import java.sql.Savepoint;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class EmployeeDatabaseSetupExtension implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {

    private Connection connection;
    private EmployeeJdbcDao employeeJdbcDao;
    private Savepoint savepoint;

    public EmployeeDatabaseSetupExtension() {
        this.connection = JdbcConnectionUtil.getConnection();
        employeeJdbcDao = new EmployeeJdbcDao(connection);
    }

    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("EmployeeDatabaseSetupExtension beforeEach is called.");
        connection.setAutoCommit(false);
        savepoint = connection.setSavepoint("before");
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        
    }

    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        System.out.println("EmployeeDatabaseSetupExtension beforeAll is called.");
        employeeJdbcDao.createTable();
    }
    
}
