package com.example.project.extension;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class EmployeeDaoParameterResolver implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        System.out.println("EmployeeDaoParameterResolver supportsParameter is called.");
        return parameterContext.getParameter().getType().equals(EmployeeJdbcDao.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        System.out.println("EmployeeDaoParameterResolver resolveParameter is called.");
        return new EmployeeJdbcDao(JdbcConnectionUtil.getConnection());
    }

}
