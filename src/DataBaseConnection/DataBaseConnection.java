package DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {
    private String dbUrl="jdbc:mysql://localhost:3306/customer_processing";
    private String user="root";
    private String password="";
    private Connection connection;
    public Connection createConnection(){

        try{

           connection = DriverManager.getConnection(dbUrl,user,password);

        }
        catch (Exception e){
            System.out.println(e);

        }
        return connection;
    }
}
