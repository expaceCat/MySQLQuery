package expacecat.sixless;

import expacecat.Auth;

import java.sql.*;

public class SixLesson {

    private static String FINAL_REQUEST = "SELECT class FROM courses " +
            "group by class " +
            "having count(class) >= 5;";

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(Auth.URL,Auth.USERNAME,Auth.PASSWORD);
            Statement statement = connection.createStatement()) {

//            statement.execute("CREATE TABLE courses (student varchar(255), class varchar(255));");
            ResultSet res = statement.executeQuery(FINAL_REQUEST);
            while (res.next()) {
                System.out.println("classes which have more than or equal to 5 students = " + res.getString("class"));
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
