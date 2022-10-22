package testpackage;
//
//import java.time.Clock;
//import java.time.DayOfWeek;
//import java.time.Instant;
//import java.time.Month;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.util.HashMap;
//import java.util.Map;
//
//import database.PojoEmployee;
// class TestClass {
//	  public static void main(String[] args) {  
//
////		 String args1[]=new String[5]; 
////		 System.out.println(args1.length);
////		  Clock clock = Clock.systemDefaultZone();
////		 long it = Instant.now().toEpochMilli();
////	     long milliseconds = clock.millis();
////	    System.out.println(milliseconds);
////	    System.out.println(it);
////	    System.out.println(System.currentTimeMillis());
////		  PojoEmployee pj =new PojoEmployee();
////		  Map<String,PojoEmployee> ap=new HashMap<>();
////		  PojoEmployee pj1 =new PojoEmployee();
////		  pj.setName("Ansar");
////		  pj.setEmail("ansar@123");
////		  pj.setMobile(9789);
////		  pj.setDepartment("cse");
////		  pj1.setName("siva");
////		  pj1.setEmail("siva@123");
////		  pj1.setMobile(9789);
////		  pj1.setDepartment("mech");
////		  
////		  ap.put("1", pj);
////		  ap.put("2", pj1);
////		  
////		  PojoEmployee getc =ap.get("1");
////		  System.out.println(getc.getName());
//		  
//		  
//		  
//		  
//	
//			
//		  }  
//
//}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.PojoEmployee;
import exception.UserException;

enum SingletonEnum { 
    Balaji;
    int value; 
	String name;
  
    public int getValue() { 
        return value; 
    } 
  
    public void setValue(int value) { 
        this.value = value; 
    } 
    public void setString(String name) { 
        this.name = name; 
    } 
    public String getString() { 
        return  name;
    } 
} 
 class TestClass { 
		private static Connection getConnection() throws  UserException {
			String url="jdbc:mysql://localhost/IncubationDb";
			String uName="root";
			String password="Root@123";
			Connection myConnection =null;
			try {
				myConnection = DriverManager.getConnection(url,uName,password); 
				return myConnection;
			}
			catch(SQLException sqlEx) {
				throw new UserException("There is a issue in connection ");
			}

		}
  
    public static void main(String[] args) throws UserException { 
    	
    	String SQL_INSERT = "INSERT INTO EmployeeTable (Name, Email, Mobile,Department) VALUES (?,?,?,?)";
    	PojoEmployee pj = new PojoEmployee();
    	 pj.setName("Ansar");
	  pj.setEmail("ansar@123");
	  pj.setMobile(9789);
	  pj.setDepartment("cse");
    	try(Connection inputConn=getConnection();
				PreparedStatement preparedStatement = inputConn.prepareStatement(SQL_INSERT);){
    		preparedStatement.setObject(1, pj);
			preparedStatement.executeUpdate();
		}

		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query");

		}
    	
        SingletonEnum singleton = SingletonEnum.Balaji; 
        SingletonEnum singleton1 = SingletonEnum.Balaji; 
        
  
        System.out.println(singleton.getValue()); 
        singleton.setValue(2); 

        System.out.println(singleton.getString()); 
        singleton1.setString("siva");
        System.out.println(singleton.getValue()); 
        System.out.println(singleton1.getValue()); 
        System.out.println(singleton.getString()); 
        System.out.println(singleton1.getString()); 
    } 
}
