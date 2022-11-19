import DataBaseConnection.DataBaseConnection;
import Service.StoreValidAndInvalidCustomerInformationService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DataBaseConnection dataBaseConnection=new DataBaseConnection();
        Connection connection=dataBaseConnection.createConnection();

        StoreValidAndInvalidCustomerInformationService storeValidAndInvalidCustomerInformationService= new StoreValidAndInvalidCustomerInformationService(connection);
        //storeValidAndInvalidCustomerInformationService.readEachLineOfFile(5);
        storeValidAndInvalidCustomerInformationService.startService();
        //storeValidAndInvalidCustomerInformationService.validate("4074686162","rbranch@pacbell.net");

       /* System.out.println("Hello world!");
        DataBaseConnection dataBaseConnection=new DataBaseConnection();
        Connection connection=dataBaseConnection.createConnection();
        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate("insert into student(id,name,department) values('1','fahim','CSE')");
            ResultSet resultSet = statement.executeQuery("select * from student");
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }

        }
        catch (SQLException e){
            e.printStackTrace();

        }*/

    }
}