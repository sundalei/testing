package com.example.project.extension;

import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class EnvironmentExtension implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        
        Properties props = new Properties();
        try {
            props.load(EnvironmentExtension.class.getResourceAsStream("/application.properties"));
            String env = props.getProperty("env");
            System.out.println("env: " + env);
            if ("qa".equalsIgnoreCase(env)) {
                return ConditionEvaluationResult.disabled("Test disabled on QA environment");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ConditionEvaluationResult.enabled("Test enabled on QA environment");
    }
    
}
