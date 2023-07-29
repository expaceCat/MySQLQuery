package expacecat.firstless;

import expacecat.Auth;

import java.sql.*;

public class FirstLesson {

     private static String CREATE_TABLE_PERSON = "CREATE TABLE person (" +
            "person_id INT NOT NULL UNIQUE PRIMARY KEY ," +
            "first_name varchar(255) NOT NULL, " +
            "last_name varchar(255) NOT NULL" +");";

    private static String CREATE_TABLE_ADRESS = "CREATE TABLE address (" +
            "address_id int NOT NULL UNIQUE AUTO_INCREMENT PRIMARY KEY, " +
            "person_id int NOT NULL UNIQUE, " +
            "city varchar(255), " +
            "state varchar(255)"
            + ");";
    private static String FINAL_REQUEST = "SELECT first_name, last_name, city, state FROM person LEFT " +
            "JOIN address ON person.person_id = address.person_id;";

    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection(Auth.URL,Auth.USERNAME,Auth.PASSWORD);
            Statement statement = connection.createStatement()) {
            statement.execute(CREATE_TABLE_PERSON);
            statement.execute(CREATE_TABLE_ADRESS);
            statement.execute("INSERT INTO person (person_id, first_name, last_name) VALUES (1,'Vang','Allen');");
            statement.execute("INSERT INTO address (address_id, person_id, city, state) VALUES (1,2,'New York City', 'New York');");

            ResultSet res = statement.executeQuery(FINAL_REQUEST);

            while (res.next()) {
              System.out.println("First name = " + res.getString("first_name"));
              System.out.println("Last name = " + res.getString("last_name"));
              System.out.println("City = " + res.getString("city"));
              System.out.println("State = " + res.getString("state"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
