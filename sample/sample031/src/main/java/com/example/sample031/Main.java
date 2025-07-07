package com.example.sample031;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb",
                "myuser",
                "mypass");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM member");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            var user = new Member(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getInt("age"));
            System.out.println(user);
        }
        connection.close();
    }
}
