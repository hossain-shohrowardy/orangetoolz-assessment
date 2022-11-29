import DataBaseConnection.DataBaseConnection;
import Model.CustomerInfo;
import Service.RetriveValidandInvalidCustomerInfoToFileService;
import Service.StoreValidAndInvalidCustomerInformationService;
import java.sql.Connection;
import java.util.*;


public class Main {
    public static void main(String[] args) {

       DataBaseConnection dataBaseConnection=new DataBaseConnection();
       Connection connection=dataBaseConnection.createConnection();
       HashMap<String, List<CustomerInfo>> validAndInvalidCustomers=new HashMap<String,List<CustomerInfo>>();
       StoreValidAndInvalidCustomerInformationService storeValidAndInvalidCustomerInformationService= new StoreValidAndInvalidCustomerInformationService(connection);
       validAndInvalidCustomers =storeValidAndInvalidCustomerInformationService.startService();
       List<CustomerInfo> validCustomers=validAndInvalidCustomers.get("validCustomer");
       List<CustomerInfo> inValidCustomers=validAndInvalidCustomers.get("invalidCustomers");
       storeValidAndInvalidCustomerInformationService.storeInvalidCustomers(inValidCustomers);
       storeValidAndInvalidCustomerInformationService.storeValidCustomers(validCustomers);
       RetriveValidandInvalidCustomerInfoToFileService retriveValidandInvalidCustomerInfoToFileService=new RetriveValidandInvalidCustomerInfoToFileService(validCustomers,inValidCustomers);
       retriveValidandInvalidCustomerInfoToFileService.startServiceForValidCustomer();
       retriveValidandInvalidCustomerInfoToFileService.startServiceForInValidCustomer();

    }
}