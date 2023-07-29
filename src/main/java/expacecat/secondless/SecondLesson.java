package expacecat.secondless;

import expacecat.Auth;

import java.sql.*;

public class SecondLesson {

    private static String FINAL_REQUEST = "SELECT * FROM employee ORDER BY salary ASC LIMIT 1, 1;";

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(Auth.URL,Auth.USERNAME,Auth.PASSWORD);
            Statement statement = connection.createStatement()) {

            statement.execute("CREATE TABLE employee(id int, salary int);");
            statement.execute("INSERT INTO employee(id,salary) VALUES (1,100);");
            statement.execute("INSERT INTO employee(id,salary) VALUES (2,200);");
            statement.execute("INSERT INTO employee(id,salary) VALUES (3,300);");

            ResultSet res = statement.executeQuery(FINAL_REQUEST);
            while (res.next()) {
                System.out.println("Id = " + res.getString("id"));
                System.out.println("Salary = " + res.getString("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
