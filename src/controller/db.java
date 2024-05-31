package controller;

import java.sql.*;

public class db {
    static final String Database = "jdbc:mysql://localhost:3306/dbjava";
    public static Connection conn;
    public static Statement statement;
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;

    public static void connection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(Database, "root", "");
        } catch (ClassNotFoundException | SQLException e){
            System.out.println("Gagal Menghubungkan Ke Database " + e.getMessage());
        }
    }
}
