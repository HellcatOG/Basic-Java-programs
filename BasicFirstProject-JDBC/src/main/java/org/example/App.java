package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static String LOAD_DRIVER="com.mysql.cj.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost:3306/studentdb";
    public static String PASSWORD = "root";
    public static String USERNAME = "root";
    public static void main( String[] args )
    {
        try {

            Class.forName(LOAD_DRIVER);
            //MAKING CONNECTION
            Connection connection = DriverManager.getConnection(URL ,USERNAME, PASSWORD);
            //CREATE STATEMENT
            Statement statement = connection.createStatement();
            //CREATE QUERY
            String query = "select * from students";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String course = resultSet.getString("Course");
                System.out.println("ID:" + id + " Name:" + name + " Course:" +course );
            }

            connection.close();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
