package Service;

import DataBaseConnection.DataBaseConnection;
import Model.CustomerInfo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StoreValidAndInvalidCustomerInformationService {
    private Connection connection;
    public StoreValidAndInvalidCustomerInformationService(){

    }
    public StoreValidAndInvalidCustomerInformationService(Connection connection){
        this.connection=connection;

    }
    public void startService(){
     //  DataBaseConnection dataBaseConnection=new DataBaseConnection();
       // this.connection=dataBaseConnection.createConnection();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(Long i=0l;i<100000;i++){

                        CustomerInfo customer=readEachLineOfFile(i);
                        String phoneNumber="";
                        String email="";
                        phoneNumber=customer.getPhoneNumber();
                        email=customer.getEmail();
                        Integer status= validate(phoneNumber,email);
                        storeValidOrInvalidCustomer(customer,status);

                    }

                }
                catch (Exception e){
                    System.out.println(e);

                }


            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(Long j=100000l;j<200000;j++){
                        CustomerInfo customer=readEachLineOfFile(j);
                        String phoneNumber="";
                        String email="";
                        phoneNumber=customer.getPhoneNumber();
                        email=customer.getEmail();
                        Integer status= validate(phoneNumber,email);
                        storeValidOrInvalidCustomer(customer,status);

                    }

                }
                catch (Exception e){
                    System.out.println(e);
                }


            }
        });
        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(Long k=200000l;k<300000;k++){
                        CustomerInfo customer=readEachLineOfFile(k);
                        String phoneNumber="";
                        String email="";
                        phoneNumber=customer.getPhoneNumber();
                        email=customer.getEmail();
                        Integer status= validate(phoneNumber,email);
                        storeValidOrInvalidCustomer(customer,status);

                    }

                }
                catch (Exception e){
                    System.out.println(e);
                }


            }
        });
        Thread t4=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for(Long l=300000l;l<400000;l++){
                        CustomerInfo customer=readEachLineOfFile(l);
                        String phoneNumber="";
                        String email="";
                        phoneNumber=customer.getPhoneNumber();
                        email=customer.getEmail();
                        Integer status= validate(phoneNumber,email);
                        storeValidOrInvalidCustomer(customer,status);

                    }

                }
                catch (Exception e){
                    System.out.println(e);
                }


            }
        });
        Thread t5=new Thread(new Runnable() {

            @Override
            public void run() {
                try{
                    for(Long m=400000l;m<500000;m++){
                        CustomerInfo customer=readEachLineOfFile(m);
                        String phoneNumber="";
                        String email="";
                        phoneNumber=customer.getPhoneNumber();
                        email=customer.getEmail();
                        Integer status= validate(phoneNumber,email);
                        storeValidOrInvalidCustomer(customer,status);

                    }

                }
                catch (Exception e){
                    System.out.println(e);
                }


            }
        });
        Thread t6=new Thread(new Runnable() {

            @Override
            public void run() {
                try{
                    for(Long n=500000l;n<600000;n++){
                        CustomerInfo customer=readEachLineOfFile(n);
                        String phoneNumber="";
                        String email="";
                        phoneNumber=customer.getPhoneNumber();
                        email=customer.getEmail();
                        Integer status= validate(phoneNumber,email);
                        storeValidOrInvalidCustomer(customer,status);

                    }

                }
                catch (Exception e){
                    System.out.println(e);
                }


            }
        });

        Thread t7=new Thread(new Runnable() {

            @Override
            public void run() {
                try{
                    for(Long o=600000l;o<700000;o++){
                        CustomerInfo customer=readEachLineOfFile(o);
                        String phoneNumber="";
                        String email="";
                        phoneNumber=customer.getPhoneNumber();
                        email=customer.getEmail();
                        Integer status= validate(phoneNumber,email);
                        storeValidOrInvalidCustomer(customer,status);

                    }

                }
                catch (Exception e){
                    System.out.println(e);
                }


            }
        });

        Thread t8=new Thread(new Runnable() {

            @Override
            public void run() {
                try{
                    for(Long p=700000l;p<800000;p++){
                        CustomerInfo customer=readEachLineOfFile(p);
                        String phoneNumber="";
                        String email="";
                        phoneNumber=customer.getPhoneNumber();
                        email=customer.getEmail();
                        Integer status= validate(phoneNumber,email);
                        storeValidOrInvalidCustomer(customer,status);

                    }

                }
                catch (Exception e){
                    System.out.println(e);
                }


            }
        });

        Thread t9=new Thread(new Runnable() {

            @Override
            public void run() {
                try{
                    for(Long q=800000l;q<900000;q++){
                        CustomerInfo customer=readEachLineOfFile(q);
                        String phoneNumber="";
                        String email="";
                        phoneNumber=customer.getPhoneNumber();
                        email=customer.getEmail();
                        Integer status= validate(phoneNumber,email);
                        storeValidOrInvalidCustomer(customer,status);

                    }


                }
                catch (Exception e){
                    System.out.println(e);
                }

            }
        });


        Thread t10=new Thread(new Runnable() {

            @Override
            public void run() {
                try{
                    for(Long r=900000l;r<1000000;r++){
                        CustomerInfo customer=readEachLineOfFile(r);
                        String phoneNumber="";
                        String email="";
                        phoneNumber=customer.getPhoneNumber();
                        email=customer.getEmail();
                        Integer status= validate(phoneNumber,email);
                        storeValidOrInvalidCustomer(customer,status);

                    }

                }
                catch (Exception e){
                    System.out.println(e);
                }


            }
        });


        t1.setName("customerStoreThead1");
        t2.setName("customerStoreThead2");
        t3.setName("customerStoreThead3");
        t4.setName("customerStoreThead4");
        t5.setName("customerStoreThead5");
        t6.setName("customerStoreThead6");
        t7.setName("customerStoreThead7");
        t8.setName("customerStoreThead8");
        t9.setName("customerStoreThead9");
        t10.setName("customerStoreThead10");

        t1.start();
       t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();



    }

    public CustomerInfo readEachLineOfFile(Long index){
        CustomerInfo customer=new CustomerInfo();
        String eachLine="";
      //  index=index-1;
       // Long key=Long.valueOf(index.longValue());
        try{
           BufferedReader reader = new BufferedReader(new FileReader("D:\\1M-customers.txt"));
           if(index>0l){
             eachLine=reader.lines().skip(index-1l).limit(1).collect(Collectors.joining());
           }
           else{
               eachLine=reader.lines().skip(0).limit(1).collect(Collectors.joining());
           }
            String[] eachLineArr=eachLine.split(",");
            if(eachLineArr.length>=1){
                customer.setName(eachLineArr[0]);
            }
            if(eachLineArr.length>=2){
                customer.setBranch(eachLineArr[1]);
            }
            if(eachLineArr.length>=3){
                customer.setCity(eachLineArr[2]);
            }
            if(eachLineArr.length>=4){
                customer.setShot_form(eachLineArr[3]);
            }
            if(eachLineArr.length>=5){

                System.out.println(eachLineArr[4]);
                customer.setCode(eachLineArr[4]);
            }
            if(eachLineArr.length>=6){
                //System.out.println(eachLineArr[5]);
                customer.setPhoneNumber(eachLineArr[5]);
              //  customer.setCode(Integer.parseInt(eachLineArr[5]));
            }
            if(eachLineArr.length>=7){
                customer.setEmail(eachLineArr[6]);
            }
            if(eachLineArr.length>=8){
                customer.setIpAddress(eachLineArr[7]);
            }
        }
        catch (IOException e){

        }
        return customer;
    }
    public int validate( String phoneNumber,String email){
        int status=0;
        Pattern phoeNumberPattern = Pattern.compile("\\([4-6]{1}[0-9]{2}\\) [0-9]{3}\\-[0-9]{4}$");
        Pattern emailAddressPatten =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


        if(phoeNumberPattern.matcher(phoneNumber).matches() && emailAddressPatten.matcher(email).matches()){
            status=1;
        }
        else{
            status=0;

        }
        System.out.println(status);
        return status;


    }
    public void storeValidOrInvalidCustomer(CustomerInfo customer ,Integer status){
        String name="";
        String branch="";
        String city="";
        String shotForm="";
        String code="";
        String email="";
        String phoneNumber="";
        String ipAddress="";
        try{
            name=customer.getName();
            branch=customer.getBranch();
            city=customer.getCity();
            shotForm=customer.getShot_form();
            code=customer.getCode();
            email=customer.getEmail();
            phoneNumber=customer.getPhoneNumber();
            ipAddress=customer.getIpAddress();

           // DataBaseConnection dataBaseConnection=new DataBaseConnection();
           // Connection connection=dataBaseConnection.createConnection();
            Statement statement=this.connection.createStatement();
            String insertQuery="";
            
            if(status==1){
                String checkDuplicateValueQuery="select * from customer_processing where email='"+email+"' and phone_no='"+phoneNumber+"'";
                if(!statement.executeQuery(checkDuplicateValueQuery).next()){
                    insertQuery="insert into customer_processing(name,branch,city,shot_form,code,email,phone_no,ip_address) " +
                            "values('"+name+"','"+branch+"','"+city+"','"+shotForm+"','"+code+"','"+email+"','"+phoneNumber+"','"+ipAddress+"')";
                }


            }
            else{
                insertQuery="insert into invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) " +
                            "values('"+name+"','"+branch+"','"+city+"','"+shotForm+"','"+code+"','"+email+"','"+phoneNumber+"','"+ipAddress+"')";

            }
            System.out.println(insertQuery);
            statement.executeUpdate(insertQuery);

        }
        catch (SQLException e){
            e.printStackTrace();

        }

    }
}
