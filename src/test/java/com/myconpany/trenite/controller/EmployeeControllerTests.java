package com.myconpany.trenite.controller;

import com.myconpany.trenite.entity.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeControllerTests {

    @Autowired
    private EmployeeController employeeController;

    @Test
    @DisplayName("Get all employees end point")
    void testGetAllEmployees() {

        List<Employee> all = employeeController.all();
        assertFalse(all.isEmpty());
    }
}
