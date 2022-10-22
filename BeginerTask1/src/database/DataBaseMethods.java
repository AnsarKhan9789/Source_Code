package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import exception.UserException;

public class DataBaseMethods {
	private List makeArraylist(ResultSet inputResultSet) throws UserException {
		ResultSetMetaData resultMetaData = null;
		List<HashMap<String,Object>> list =null; 
		int columns=0;
		try {
			resultMetaData = (ResultSetMetaData) inputResultSet.getMetaData();
			String calass=resultMetaData.getColumnClassName(1);
			columns = resultMetaData.getColumnCount();
			list = new ArrayList<HashMap<String,Object>>();
			while (inputResultSet.next()) {
				HashMap<String,Object> row = new HashMap<String, Object>(columns);
				for(int i=1; i<=columns; i++) {
					row.put(resultMetaData.getColumnName(i),inputResultSet.getObject(i));
				}
				list.add(row);
			}
		} catch (SQLException e) {
			throw new UserException("There is no output related to your query");
		}

		return list;
	}
	private Connection getConnection() throws  UserException {
		String url="jdbc:mysql://localhost/IncubationDb";
		String uName="root";
		String password="Root@123";
		Connection myConnection =null;
		try {
			myConnection = DriverManager.getConnection(url,uName,password); 
			return myConnection;
		}
		catch(SQLException sqlEx) {
			throw new UserException("There is a issue in connection ",sqlEx);
		}

	}
	private void close(ResultSet inputSet,Statement inputStatement,Connection myConnection) {
		try {
			if(inputSet!=null) {
				inputSet.close();
			}

		}
		catch(SQLException e) {}
		try {
			if(inputStatement!=null) {
				inputStatement.close();
			}

		}
		catch(SQLException e) {}
		try {
			if(myConnection!=null) {
				myConnection.close();
			}

		}
		catch(SQLException e) {}



	}


	public void createTable(String sql ) throws  UserException {
		try(Connection inputConn=getConnection();
				Statement statement1=inputConn.createStatement();){

			statement1.executeUpdate(sql);
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);

		}

	}
	public void insertValues(String sql,String name,String email,int mobile,String department) throws  UserException {
		try(Connection inputConn=getConnection();
				PreparedStatement preparedStatement = inputConn.prepareStatement(sql);){
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setInt(3, mobile);
			preparedStatement.setString(4, department);
			preparedStatement.executeUpdate();
		}

		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);

		}


	}
	public void insertValues(String sql,String name,String relation,int empId) throws  UserException {
		try(Connection inputConn=getConnection();
				PreparedStatement preparedStatement = inputConn.prepareStatement(sql);){
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, relation);
			preparedStatement.setInt(3, empId);
			preparedStatement.executeUpdate();

		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);

		}


	}
	public List getSearchedvalue(String sql,String searchValue) throws  UserException {
		Connection inputConn=null;
		PreparedStatement myStatement=null;
		ResultSet resultSet=null;

		try {
			inputConn = getConnection();
			myStatement = inputConn.prepareStatement(sql);
			myStatement.setString(1, searchValue);
			resultSet = myStatement.executeQuery();
			List list=makeArraylist(resultSet);

			return list;
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);

		}
		finally {


			close(resultSet,myStatement,inputConn);


		}


	}
	public List getSearchedvalue(String sql,int limit) throws  UserException {
		Connection inputConn=null;
		PreparedStatement myStatement=null;
		ResultSet resultSet=null;

		try {
			inputConn=getConnection();
			myStatement=inputConn.prepareStatement(sql);
			myStatement.setInt(1, limit);
			resultSet = myStatement.executeQuery();
			List list=makeArraylist(resultSet);

			return list;
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);

		}
		finally {
			close(resultSet,myStatement,inputConn);
		}

	}
	public void updateDB(String sql,String department,String name) throws  UserException {
		try(Connection inputConn=getConnection();
				PreparedStatement preparedStatement = inputConn.prepareStatement(sql);){
			preparedStatement.setString(1, department);
			preparedStatement.setString(2, name);

			preparedStatement.executeUpdate();
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);

		}


	}
	public List getRequiredValues(String sql,int required) throws UserException {

		Connection inputConn=null;
		PreparedStatement myStatement =null;
		ResultSet resultSet=null;

		try {
			inputConn=getConnection();
			myStatement =inputConn.prepareStatement(sql);
			myStatement.setInt(1, required);
			resultSet =myStatement.executeQuery();
			List list=makeArraylist(resultSet);
			return list;
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);

		}
		finally {
			close(resultSet,myStatement,inputConn);

		}




	}
	public List getRequiredSortedVAlues(String sql,int limit) throws  UserException {
		Connection inputConn=null;
		PreparedStatement preparedStatement =null;
		ResultSet resultSet=null;
		try {
			inputConn=getConnection();
			preparedStatement=inputConn.prepareStatement(sql);
			preparedStatement.setInt(1, limit);
			resultSet =preparedStatement.executeQuery();

			List list=makeArraylist(resultSet);
			return list;
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);

		}
		finally {
			close(resultSet,preparedStatement,inputConn);
		}



	}
	public void deleteRow(String sql,int id) throws  UserException {
		try(Connection inputConn=getConnection();
				PreparedStatement myStatement=inputConn.prepareStatement(sql);){
			myStatement.setInt(1, id);
			myStatement.executeUpdate();
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);

		}


	}


}
