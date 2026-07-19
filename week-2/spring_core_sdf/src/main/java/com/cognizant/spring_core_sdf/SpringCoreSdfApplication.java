package com.cognizant.spring_core_sdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringCoreSdfApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringCoreSdfApplication.class, args);

        displayDate();
    }

    public static void displayDate() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("date-format.xml");

        SimpleDateFormat format =
                context.getBean("dateFormat",
                        SimpleDateFormat.class);

        try {

            Date today = new Date();

            System.out.println("Today's Date: " + format.format(today));

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}