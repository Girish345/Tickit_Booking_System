// package com.company;

import java.sql.*;

public class sql {
    Statement stmt;
    Connection con;

    sql() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "travel", "tour");
            stmt = con.createStatement();
            // con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
