package Service;
import Model.CustomerInfo;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

public class StoreValidAndInvalidCustomerInformationService {
    private Connection connection;
    private PreparedStatement preparedStatementForValidCustomer;
    private PreparedStatement preparedStatementForInvalidCustomer;
    private PreparedStatement preparedStatementForvalidCustomer1;
    private PreparedStatement preparedStatementForvalidCustomer2;
    private PreparedStatement preparedStatementForvalidCustomer3;
    private PreparedStatement preparedStatementForvalidCustomer4;
    private PreparedStatement preparedStatementForvalidCustomer5;
    private PreparedStatement preparedStatementForvalidCustomer6;
    private PreparedStatement preparedStatementForvalidCustomer7;
    private PreparedStatement preparedStatementForvalidCustomer8;
    private PreparedStatement preparedStatementForvalidCustomer9;
    private PreparedStatement preparedStatementForvalidCustomer10;
    private PreparedStatement preparedStatementForInvalidCustomer1;
    private PreparedStatement preparedStatementForInvalidCustomer2;
    private PreparedStatement preparedStatementForInvalidCustomer3;
    private PreparedStatement preparedStatementForInvalidCustomer4;
    private PreparedStatement preparedStatementForInvalidCustomer5;
    private PreparedStatement preparedStatementForInvalidCustomer6;
    private PreparedStatement preparedStatementForInvalidCustomer7;
    private PreparedStatement preparedStatementForInvalidCustomer8;
    private PreparedStatement preparedStatementForInvalidCustomer9;
    private PreparedStatement preparedStatementForInvalidCustomer10;

    public StoreValidAndInvalidCustomerInformationService(){

    }
    public StoreValidAndInvalidCustomerInformationService(Connection connection){
        this.connection=connection;




    }
    public   HashMap<String, List<CustomerInfo>> startService(){
        HashMap<String, List<CustomerInfo>> validAndInvalidCustomers=new HashMap<String,List<CustomerInfo>>();
        LinkedHashMap<String,CustomerInfo> invalidCustomerHashMap=new LinkedHashMap<String,CustomerInfo>();
        LinkedHashMap<String,CustomerInfo> validCustomerHashMap=new LinkedHashMap<String,CustomerInfo>();

        try{
            this.preparedStatementForValidCustomer=this.connection.prepareStatement("INSERT INTO customer_processing(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
            this.preparedStatementForInvalidCustomer=this.connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
            String filePath="D:\\1M-customers.txt";
            File file=new File(filePath);
            InputStream inputStream=new BufferedInputStream(new FileInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            Integer c=0;
            while ((line=reader.readLine())!=null && !line.isEmpty()) {
                c++;
                System.out.println(c);
                String email="";
                String phoneNumber="";
                int validateStatus=0;
                CustomerInfo customerInfo=readEachLineOfFile(line);
                email=customerInfo.getEmail();
                phoneNumber=customerInfo.getPhoneNumber();
                validateStatus=validate(phoneNumber,email);
                if(validateStatus==0){
                    invalidCustomerHashMap.put(customerInfo.getEmail(),customerInfo);
                }
                else{
                    validCustomerHashMap.put(customerInfo.getEmail(),customerInfo);
                }

            }

            List<CustomerInfo> filteredInValidCustomers=List.copyOf(invalidCustomerHashMap.values());
            List<CustomerInfo> filteredValidCustomers=List.copyOf(validCustomerHashMap.values());
            validAndInvalidCustomers.put("invalidCustomers",filteredInValidCustomers);
            validAndInvalidCustomers.put("validCustomer",filteredValidCustomers);


        }
        catch (Exception e){
            System.out.println(e);

        }

        return validAndInvalidCustomers;


    }
    public CustomerInfo readEachLineOfFile(String line){
        CustomerInfo customer=new CustomerInfo();
        String[] eachLineArr=line.split(",");
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
            customer.setCode(eachLineArr[4]);
        }
        if(eachLineArr.length>=6){
            customer.setPhoneNumber(eachLineArr[5]);
        }
        if(eachLineArr.length>=7){
            customer.setEmail(eachLineArr[6]);
        }
        if(eachLineArr.length>=8){
            customer.setIpAddress(eachLineArr[7]);
        }

       return customer;
    }
    public int validate( String phoneNumber,String email){
        int status=0;
        Pattern phoeNumberPattern = Pattern.compile("^(\\d{1,1}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
        Pattern emailAddressPatten =  Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        if(phoeNumberPattern.matcher(phoneNumber).matches() && emailAddressPatten.matcher(email).matches()){
            status=1;
        }
        else{
            status=0;

        }
        return status;


    }
    public void storeValidCustomers(List<CustomerInfo> validCustomers){
        Integer validCustomerSize=validCustomers.size();

        try {
            this.preparedStatementForvalidCustomer1=this.connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
            this.preparedStatementForvalidCustomer2=this.connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
            this.preparedStatementForvalidCustomer3=this.connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
            this.preparedStatementForvalidCustomer4=this.connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
            this.preparedStatementForvalidCustomer5=this.connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
            this.preparedStatementForvalidCustomer6=this.connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
            this.preparedStatementForvalidCustomer7=this.connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
            this.preparedStatementForvalidCustomer8=this.connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
            this.preparedStatementForvalidCustomer9=this.connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
            this.preparedStatementForvalidCustomer10=this.connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
            Thread t1=new Thread(new Runnable() {
                Integer index=getActualIndexToExecuteBatch(validCustomerSize,100000);
                @Override
                public void run() {
                    CustomerInfo customer=new CustomerInfo();
                    for(int i=0;i<100000;i++){
                         if(validCustomerSize>i) {
                             try{
                                 preparedStatementForvalidCustomer1.setString(1,validCustomers.get(i).getName());
                                 preparedStatementForvalidCustomer1.setString(2,validCustomers.get(i).getBranch());
                                 preparedStatementForvalidCustomer1.setString(3,validCustomers.get(i).getCity());
                                 preparedStatementForvalidCustomer1.setString(4,validCustomers.get(i).getShot_form());
                                 preparedStatementForvalidCustomer1.setString(5,validCustomers.get(i).getCode());
                                 preparedStatementForvalidCustomer1.setString(6,validCustomers.get(i).getEmail());
                                 preparedStatementForvalidCustomer1.setString(7,validCustomers.get(i).getPhoneNumber());
                                 preparedStatementForvalidCustomer1.setString(8,validCustomers.get(i).getIpAddress());
                                 preparedStatementForvalidCustomer1.addBatch();

                             }
                             catch (SQLException e){

                             }

                             if ((i == index)) {
                                 try {
                                     System.out.println("start batch 1 for valid customer");
                                     preparedStatementForvalidCustomer1.executeBatch();
                                     System.out.println("etart batch 1 for valid customer");
                                     preparedStatementForvalidCustomer1.clearBatch();
                                    // preparedStatementForvalidCustomer1 = connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");


                                 } catch (SQLException e) {
                                     e.printStackTrace();

                                 }

                             }

                         }




                    }
                }
            });
            Thread t2=new Thread(new Runnable() {
                Integer index=getActualIndexToExecuteBatch(validCustomerSize,200000);
                @Override
                public void run() {
                    CustomerInfo customer=new CustomerInfo();
                    for(int j=100000;j<200000;j++){
                        if(validCustomerSize>j){

                            try{
                                preparedStatementForvalidCustomer2.setString(1,validCustomers.get(j).getName());
                                preparedStatementForvalidCustomer2.setString(2,validCustomers.get(j).getBranch());
                                preparedStatementForvalidCustomer2.setString(3,validCustomers.get(j).getCity());
                                preparedStatementForvalidCustomer2.setString(4,validCustomers.get(j).getShot_form());
                                preparedStatementForvalidCustomer2.setString(5,validCustomers.get(j).getCode());
                                preparedStatementForvalidCustomer2.setString(6,validCustomers.get(j).getEmail());
                                preparedStatementForvalidCustomer2.setString(7,validCustomers.get(j).getPhoneNumber());
                                preparedStatementForvalidCustomer2.setString(8,validCustomers.get(j).getIpAddress());
                                preparedStatementForvalidCustomer2.addBatch();

                            }
                            catch (SQLException e){

                            }
                            if((j==index)){
                                try{
                                    preparedStatementForvalidCustomer2.executeBatch();
                                    preparedStatementForvalidCustomer2.clearBatch();
                                  //  preparedStatementForvalidCustomer2=connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                                }
                                catch (SQLException e){

                                }

                            }



                        }




                    }
                }
            });
            Thread t3=new Thread(new Runnable() {
                Integer index=getActualIndexToExecuteBatch(validCustomerSize,300000);
                @Override
                public void run() {
                    CustomerInfo customer=new CustomerInfo();
                    for(int k=200000;k<300000;k++){
                        if(validCustomerSize>k){

                            try{
                                preparedStatementForvalidCustomer3.setString(1,validCustomers.get(k).getName());
                                preparedStatementForvalidCustomer3.setString(2,validCustomers.get(k).getBranch());
                                preparedStatementForvalidCustomer3.setString(3,validCustomers.get(k).getCity());
                                preparedStatementForvalidCustomer3.setString(4,validCustomers.get(k).getShot_form());
                                preparedStatementForvalidCustomer3.setString(5,validCustomers.get(k).getCode());
                                preparedStatementForvalidCustomer3.setString(6,validCustomers.get(k).getEmail());
                                preparedStatementForvalidCustomer3.setString(7,validCustomers.get(k).getPhoneNumber());
                                preparedStatementForvalidCustomer3.setString(8,validCustomers.get(k).getIpAddress());
                                preparedStatementForvalidCustomer3.addBatch();

                            }
                            catch (SQLException e){

                            }
                            if((k==index)){
                                try{
                                    preparedStatementForvalidCustomer3.executeBatch();
                                    preparedStatementForvalidCustomer3.clearBatch();
                                   // preparedStatementForvalidCustomer3=connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                                }
                                catch (SQLException e){

                                }

                            }



                        }




                    }
                }
            });
            Thread t4=new Thread(new Runnable() {
                Integer index=getActualIndexToExecuteBatch(validCustomerSize,400000);
                @Override
                public void run() {
                    CustomerInfo customer=new CustomerInfo();
                    for(int l=300000;l<400000;l++){
                        if(validCustomerSize>l){

                            try{
                                preparedStatementForvalidCustomer4.setString(1,validCustomers.get(l).getName());
                                preparedStatementForvalidCustomer4.setString(2,validCustomers.get(l).getBranch());
                                preparedStatementForvalidCustomer4.setString(3,validCustomers.get(l).getCity());
                                preparedStatementForvalidCustomer4.setString(4,validCustomers.get(l).getShot_form());
                                preparedStatementForvalidCustomer4.setString(5,validCustomers.get(l).getCode());
                                preparedStatementForvalidCustomer4.setString(6,validCustomers.get(l).getEmail());
                                preparedStatementForvalidCustomer4.setString(7,validCustomers.get(l).getPhoneNumber());
                                preparedStatementForvalidCustomer4.setString(8,validCustomers.get(l).getIpAddress());
                                preparedStatementForvalidCustomer4.addBatch();

                            }
                            catch (SQLException e){

                            }
                            if((l==index)){
                                try{
                                    preparedStatementForvalidCustomer4.executeBatch();
                                    preparedStatementForvalidCustomer4.clearBatch();
                                   // preparedStatementForvalidCustomer4=connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                                }
                                catch (SQLException e){

                                }

                            }



                        }




                    }
                }
            });
            Thread t5=new Thread(new Runnable() {
                Integer index=getActualIndexToExecuteBatch(validCustomerSize,500000);
                @Override
                public void run() {
                    CustomerInfo customer=new CustomerInfo();
                    for(int m=400000;m<500000;m++){
                        if(validCustomerSize>m){

                            try{
                                preparedStatementForvalidCustomer5.setString(1,validCustomers.get(m).getName());
                                preparedStatementForvalidCustomer5.setString(2,validCustomers.get(m).getBranch());
                                preparedStatementForvalidCustomer5.setString(3,validCustomers.get(m).getCity());
                                preparedStatementForvalidCustomer5.setString(4,validCustomers.get(m).getShot_form());
                                preparedStatementForvalidCustomer5.setString(5,validCustomers.get(m).getCode());
                                preparedStatementForvalidCustomer5.setString(6,validCustomers.get(m).getEmail());
                                preparedStatementForvalidCustomer5.setString(7,validCustomers.get(m).getPhoneNumber());
                                preparedStatementForvalidCustomer5.setString(8,validCustomers.get(m).getIpAddress());
                                preparedStatementForvalidCustomer5.addBatch();

                            }
                            catch (SQLException e){

                            }
                            if((m==index)){
                                try{
                                    preparedStatementForvalidCustomer5.executeBatch();
                                    preparedStatementForvalidCustomer5.clearBatch();
                                  //  preparedStatementForvalidCustomer5=connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                                }
                                catch (SQLException e){

                                }

                            }



                        }




                    }
                }
            });
            Thread t6=new Thread(new Runnable() {
                Integer index=getActualIndexToExecuteBatch(validCustomerSize,600000);
                @Override
                public void run() {
                    CustomerInfo customer=new CustomerInfo();
                    for(int n=500000;n<600000;n++){
                        if(validCustomerSize>n){

                            try{
                                preparedStatementForvalidCustomer6.setString(1,validCustomers.get(n).getName());
                                preparedStatementForvalidCustomer6.setString(2,validCustomers.get(n).getBranch());
                                preparedStatementForvalidCustomer6.setString(3,validCustomers.get(n).getCity());
                                preparedStatementForvalidCustomer6.setString(4,validCustomers.get(n).getShot_form());
                                preparedStatementForvalidCustomer6.setString(5,validCustomers.get(n).getCode());
                                preparedStatementForvalidCustomer6.setString(6,validCustomers.get(n).getEmail());
                                preparedStatementForvalidCustomer6.setString(7,validCustomers.get(n).getPhoneNumber());
                                preparedStatementForvalidCustomer6.setString(8,validCustomers.get(n).getIpAddress());
                                preparedStatementForvalidCustomer6.addBatch();

                            }
                            catch (SQLException e){

                            }
                            if((n==index)){
                                try{
                                    preparedStatementForvalidCustomer6.executeBatch();
                                    preparedStatementForvalidCustomer6.clearBatch();
                                    //preparedStatementForvalidCustomer6=connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                                }
                                catch (SQLException e){

                                }

                            }



                        }




                    }
                }
            });
            Thread t7=new Thread(new Runnable() {
                Integer index=getActualIndexToExecuteBatch(validCustomerSize,700000);
                @Override
                public void run() {
                    CustomerInfo customer=new CustomerInfo();
                    for(int o=600000;o<700000;o++){
                        if(validCustomerSize>o){

                            try{
                                preparedStatementForvalidCustomer7.setString(1,validCustomers.get(o).getName());
                                preparedStatementForvalidCustomer7.setString(2,validCustomers.get(o).getBranch());
                                preparedStatementForvalidCustomer7.setString(3,validCustomers.get(o).getCity());
                                preparedStatementForvalidCustomer7.setString(4,validCustomers.get(o).getShot_form());
                                preparedStatementForvalidCustomer7.setString(5,validCustomers.get(o).getCode());
                                preparedStatementForvalidCustomer7.setString(6,validCustomers.get(o).getEmail());
                                preparedStatementForvalidCustomer7.setString(7,validCustomers.get(o).getPhoneNumber());
                                preparedStatementForvalidCustomer7.setString(8,validCustomers.get(o).getIpAddress());
                                preparedStatementForvalidCustomer7.addBatch();

                            }
                            catch (SQLException e){

                            }
                            if((o==index)){
                                try{
                                    preparedStatementForvalidCustomer7.executeBatch();
                                    preparedStatementForvalidCustomer7.clearBatch();
                                   // preparedStatementForvalidCustomer7=connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                                }
                                catch (SQLException e){

                                }

                            }



                        }




                    }
                }
            });
            Thread t8=new Thread(new Runnable() {
                Integer index=getActualIndexToExecuteBatch(validCustomerSize,800000);
                @Override
                public void run() {
                    CustomerInfo customer=new CustomerInfo();
                    for(int p=700000;p<800000;p++){
                        if(validCustomerSize>p){

                            try{
                                preparedStatementForvalidCustomer8.setString(1,validCustomers.get(p).getName());
                                preparedStatementForvalidCustomer8.setString(2,validCustomers.get(p).getBranch());
                                preparedStatementForvalidCustomer8.setString(3,validCustomers.get(p).getCity());
                                preparedStatementForvalidCustomer8.setString(4,validCustomers.get(p).getShot_form());
                                preparedStatementForvalidCustomer8.setString(5,validCustomers.get(p).getCode());
                                preparedStatementForvalidCustomer8.setString(6,validCustomers.get(p).getEmail());
                                preparedStatementForvalidCustomer8.setString(7,validCustomers.get(p).getPhoneNumber());
                                preparedStatementForvalidCustomer8.setString(8,validCustomers.get(p).getIpAddress());
                                preparedStatementForvalidCustomer8.addBatch();

                            }
                            catch (SQLException e){

                            }
                            if((p==index)){
                                try{
                                    preparedStatementForvalidCustomer8.executeBatch();
                                    preparedStatementForvalidCustomer8.clearBatch();
                                   // preparedStatementForvalidCustomer8=connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                                }
                                catch (SQLException e){

                                }

                            }



                        }




                    }
                }
            });
            Thread t9=new Thread(new Runnable() {
                Integer index=getActualIndexToExecuteBatch(validCustomerSize,900000);
                @Override
                public void run() {
                    CustomerInfo customer=new CustomerInfo();
                    for(int q=800000;q<900000;q++){
                        if(validCustomerSize>q){

                            try{
                                preparedStatementForvalidCustomer9.setString(1,validCustomers.get(q).getName());
                                preparedStatementForvalidCustomer9.setString(2,validCustomers.get(q).getBranch());
                                preparedStatementForvalidCustomer9.setString(3,validCustomers.get(q).getCity());
                                preparedStatementForvalidCustomer9.setString(4,validCustomers.get(q).getShot_form());
                                preparedStatementForvalidCustomer9.setString(5,validCustomers.get(q).getCode());
                                preparedStatementForvalidCustomer9.setString(6,validCustomers.get(q).getEmail());
                                preparedStatementForvalidCustomer9.setString(7,validCustomers.get(q).getPhoneNumber());
                                preparedStatementForvalidCustomer9.setString(8,validCustomers.get(q).getIpAddress());
                                preparedStatementForvalidCustomer9.addBatch();

                            }
                            catch (SQLException e){

                            }
                            if((q==index)){
                                try{
                                    preparedStatementForvalidCustomer9.executeBatch();
                                    preparedStatementForvalidCustomer9.clearBatch();
                                   // preparedStatementForvalidCustomer9=connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                                }
                                catch (SQLException e){

                                }

                            }



                        }




                    }
                }
            });
            Thread t10=new Thread(new Runnable() {
                Integer index=getActualIndexToExecuteBatch(validCustomerSize,100000);
                @Override
                public void run() {
                    CustomerInfo customer=new CustomerInfo();
                    for(int r=900000;r<1000000;r++){
                        if(validCustomerSize>r){

                            try{
                                preparedStatementForvalidCustomer10.setString(1,validCustomers.get(r).getName());
                                preparedStatementForvalidCustomer10.setString(2,validCustomers.get(r).getBranch());
                                preparedStatementForvalidCustomer10.setString(3,validCustomers.get(r).getCity());
                                preparedStatementForvalidCustomer10.setString(4,validCustomers.get(r).getShot_form());
                                preparedStatementForvalidCustomer10.setString(5,validCustomers.get(r).getCode());
                                preparedStatementForvalidCustomer10.setString(6,validCustomers.get(r).getEmail());
                                preparedStatementForvalidCustomer10.setString(7,validCustomers.get(r).getPhoneNumber());
                                preparedStatementForvalidCustomer10.setString(8,validCustomers.get(r).getIpAddress());
                                preparedStatementForvalidCustomer10.addBatch();

                            }
                            catch (SQLException e){

                            }
                            if((r==index)){
                                try{
                                    preparedStatementForvalidCustomer10.executeBatch();
                                    preparedStatementForvalidCustomer10.clearBatch();
                                   // preparedStatementForvalidCustomer10=connection.prepareStatement("INSERT INTO customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                                }
                                catch (SQLException e){

                                }

                            }



                        }




                    }
                }
            });

            if(validCustomerSize<=100000){
                t1.start();

            }
            if(validCustomerSize>=200000){
                t2.start();

            }
            if(validCustomerSize>=300000){
                t3.start();
            }
            if(validCustomerSize>=400000){
                t4.start();
            }
            if(validCustomerSize>=500000){
                t5.start();
            }
            if(validCustomerSize>=600000){
                t6.start();
            }
            if(validCustomerSize>=700000){
                t7.start();
            }
            if(validCustomerSize>=800000){
                t8.start();
            }
            if(validCustomerSize>=900000){
                t9.start();
            }
            if(validCustomerSize>=1000000){
                t10.start();
            }

        }
        catch (SQLException e){
            e.printStackTrace();

        }


    }
    public void storeInvalidCustomers(List<CustomerInfo> invalidCustomers){
        Integer invalidCustomerSize=invalidCustomers.size();

       try {
           this.preparedStatementForInvalidCustomer1=this.connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
           this.preparedStatementForInvalidCustomer2=this.connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
           this.preparedStatementForInvalidCustomer3=this.connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
           this.preparedStatementForInvalidCustomer4=this.connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
           this.preparedStatementForInvalidCustomer5=this.connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
           this.preparedStatementForInvalidCustomer6=this.connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
           this.preparedStatementForInvalidCustomer7=this.connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
           this.preparedStatementForInvalidCustomer8=this.connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
           this.preparedStatementForInvalidCustomer9=this.connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
           this.preparedStatementForInvalidCustomer10=this.connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
           Thread t1=new Thread(new Runnable() {
               Integer index=getActualIndexToExecuteBatch(invalidCustomerSize,100000);
               @Override
               public void run() {
                   CustomerInfo customer=new CustomerInfo();
                   for(int i=0;i<100000;i++){
                       if(invalidCustomerSize>i){

                           try{
                               preparedStatementForInvalidCustomer1.setString(1,invalidCustomers.get(i).getName());
                               preparedStatementForInvalidCustomer1.setString(2,invalidCustomers.get(i).getBranch());
                               preparedStatementForInvalidCustomer1.setString(3,invalidCustomers.get(i).getCity());
                               preparedStatementForInvalidCustomer1.setString(4,invalidCustomers.get(i).getShot_form());
                               preparedStatementForInvalidCustomer1.setString(5,invalidCustomers.get(i).getCode());
                               preparedStatementForInvalidCustomer1.setString(6,invalidCustomers.get(i).getEmail());
                               preparedStatementForInvalidCustomer1.setString(7,invalidCustomers.get(i).getPhoneNumber());
                               preparedStatementForInvalidCustomer1.setString(8,invalidCustomers.get(i).getIpAddress());
                               preparedStatementForInvalidCustomer1.addBatch();

                           }
                           catch (SQLException e){

                           }
                           if((i==index)){
                               try{
                                   System.out.println("end batch 1 for invalid customer");
                                   preparedStatementForInvalidCustomer1.executeBatch();
                                   System.out.println("end batch 1 for invalid customer");
                                   preparedStatementForInvalidCustomer1.clearBatch();
                                   preparedStatementForInvalidCustomer1=connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                               }
                               catch (SQLException e){

                               }

                           }



                       }




                   }
               }
           });
           Thread t2=new Thread(new Runnable() {
               Integer index=getActualIndexToExecuteBatch(invalidCustomerSize,200000);
               @Override
               public void run() {
                   CustomerInfo customer=new CustomerInfo();
                   for(int j=100000;j<200000;j++){
                       if(invalidCustomerSize>j){

                           try{
                               preparedStatementForInvalidCustomer2.setString(1,invalidCustomers.get(j).getName());
                               preparedStatementForInvalidCustomer2.setString(2,invalidCustomers.get(j).getBranch());
                               preparedStatementForInvalidCustomer2.setString(3,invalidCustomers.get(j).getCity());
                               preparedStatementForInvalidCustomer2.setString(4,invalidCustomers.get(j).getShot_form());
                               preparedStatementForInvalidCustomer2.setString(5,invalidCustomers.get(j).getCode());
                               preparedStatementForInvalidCustomer2.setString(6,invalidCustomers.get(j).getEmail());
                               preparedStatementForInvalidCustomer2.setString(7,invalidCustomers.get(j).getPhoneNumber());
                               preparedStatementForInvalidCustomer2.setString(8,invalidCustomers.get(j).getIpAddress());
                               preparedStatementForInvalidCustomer2.addBatch();

                           }
                           catch (SQLException e){

                           }
                           if((j==index)){
                               try{

                                   preparedStatementForInvalidCustomer2.executeBatch();
                                   preparedStatementForInvalidCustomer2.clearBatch();
                                 //  preparedStatementForInvalidCustomer2=connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                               }
                               catch (SQLException e){

                               }

                           }



                       }




                   }
               }
           });
           Thread t3=new Thread(new Runnable() {
               Integer index=getActualIndexToExecuteBatch(invalidCustomerSize,300000);
               @Override
               public void run() {
                   CustomerInfo customer=new CustomerInfo();
                   for(int k=200000;k<300000;k++){
                       if(invalidCustomerSize>k){

                           try{
                               preparedStatementForInvalidCustomer3.setString(1,invalidCustomers.get(k).getName());
                               preparedStatementForInvalidCustomer3.setString(2,invalidCustomers.get(k).getBranch());
                               preparedStatementForInvalidCustomer3.setString(3,invalidCustomers.get(k).getCity());
                               preparedStatementForInvalidCustomer3.setString(4,invalidCustomers.get(k).getShot_form());
                               preparedStatementForInvalidCustomer3.setString(5,invalidCustomers.get(k).getCode());
                               preparedStatementForInvalidCustomer3.setString(6,invalidCustomers.get(k).getEmail());
                               preparedStatementForInvalidCustomer3.setString(7,invalidCustomers.get(k).getPhoneNumber());
                               preparedStatementForInvalidCustomer3.setString(8,invalidCustomers.get(k).getIpAddress());
                               preparedStatementForInvalidCustomer3.addBatch();

                           }
                           catch (SQLException e){

                           }
                           if((k==index)){
                               try{
                                   preparedStatementForInvalidCustomer3.executeBatch();
                                   preparedStatementForInvalidCustomer3.clearBatch();
                                  // preparedStatementForInvalidCustomer3=connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                               }
                               catch (SQLException e){

                               }

                           }



                       }




                   }
               }
           });
           Thread t4=new Thread(new Runnable() {
               Integer index=getActualIndexToExecuteBatch(invalidCustomerSize,400000);
               @Override
               public void run() {
                   CustomerInfo customer=new CustomerInfo();
                   for(int l=300000;l<400000;l++){
                       if(invalidCustomerSize>l){

                           try{
                               preparedStatementForInvalidCustomer4.setString(1,invalidCustomers.get(l).getName());
                               preparedStatementForInvalidCustomer4.setString(2,invalidCustomers.get(l).getBranch());
                               preparedStatementForInvalidCustomer4.setString(3,invalidCustomers.get(l).getCity());
                               preparedStatementForInvalidCustomer4.setString(4,invalidCustomers.get(l).getShot_form());
                               preparedStatementForInvalidCustomer4.setString(5,invalidCustomers.get(l).getCode());
                               preparedStatementForInvalidCustomer4.setString(6,invalidCustomers.get(l).getEmail());
                               preparedStatementForInvalidCustomer4.setString(7,invalidCustomers.get(l).getPhoneNumber());
                               preparedStatementForInvalidCustomer4.setString(8,invalidCustomers.get(l).getIpAddress());
                               preparedStatementForInvalidCustomer4.addBatch();

                           }
                           catch (SQLException e){

                           }
                           if((l==index)){
                               try{
                                   preparedStatementForInvalidCustomer4.executeBatch();
                                   preparedStatementForInvalidCustomer4.clearBatch();
                                  // preparedStatementForInvalidCustomer4=connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                               }
                               catch (SQLException e){

                               }

                           }



                       }




                   }
               }
           });
           Thread t5=new Thread(new Runnable() {
               Integer index=getActualIndexToExecuteBatch(invalidCustomerSize,500000);
               @Override
               public void run() {
                   CustomerInfo customer=new CustomerInfo();
                   for(int m=400000;m<500000;m++){
                       if(invalidCustomerSize>m){

                           try{
                               preparedStatementForInvalidCustomer5.setString(1,invalidCustomers.get(m).getName());
                               preparedStatementForInvalidCustomer5.setString(2,invalidCustomers.get(m).getBranch());
                               preparedStatementForInvalidCustomer5.setString(3,invalidCustomers.get(m).getCity());
                               preparedStatementForInvalidCustomer5.setString(4,invalidCustomers.get(m).getShot_form());
                               preparedStatementForInvalidCustomer5.setString(5,invalidCustomers.get(m).getCode());
                               preparedStatementForInvalidCustomer5.setString(6,invalidCustomers.get(m).getEmail());
                               preparedStatementForInvalidCustomer5.setString(7,invalidCustomers.get(m).getPhoneNumber());
                               preparedStatementForInvalidCustomer5.setString(8,invalidCustomers.get(m).getIpAddress());
                               preparedStatementForInvalidCustomer5.addBatch();

                           }
                           catch (SQLException e){

                           }
                           if((m==index)){
                               try{
                                   preparedStatementForInvalidCustomer5.executeBatch();
                                   preparedStatementForInvalidCustomer5.clearBatch();
                                  // preparedStatementForInvalidCustomer5=connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                               }
                               catch (SQLException e){

                               }

                           }



                       }




                   }
               }
           });
           Thread t6=new Thread(new Runnable() {
               Integer index=getActualIndexToExecuteBatch(invalidCustomerSize,600000);
               @Override
               public void run() {
                   CustomerInfo customer=new CustomerInfo();
                   for(int n=500000;n<600000;n++){
                       if(invalidCustomerSize>n){

                           try{
                               preparedStatementForInvalidCustomer6.setString(1,invalidCustomers.get(n).getName());
                               preparedStatementForInvalidCustomer6.setString(2,invalidCustomers.get(n).getBranch());
                               preparedStatementForInvalidCustomer6.setString(3,invalidCustomers.get(n).getCity());
                               preparedStatementForInvalidCustomer6.setString(4,invalidCustomers.get(n).getShot_form());
                               preparedStatementForInvalidCustomer6.setString(5,invalidCustomers.get(n).getCode());
                               preparedStatementForInvalidCustomer6.setString(6,invalidCustomers.get(n).getEmail());
                               preparedStatementForInvalidCustomer6.setString(7,invalidCustomers.get(n).getPhoneNumber());
                               preparedStatementForInvalidCustomer6.setString(8,invalidCustomers.get(n).getIpAddress());
                               preparedStatementForInvalidCustomer6.addBatch();

                           }
                           catch (SQLException e){

                           }
                           if((n==index)){
                               try{
                                   preparedStatementForInvalidCustomer6.executeBatch();
                                   preparedStatementForInvalidCustomer6.clearBatch();
                                 //  preparedStatementForInvalidCustomer6=connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                               }
                               catch (SQLException e){

                               }

                           }



                       }




                   }
               }
           });
           Thread t7=new Thread(new Runnable() {
               Integer index=getActualIndexToExecuteBatch(invalidCustomerSize,700000);
               @Override
               public void run() {
                   CustomerInfo customer=new CustomerInfo();
                   for(int o=600000;o<700000;o++){
                       if(invalidCustomerSize>o){

                           try{
                               preparedStatementForInvalidCustomer7.setString(1,invalidCustomers.get(o).getName());
                               preparedStatementForInvalidCustomer7.setString(2,invalidCustomers.get(o).getBranch());
                               preparedStatementForInvalidCustomer7.setString(3,invalidCustomers.get(o).getCity());
                               preparedStatementForInvalidCustomer7.setString(4,invalidCustomers.get(o).getShot_form());
                               preparedStatementForInvalidCustomer7.setString(5,invalidCustomers.get(o).getCode());
                               preparedStatementForInvalidCustomer7.setString(6,invalidCustomers.get(o).getEmail());
                               preparedStatementForInvalidCustomer7.setString(7,invalidCustomers.get(o).getPhoneNumber());
                               preparedStatementForInvalidCustomer7.setString(8,invalidCustomers.get(o).getIpAddress());
                               preparedStatementForInvalidCustomer7.addBatch();

                           }
                           catch (SQLException e){

                           }
                           if((o==index)){
                               try{
                                   preparedStatementForInvalidCustomer7.executeBatch();
                                   preparedStatementForInvalidCustomer7.clearBatch();
                                   preparedStatementForInvalidCustomer7=connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                               }
                               catch (SQLException e){

                               }

                           }



                       }




                   }
               }
           });
           Thread t8=new Thread(new Runnable() {
               Integer index=getActualIndexToExecuteBatch(invalidCustomerSize,800000);
               @Override
               public void run() {
                   CustomerInfo customer=new CustomerInfo();
                   for(int p=700000;p<800000;p++){
                       if(invalidCustomerSize>p){

                           try{
                               preparedStatementForInvalidCustomer8.setString(1,invalidCustomers.get(p).getName());
                               preparedStatementForInvalidCustomer8.setString(2,invalidCustomers.get(p).getBranch());
                               preparedStatementForInvalidCustomer8.setString(3,invalidCustomers.get(p).getCity());
                               preparedStatementForInvalidCustomer8.setString(4,invalidCustomers.get(p).getShot_form());
                               preparedStatementForInvalidCustomer8.setString(5,invalidCustomers.get(p).getCode());
                               preparedStatementForInvalidCustomer8.setString(6,invalidCustomers.get(p).getEmail());
                               preparedStatementForInvalidCustomer8.setString(7,invalidCustomers.get(p).getPhoneNumber());
                               preparedStatementForInvalidCustomer8.setString(8,invalidCustomers.get(p).getIpAddress());
                               preparedStatementForInvalidCustomer8.addBatch();

                           }
                           catch (SQLException e){

                           }
                           if((p==index)){
                               try{
                                   preparedStatementForInvalidCustomer8.executeBatch();
                                   preparedStatementForInvalidCustomer8.clearBatch();
                                  // preparedStatementForInvalidCustomer8=connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                               }
                               catch (SQLException e){

                               }

                           }



                       }




                   }
               }
           });
           Thread t9=new Thread(new Runnable() {
               Integer index=getActualIndexToExecuteBatch(invalidCustomerSize,900000);
               @Override
               public void run() {
                   CustomerInfo customer=new CustomerInfo();
                   for(int q=800000;q<900000;q++){
                       if(invalidCustomerSize>q){

                           try{
                               preparedStatementForInvalidCustomer9.setString(1,invalidCustomers.get(q).getName());
                               preparedStatementForInvalidCustomer9.setString(2,invalidCustomers.get(q).getBranch());
                               preparedStatementForInvalidCustomer9.setString(3,invalidCustomers.get(q).getCity());
                               preparedStatementForInvalidCustomer9.setString(4,invalidCustomers.get(q).getShot_form());
                               preparedStatementForInvalidCustomer9.setString(5,invalidCustomers.get(q).getCode());
                               preparedStatementForInvalidCustomer9.setString(6,invalidCustomers.get(q).getEmail());
                               preparedStatementForInvalidCustomer9.setString(7,invalidCustomers.get(q).getPhoneNumber());
                               preparedStatementForInvalidCustomer9.setString(8,invalidCustomers.get(q).getIpAddress());
                               preparedStatementForInvalidCustomer9.addBatch();

                           }
                           catch (SQLException e){

                           }
                           if((q==index)){
                               try{
                                   preparedStatementForInvalidCustomer9.executeBatch();
                                   preparedStatementForInvalidCustomer9.clearBatch();
                                   //preparedStatementForInvalidCustomer9=connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                               }
                               catch (SQLException e){

                               }

                           }



                       }




                   }
               }
           });
           Thread t10=new Thread(new Runnable() {
               Integer index=getActualIndexToExecuteBatch(invalidCustomerSize,1000000);
               @Override
               public void run() {
                   CustomerInfo customer=new CustomerInfo();
                   for(int r=900000;r<1000000;r++){
                       if(invalidCustomerSize>r){

                           try{
                               preparedStatementForInvalidCustomer10.setString(1,invalidCustomers.get(r).getName());
                               preparedStatementForInvalidCustomer10.setString(2,invalidCustomers.get(r).getBranch());
                               preparedStatementForInvalidCustomer10.setString(3,invalidCustomers.get(r).getCity());
                               preparedStatementForInvalidCustomer10.setString(4,invalidCustomers.get(r).getShot_form());
                               preparedStatementForInvalidCustomer10.setString(5,invalidCustomers.get(r).getCode());
                               preparedStatementForInvalidCustomer10.setString(6,invalidCustomers.get(r).getEmail());
                               preparedStatementForInvalidCustomer10.setString(7,invalidCustomers.get(r).getPhoneNumber());
                               preparedStatementForInvalidCustomer10.setString(8,invalidCustomers.get(r).getIpAddress());
                               preparedStatementForInvalidCustomer10.addBatch();

                           }
                           catch (SQLException e){

                           }
                           if((r==index)){
                               try{
                                   preparedStatementForInvalidCustomer10.executeBatch();
                                   preparedStatementForInvalidCustomer10.clearBatch();
                                   preparedStatementForInvalidCustomer10=connection.prepareStatement("INSERT INTO invalid_customer_info(name,branch,city,shot_form,code,email,phone_no,ip_address) VALUES(?,?,?,?,?,?,?,?)");
                               }
                               catch (SQLException e){

                               }

                           }



                       }




                   }
               }
           });

           if(invalidCustomerSize<=100000){
               t1.start();

           }
           if(invalidCustomerSize>=200000){
               t2.start();

           }
           if(invalidCustomerSize>=300000){
               t3.start();
           }
           if(invalidCustomerSize>=400000){
               t4.start();
           }
           if(invalidCustomerSize>=500000){
               t5.start();
           }
           if(invalidCustomerSize>=600000){
               t6.start();
           }
           if(invalidCustomerSize>=700000){
               t7.start();
           }
           if(invalidCustomerSize>=800000){
               t8.start();
           }
           if(invalidCustomerSize>=900000){
               t9.start();
           }
           if(invalidCustomerSize>=1000000){
               t10.start();
           }
          /* if(!t1.isAlive()){
               preparedStatementForInvalidCustomer1.executeBatch();
           }*/
       }
       catch (SQLException e){
           e.printStackTrace();

       }




    }
    Integer getActualIndexToExecuteBatch(Integer customerSize,Integer value){
        Integer index=customerSize-value;
        if(index>=0){
            index=value-1;
        }
        else{
            index=customerSize-1;
        }
        return index;
    }
}
