package com.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        /* 
            Import packages
            load driver
            register driver
            establish connection
            create statement
            execute statement
            close connection
        */

        String url = "jdbc:postgres://localhost:3000/demo";
        String uname = "postgres";
        String pwd = "0000";
        
        String query = "select * from students";
        
        String createQuery = "insert into student values (5, 'John', 48)";
        String updateQuery = "update student set sname = 'Max' where sid = 5";
        String deleteQuery = "delete from student where sid = 5";

        // Class.forName("org.postgresql.Driver");

        // establish connection
        // // try-with-resources so the connection closes automatically, no need of conn.close()
        try (
            Connection conn = DriverManager.getConnection(url,uname,pwd);
            // create statement
            Statement stmt = conn.createStatement();
            // execute statement
            ResultSet rs = stmt.executeQuery(query);
            ) {
            System.out.println("Connection established!");

            while (rs.next()) {
                System.out.println(rs.getString("username")); // or can also provide columnIndex
            }

            stmt.execute(createQuery);
            stmt.execute(updateQuery);
            stmt.execute(deleteQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}