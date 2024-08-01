package org.AshInc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/*
Restaurant Management System

Key Features:
- **Order Management:**
The system should allow for the recording,
tracking, and management of orders placed in the restaurant.
This includes the ability to assign orders to tables and monitor their status.

- **Menu Management:**
An intuitive interface for adding, updating,
and removing items from the menu.
The system should be able to handle different categories,
pricing, and descriptions for each item.

- **Table Management:**
The system should provide a clear overview of the restaurant layout,
indicating which tables are occupied,
the status of orders placed, and potentially even allowing for table reservations.

insert into table_rest(category,count,hall,number) values('PAIR',2,1,'1A');
 */
