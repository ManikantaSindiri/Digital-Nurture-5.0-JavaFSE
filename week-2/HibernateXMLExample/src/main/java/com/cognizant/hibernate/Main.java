package com.cognizant.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Create SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // 2. Open Session
        Session session = factory.openSession();

        // -------------------------------
        // INSERT
        // -------------------------------
        Transaction tx1 = session.beginTransaction();

        Employee emp1 = new Employee(101, "Manish", 50000);

        session.persist(emp1);

        tx1.commit();

        System.out.println("\nEmployee Inserted Successfully!");

        // -------------------------------
        // GET BY ID
        // -------------------------------
        Employee employee = session.get(Employee.class, 101);

        System.out.println("\nEmployee Found:");
        System.out.println(employee);

        // -------------------------------
        // GET ALL
        // -------------------------------
        System.out.println("\nAll Employees:");

        List<Employee> employees =
                session.createQuery("from Employee", Employee.class)
                        .list();

        for (Employee e : employees) {
            System.out.println(e);
        }

        // -------------------------------
        // DELETE
        // -------------------------------
        Transaction tx2 = session.beginTransaction();

        Employee deleteEmployee = session.get(Employee.class, 101);

        if (deleteEmployee != null) {
            session.remove(deleteEmployee);
            tx2.commit();
            System.out.println("\nEmployee Deleted Successfully!");
        } else {
            tx2.rollback();
            System.out.println("\nEmployee Not Found!");
        }

        // -------------------------------
        // ROLLBACK DEMO
        // -------------------------------
        Transaction tx3 = session.beginTransaction();

        try {

            Employee emp2 = new Employee(102, "Rahul", 60000);

            session.persist(emp2);

            // Intentional Exception
            int x = 10 / 0;

            tx3.commit();

        } catch (Exception e) {

            System.out.println("\nException Occurred!");

            tx3.rollback();

            System.out.println("Transaction Rolled Back!");
        }

        // -------------------------------
        // FINAL EMPLOYEE LIST
        // -------------------------------
        System.out.println("\nFinal Employee List:");

        List<Employee> finalList =
                session.createQuery("from Employee", Employee.class)
                        .list();

        for (Employee e : finalList) {
            System.out.println(e);
        }

        session.close();
        factory.close();

        System.out.println("\nProgram Completed Successfully!");
    }
}