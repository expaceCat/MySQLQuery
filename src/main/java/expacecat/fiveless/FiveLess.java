package expacecat.fiveless;

import expacecat.Auth;

import java.sql.*;

public class FiveLess {

    private static final String FINAL_REQUEST = "select name from customers left join orders " +
            "on customers.id = orders.customerId " +
            "where orders.customerId is null;";


    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(Auth.URL,Auth.USERNAME,Auth.PASSWORD);
             Statement statement = connection.createStatement()){
//            statement.execute("CREATE TABLE Customers (id int, name varchar(255));");
//            statement.execute("CREATE TABLE Orders (id int, customerId int);");
//            statement.execute("INSERT INTO Customers (id, name) values (1, 'Joe');");
//            statement.execute("INSERT INTO Customers (id, name) values (2, 'Henry');");
//            statement.execute("INSERT INTO Customers (id, name) values (3, 'Sam');");
//            statement.execute("INSERT INTO Customers (id, name) values (4, 'Max');");
//            statement.execute("INSERT INTO Orders (id, customerId) values (1, 3);");
//            statement.execute("INSERT INTO Orders (id, customerId) values (2, 1);");

            ResultSet res = statement.executeQuery(FINAL_REQUEST);

            while (res.next()) {
                System.out.println("Customers without orders = " + res.getString("name"));
            }






        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
