package com.cognizant.jpademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpAvsHibernateDemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(JpAvsHibernateDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Employee employee = new Employee("Manish", 50000);

        employeeService.addEmployee(employee);

    }
}