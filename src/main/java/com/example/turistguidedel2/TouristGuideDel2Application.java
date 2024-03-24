package com.example.turistguidedel2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class TouristGuideDel2Application {

    public static void main(String[] args) throws SQLException {

        SpringApplication.run(TouristGuideDel2Application.class, args);

    }

}
