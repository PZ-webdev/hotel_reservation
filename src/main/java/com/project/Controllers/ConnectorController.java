package com.project.Controllers;

import java.sql.*;

public class ConnectorController {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";
    private static final String DB_NAME = "hotel_reservation";
    private static final String URL = "jdbc:mysql://localhost/" + DB_NAME;
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args) {
        // Driver database
        try{
            Class.forName(DRIVER);
            System.out.println("Zarejestrowano sterownik");
        }catch (ClassNotFoundException e) {
            System.out.println("Niewłaśnicy sterownik JDBC lub jego brak..");
            e.printStackTrace();
        }

        // Connect to database
        try{
            connection = DriverManager.getConnection(URL, DB_USER, DB_PASS);
            System.out.println("Nawiązano połączenie z bazą danych");
        }catch (SQLException e) {
            System.out.println("Problem z otwarciem połączenia...");
            e.printStackTrace();
        }
    }
}
