package expacecat.fourthless;

import expacecat.Auth;

import java.sql.*;

public class FourthLesson {

    private static final String FINAL_REQUEST = " select email from person group by email" +
            " having count(email) >= 2;";

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(Auth.URL,Auth.USERNAME,Auth.PASSWORD);
             Statement statement = connection.createStatement()){

//            statement.execute("CREATE TABLE person (id int, email varchar(255))");

//            statement.execute("INSERT INTO person (id,email) VALUES (1,'a@b.com')");
//            statement.execute("INSERT INTO person (id,email) VALUES (2,'b@b.com')");
//            statement.execute("INSERT INTO person (id,email) VALUES (3,'c@b.com')");

            ResultSet res = statement.executeQuery(FINAL_REQUEST);
            while (res.next()) {
                System.out.println("Duplicate emails in table = " + res.getString("email"));
            }





        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
