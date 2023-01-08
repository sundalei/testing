package com.example.project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.example.project.extension.EnvironmentExtension;

@ExtendWith(EnvironmentExtension.class)
public class MyTest {

    @Test
    public void testMethod() {

    }
    
}
