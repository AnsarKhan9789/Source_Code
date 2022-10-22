package database;

import java.util.List;
import java.util.Scanner;

import exception.UserException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class TestRunnerForDb {

	static Scanner myObj = new Scanner(System.in);

	public static String getUserInput() {
		String userName = myObj.next();
		return userName;
	}
	public static int getUserInputInt() {
		while (!myObj.hasNextInt()) {
			System.out.println("Please enter in  integer format");
			myObj.next();
		}
		int num =myObj.nextInt() ;
		return num;

	}

	public static void main(String[] args) throws  ClassNotFoundException,  UserException, SQLException {

		DataBaseMethods dbObj = new DataBaseMethods();
		String url="jdbc:mysql://localhost/IncubationDb";
		String uname="root";
		String pass="Root@123";

		String sql = "CREATE TABLE IF NOT EXISTS EmployeeTable"    +
				"(Emp_Id INTEGER NOT NULL  AUTO_INCREMENT, " +
				" Name VARCHAR(255), " + 
				" Email VARCHAR(255), " + 
				" Mobile INTEGER, " + 
				" Department VARCHAR(255), " + 
				" PRIMARY KEY (Emp_Id ))"; 

		String sql_Create="CREATE TABLE IF NOT EXISTS Relation "
				+ "(RNO INTEGER NOT NULL AUTO_INCREMENT,"
				+ "RelationName VARCHAR(100), "
				+ "RelationShip VARCHAR(100), "
				+ "Emp_Id INTEGER ,"
				+"PRIMARY KEY (RNO),"

					+ "FOREIGN KEY (Emp_Id) REFERENCES EmployeeTable(Emp_Id))";

		String SQL_INSERT = "INSERT INTO EmployeeTable (Name, Email, Mobile,Department) VALUES (?,?,?,?)";
		String Sql_select="select * from EmployeeTable where name = ?";
		String sql_get="SELECT * FROM EmployeeTable LIMIT ?";
		String sql_order="SELECT * FROM EmployeeTable ORDER BY Name DESC  LIMIT ?";
		String SQL_UPDATE = "UPDATE EmployeeTable SET Department=? WHERE Name=?";
		String sql_delete="DELETE FROM EmployeeTable WHERE Emp_Id= ?";
		String SQL_INSERTFK = "INSERT INTO Relation (RelationName, RelationShip, Emp_Id) VALUES (?,?,?)";
		String Sql_selectFK="select * from Relation where Emp_Id = ?";
		String sql_orderFK="SELECT EmployeeTable.Name,Relation.RelationName,Relation.RelationShip"
				+ " FROM EmployeeTable INNER JOIN Relation  ON  EmployeeTable.Emp_Id=Relation.Emp_Id"
				+ " ORDER BY Relation.RelationName LIMIT ?";
		String sql_getFk="SELECT "+
				"  EmployeeTable.Name, EmployeeTable.Emp_Id, Relation.RelationName, Relation.RelationShip"+
				" FROM EmployeeTable"+
				" INNER JOIN Relation  ON  EmployeeTable.Emp_Id=Relation.Emp_Id"+
				" WHERE Relation.RelationName=? ";

		boolean check=true;
		while(check) {
			System.out.println("Enter your choice");
			int x=getUserInputInt();
			try {
				switch(x) {

				case 1:
					dbObj.createTable( sql );
					System.out.println("Table is created");
					break;
				case 2:
					System.out.println("Enter your name");
					String name=getUserInput();
					System.out.println("Enter your Email");
					String Email=getUserInput();
					System.out.println("Enter your Mobile");
					int Mobile=getUserInputInt();
					System.out.println("Enter your Department");
					String dept=getUserInput();
					dbObj.insertValues(  SQL_INSERT, name, Email, Mobile,dept);
					break;
				case 3:
					System.out.println("Enter  name to search ");
					String name3=getUserInput();
					List result=  (List) dbObj.getSearchedvalue(  Sql_select,name3);
					System.out.println(result);
					break;
				case 4:
					System.out.println("How many datas you need  ");
					int firstN=getUserInputInt();
					List result1=  (List) dbObj.getRequiredValues(  sql_get,firstN);
					System.out.println(result1);
					break;
				case 5:
					System.out.println("Enter  Department to change ");
					String changeDept=getUserInput();
					System.out.println("Enter  name to search ");
					String confirmName=getUserInput();
					dbObj.updateDB(  SQL_UPDATE, changeDept, confirmName);
					System.out.println("The DB is updated ");
					break;
				case 6:
					System.out.println("How many datas you need  ");
					int firstN6=getUserInputInt();
					List result6=  (List) dbObj.getRequiredSortedVAlues(  sql_order,firstN6);
					System.out.println(result6);
					break;
				case 7:
					System.out.println("Enter Id to delete ");
					int deleteVar=getUserInputInt();
					dbObj.deleteRow(  sql_delete, deleteVar);
					System.out.println(" Row is deleted");
					x=4;
				case 8:
					System.out.println("Enter your name");
					String name8=getUserInput();
					System.out.println("Enter your Email");
					String Email8=getUserInput();
					System.out.println("Enter your Mobile");
					int Mobile8=getUserInputInt();
					System.out.println("Enter your Department");
					String dept8=getUserInput();
					PojoEmployee pojoObj = new PojoEmployee();
					pojoObj.setName(name8);
					pojoObj.setEmail(Email8);
					pojoObj.setMobile(Mobile8);
					pojoObj.setDepartment(dept8);
					String name1=pojoObj.getName();
					String email=pojoObj.getEmail();
					int num=pojoObj.getMobile();
					String dept88 =pojoObj.getDepartment();
					 dbObj.insertValues(  SQL_INSERT, name1, email, num, dept88) ;
					System.out.println("The values are inserted");
					break;
				case 9:
					dbObj.createTable( sql_Create );
					System.out.println("Table is created");
					break;
				case 10:
					System.out.println("Enter Relation name ");
					String Relationname=getUserInput();
					System.out.println("Enter Relation ship");
					String Reltionship=getUserInput();
					System.out.println("Enter His/her Employee id");
					int empId=getUserInputInt();
					dbObj.insertValues(  SQL_INSERTFK, Relationname, Reltionship, empId);
					System.out.println(" row is created  ");
					break;
				case 11:
					System.out.println("Enter Your  name ");
					String userName=getUserInput();
					List relationList=dbObj.getSearchedvalue(  sql_getFk, userName);
					System.out.println(relationList);

					break;
				case 12:
					System.out.println("How many datas you need  ");
					int firstN12=getUserInputInt();
					List result12=  (List) dbObj.getRequiredSortedVAlues(  sql_orderFK, firstN12);
					System.out.println(result12);
					break;
				case 13:
					check=false;
					break;

				}


			}
			catch(UserException SqlExcep) {
				System.out.println(SqlExcep.getMessage());
			}

		}







	}
}
