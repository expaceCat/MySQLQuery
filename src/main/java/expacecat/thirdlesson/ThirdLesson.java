package expacecat.thirdlesson;

import expacecat.Auth;

import java.sql.*;

public class ThirdLesson {

    private static final String FINAL_REQUEST = "select t1.name from employee t1 inner join employee t2 " +
            "on t2.id = t1.managerid" +
            "where" +
            "t1.salary > t2.salary;";


    public static void main(String[] args) {


        try(Connection connection = DriverManager.getConnection(Auth.URL,Auth.USERNAME,Auth.PASSWORD);
            Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABlE employee (id int, name varchar(255), salary int, managerid int);");
            statement.execute("INSERT INTO employee (id,name,salary,managerid) VALUES (1,'Joe',70000,3);");
            statement.execute("INSERT INTO employee (id,name,salary,managerid) VALUES (2,'Henry',80000,4);");
            statement.execute("INSERT INTO employee (id,name,salary,managerid) VALUES (3,'Sam',60000,null);");
            statement.execute("INSERT INTO employee (id,name,salary,managerid) VALUES (4,'Max',90000,null);");
            ResultSet res = statement.executeQuery(FINAL_REQUEST);

            while (res.next()) {
                System.out.println("Employee name result = " + res.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
