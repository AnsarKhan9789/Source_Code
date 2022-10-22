package mainclass;

import java.sql.Connection;
import userexception.UserException;

public class Test {
	public static void main(String[] args)    {
//		PersonPojo pojoObj=new PersonPojo();
//		pojoObj.setName(resultSet.getString("Name"));
//		pojoObj.setEmailId(resultSet.getString("Email"));
//		pojoObj.setMobileNumber(resultSet.getInt("Mobile"));
//		pojoObj.setIdentityToVerify(resultSet.getString("IdentifyToverify"));
//		pojoObj.setPassword(resultSet.getString("Password"));
//		
//		return pojoObj;
		
	
	
	
	
		String url="jdbc:mysql://localhost/BankingDB";
		String uName="root";
		String password="Root@123";
//		Connection myConnection =null;
//		
//			myConnection = DriverManager.getConnection(url,uName,password); 
int length=3;

		String sqlSelect="select PersonTable.IdentityToVerify from PersonTable where UserId in ";
	///*balance*/	String sql_select1="select AccountDetails.Balance from AccountDetails where AccountDetails.UserId= ?  and AccountDetails.AccountNumber=? ";

			//String sql ="UPDATE PersonTable SET Password = ? WHERE UserId = ?";
//		String verify ="";
//		long balance =-1;
//			PreparedStatement myStatement = myConnection.prepareStatement(sqlSelect);
//			myStatement.setInt(1, 2022101);
//			myStatement.setString(2, "ansar@123");
//			
//		ResultSet set = myStatement.executeQuery();
//		if(set.next()) {
//			System.out.println(set.getString("IdentityToVerify"));
//		}
			
			//int rowUpdate=myStatement.executeUpdate();
			//System.out.println(rowUpdate);
//			if(resultSet.next())
//			{
//			
//				balance =resultSet.getLong("Balance");
//		
//			}
//			if(balance!=-1) {
//				System.out.println(balance);
//			}
//			else {
//				System.out.println("Wrong Account number");
//			}
//			
				
			
//		String sql="select TransactionTable.TransactionId, TransactionTable.RecieverAccount,TransactionTable.Statement,TransactionTable.Amount from TransactionTable where TransactionTable.SenderAccount= ? ";
//		try (Connection inputConn = DriverManager.getConnection(url,uName,password);
//			PreparedStatement myStatement = inputConn.prepareStatement(sql);){
//			myStatement.setLong(1, 33161);
//			
//			ResultSet set=myStatement.executeQuery();
//			ResultSetMetaData resultMetaData =(ResultSetMetaData) set.getMetaData();
//			int columns = resultMetaData.getColumnCount();
//			Map<Integer,HashMap<String,Object>> map = new HashMap<Integer,HashMap<String,Object>>();
//			while(set.next()) {
//				HashMap<String,Object> row = new HashMap<String, Object>(columns);
//				for(int i=2; i<=columns; i++) {
//					row.put(resultMetaData.getColumnName(i),set.getObject(i));	
//				}
//				map.put(set.getInt("TransactionId"), row);
//			}
//			System.out.println(map);
//		}
//		catch(SQLException sqlEx) {
//			throw new UserException("You enter a wrong query",sqlEx);
//		}
//		ResultSetMetaData resultMetaData = null;
//		List<HashMap<String,Object>> list =null; 
//		int columns=0;
//		try {
//			//resultMetaData = (ResultSetMetaData) resultSet.getMetaData();
//			columns = resultMetaData.getColumnCount();
//			list = new ArrayList<HashMap<String,Object>>();
//			while (resultSet.next()) {
//				HashMap<String,Object> row = new HashMap<String, Object>(columns);
//				for(int i=1; i<=columns; i++) {
//					row.put(resultMetaData.getColumnName(i),resultSet.getObject(i));
//				}
//				list.add(row);
//			}
//		} catch (SQLException e) {
//			throw new UserException("There is no output related to your query");
//		}

////			
//			String sql="insert into TransactionTable(PrimaryAccount,SecondaryAccount,Amount,UserId) values(?,?,?,?)";
//			try (Connection inputConn =  DriverManager.getConnection(url,uName,password); 
//				PreparedStatement myStatement = inputConn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);){
//				myStatement.setLong(1, 33161);
//				myStatement.setLong(2, 33160);
//				myStatement.setInt(3, 200);
//				myStatement.setInt(4, 2022101);
//				myStatement.execute();
//				ResultSet s=myStatement.getGeneratedKeys();
//				if(s.next()) {
//					System.out.println(s.getInt(1));
//				}
//				
//
//
//			}
//			catch(SQLException sqlEx) {
//				throw new UserException("You enter a wrong query",sqlEx);
//			}
		
//		String sql_select="update TransactionTable set Status='Success', Balance=1290 Where TransactionId=100";
//		//String sql_select="select * ,CustomerTable.CustomerStatus from PersonTable inner join CustomerTable on UserId=CustomerId where UserId = ? and Password= ?";
//		//String sql_select="select * from PersonTable where UserId = ? and Password= ?";
//		Connection inputConn =null;
//		Statement myStatement = null;
//		ResultSet resultSet=null;
//		TransactionPojo pojoObj =null;
//		try {
//			inputConn = DriverManager.getConnection(url,uName,password);
//			myStatement = inputConn.createStatement();
//			myStatement.executeUpdate(sql_select,PreparedStatement.RETURN_GENERATED_KEYS);
//			
//			
//		
////			if(resultSet.next()) {
////				 pojoObj=new TransactionPojo();
////				 pojoObj.setTransactionId(resultSet.getInt("TransactionId"));
////				pojoObj.setPrimaryAccount(resultSet.getLong("PrimaryAccount"));
////				pojoObj.setAmounts(resultSet.getLong("Amount"));
////				pojoObj.setStatus(resultSet.getString("Status"));
////				pojoObj.setBalance(resultSet.getLong("Balance"));
////			
////	
////			}
//			
////			UPDATE Customers
//			SET ContactName = 'Alfred Schmidt', City= 'Frankfurt'
//			WHERE CustomerID = 1;
//			
			//System.out.println(pojoObj.getStatus());

//		}
//		catch(SQLException sqlEx) {
//			throw new UserException("You enter a wrong query",sqlEx);
//		}
		
		String sqlBuild="UPDATE PersonTable SET";
		String sqlName="Name ="+"Ansar";
		//String sqlEmail="Mobile ="+inputPerson.getMobileNumber();
		//String sqlMobile="Email= "+inputPerson.getEmailId();
		String sqlWhere="WHERE UserId ="+2022101;

		StringBuilder sqlBuilder = new StringBuilder(sqlBuild);
		sqlBuilder.append("'"+sqlName+"'");
		sqlBuilder.append(sqlWhere);
		String sql=sqlBuilder.toString();
		System.out.println(sql);
//	  
		long milli=System.currentTimeMillis();
		long account=2022101;
		String refId="Ref"+String.valueOf(milli);
		System.out.println(refId);
System.out.println(milli-1666412740000l);
//		long value= (System.currentTimeMillis()-1666412740000l);
		String values =String.valueOf(milli-1666412740000l);
		String accounts =String.valueOf(account);
		System.out.println(values+accounts);
		
	}
			


}
