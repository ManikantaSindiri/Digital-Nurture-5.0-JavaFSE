package com.cognizant.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        // Create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // Open Session
        Session session = factory.openSession();

        // Begin Transaction
        Transaction transaction = session.beginTransaction();

        // Create Employee Object
        Employee employee = new Employee("Manish", 50000);

        // Save Employee
        session.persist(employee);

        // Commit Transaction
        transaction.commit();

        System.out.println("Employee Inserted Successfully!");
        System.out.println(employee);

        // Close Resources
        session.close();
        factory.close();
    }
}