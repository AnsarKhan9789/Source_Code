package storagelayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import userexception.UserException;
import utilpackage.Util;
import methods.AccountsPojo;
import methods.NonTransactionRequest;
import methods.PersonPojo;
import methods.TransactionPojo;
import methods.TransactionRequest;

public class DatabaseMethods implements StorageMethods {

	private Connection getConnection() throws UserException {
		String url="jdbc:mysql://localhost/BankingDB";
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
	private int getUserId(long accountNumber) throws UserException {
		String sqlSelect="select AccountDetails.UserId from AccountDetails where  AccountDetails.AccountNumber=? ";
		int userId =0;
		ResultSet resultSet=null;
		PreparedStatement myStatement = null;
		Connection inputConn =null;

		try {
			inputConn = getConnection();
			myStatement = inputConn.prepareStatement(sqlSelect);
			myStatement.setLong(1, accountNumber);
			resultSet = myStatement.executeQuery();
			if(resultSet.next()) {
				userId = resultSet.getInt("UserId");
			}
			return userId;

		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}

		finally {
			close(resultSet,myStatement,inputConn);

		}	

	}
	public long getBalance(long accountNumber) throws UserException {
		String sqlSelect="select AccountDetails.Balance from AccountDetails where  AccountDetails.AccountNumber=? ";
		long balance =-1;
		ResultSet resultSet=null;
		PreparedStatement myStatement = null;
		Connection inputConn =null;

		try {
			inputConn = getConnection();
			myStatement = inputConn.prepareStatement(sqlSelect);
			myStatement.setLong(1, accountNumber);
			resultSet = myStatement.executeQuery();
			if(resultSet.next()) {
				balance =(long) resultSet.getDouble("Balance");
			}
			return balance;

		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}

		finally {
			close(resultSet,myStatement,inputConn);

		}	

	}
	private void changeBalance(long balance,long accountNumber) throws UserException {
		String sql ="UPDATE AccountDetails SET Balance = ? WHERE AccountNumber = ?";

		try (Connection inputConn = getConnection();
				PreparedStatement myStatement = inputConn.prepareStatement(sql);){
			myStatement.setLong(1, balance);
			myStatement.setLong(2, accountNumber);
			myStatement.executeUpdate();
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}



	}
	private void updateTheTransactionTable(TransactionPojo input) throws UserException {
		String sql="insert into TransactionTable(UserId,PrimaryAccount,SecondaryAccount,Type,Details,Amount,Status,TransactionTime,Balance,ReferenceId) values(?,?,?,?,'Transfer',?,'Success',?,?,?)";
		try (Connection inputConn = getConnection();
				PreparedStatement myStatement = inputConn.prepareStatement(sql);){
			myStatement.setLong(1, input.getUserId());
			myStatement.setLong(2, input.getPrimaryAccount());
			myStatement.setLong(3, input.getSecondaryAccount());
			myStatement.setString(4, input.getType());
			myStatement.setLong(5, input.getAmounts());
			myStatement.setLong(6, input.getTransactionTime());
			myStatement.setLong(7, input.getBalance());
			myStatement.setString(8, input.getReferenceId());
			myStatement.executeUpdate();
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}
	}
	private int updateThePersonTable(PersonPojo input) throws UserException {
		int userId=0;
		String sql="insert into PersonTable(Name,Email,Mobile,IdentityToVerify,Password) values(?,?,?,?,?)";
		try (Connection inputConn = getConnection();
				PreparedStatement myStatement = inputConn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);){
			myStatement.setString(1, input.getName());
			myStatement.setString(2, input.getEmailId());
			myStatement.setLong(3, input.getMobileNumber());
			myStatement.setString(4, input.getIdentityToVerify());
			myStatement.setString(5, input.getPassword());
			myStatement.executeUpdate();
			try(ResultSet transactionIdKeys=myStatement.getGeneratedKeys();){
				if(transactionIdKeys.next()) {
					userId=transactionIdKeys.getInt(1);
				}
			}
			input.setUserId(userId);
			updateTheCustomerTable(input);
			return userId;
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}
	}
	private void updateTheCustomerTable(PersonPojo input) throws UserException {
		String sql="insert into CustomerTable(CustomerId,AadharNumber,PanCard,CustomerStatus) values(?,?,?,?)";
		try (Connection inputConn = getConnection();
				PreparedStatement myStatement = inputConn.prepareStatement(sql);){
			myStatement.setInt(1, input.getUserId());
			myStatement.setLong(2, input.getAadharCard());
			myStatement.setString(3, input.getPanCard());
			myStatement.setString(4, input.getUserStatus());
			myStatement.executeUpdate();

		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}
	}
	private void insertTheTransactionRequest(TransactionRequest input) throws UserException {
		String sql="insert into TransactionRequest(AccountNumber,Status,Amount,TransactionId,UserId) Values(?,'Requested',?,?,?)";
		try (Connection inputConn = getConnection();
				PreparedStatement myStatement = inputConn.prepareStatement(sql);){
			myStatement.setLong(1, input.getAccountNumber());
			myStatement.setLong(2, input.getAmount());
			myStatement.setInt(3, input.getTransactionId());
			myStatement.setInt(4, input.getUserId());
			myStatement.executeUpdate();
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}
	}
	
	
	private void changeForWithdraw(TransactionPojo  input) throws UserException {
		String sql="update TransactionTable set Status=?,Balance=?,TransactionTime=? Where TransactionId=? ";
		try (Connection inputConn = getConnection();
				PreparedStatement myStatement = inputConn.prepareStatement(sql);){

			myStatement.setString(1, input.getStatus());
			myStatement.setLong(2,input.getBalance());
			myStatement.setLong(3, System.currentTimeMillis());
			myStatement.setLong(4,input.getTransactionId());
			myStatement.executeUpdate();

		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}
	}

	private void updateForDeposit(TransactionPojo input) throws UserException {
	
		String sql="insert into TransactionTable(UserId,PrimaryAccount,SecondaryAccount,Type,Details,Amount,Status,TransactionTime,Balance,ReferenceId) values(?,?,Null,'Credit','Deposit',?,'Success',?,?,?)";
		try (Connection inputConn = getConnection();
				PreparedStatement myStatement = inputConn.prepareStatement(sql);){
			long millis=System.currentTimeMillis();
			String refId="Ref"+String.valueOf(millis);
			myStatement.setLong(1, input.getUserId());
			myStatement.setLong(2, input.getPrimaryAccount());
			myStatement.setLong(3, input.getAmounts());
			myStatement.setLong(4, millis);
			myStatement.setLong(5, input.getBalance());
			myStatement.setString(6, refId);
			myStatement.execute();
			
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}
	}
	@SuppressWarnings("null")
	private void updateForWithdraw(TransactionPojo input) throws UserException {
		int transactionId=0;
		String sql="insert into TransactionTable(UserId,PrimaryAccount,SecondaryAccount,Type,Details,Amount,Status,TransactionTime,Balance,ReferenceId) values(?,?,Null,'Debit','WithDraw',?,'Requested',?,?,?)";
		try (Connection inputConn = getConnection();
				PreparedStatement myStatement = inputConn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);){
			long millis=System.currentTimeMillis();
			String refId="Ref"+String.valueOf(millis);
			myStatement.setLong(1, input.getUserId());
			myStatement.setLong(2, input.getPrimaryAccount());
			myStatement.setLong(3, input.getAmounts());
			myStatement.setLong(4, millis);
			myStatement.setLong(5, input.getBalance());
			myStatement.setString(6, refId);
			myStatement.executeUpdate();
			try(ResultSet transactionIdKeys=myStatement.getGeneratedKeys();){
				if(transactionIdKeys.next()) {
					transactionId=transactionIdKeys.getInt(1);
				}
			}
			TransactionRequest requestPojo=new TransactionRequest();
			requestPojo.setAccountNumber(input.getPrimaryAccount());
			requestPojo.setAmount(input.getAmounts());
			requestPojo.setUserId(input.getUserId());
			requestPojo.setTransactionId(transactionId);
			insertTheTransactionRequest(requestPojo);
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}
		
	}
	private void insertNonTransactionRequest(NonTransactionRequest input) throws UserException {
		String sql="insert into NonTransactionRequest(UserId,AccountNumber,Status,RequestStatus,Statement) values(?,?,?,'Requested',?)";
		try (Connection inputConn = getConnection();
				PreparedStatement myStatement = inputConn.prepareStatement(sql);){
			myStatement.setInt(1, input.getUserId());
			myStatement.setLong(2, input.getAccountNumber());
			myStatement.setString(3, input.getStatus());
			myStatement.setString(4, input.getStatement());
			myStatement.executeUpdate();
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}
	}
	private void changeForNonTransactionRequest(NonTransactionRequest  input) throws UserException {
		String sql="update NonTransactionRequest set Status=?,RequestStatus=?,Statement=? Where RequestId=? ";
		try (Connection inputConn = getConnection();
				PreparedStatement myStatement = inputConn.prepareStatement(sql);){

			myStatement.setString(1, input.getStatus());
			myStatement.setString(2,input.getRequestStatus());
			myStatement.setString(4,input.getStatement());
			myStatement.executeUpdate();

		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}
	}
	private Map<Integer, Map<String, Object>> convertToTransactionsMap(String sql,long accountNumber)throws UserException{
		Connection inputConn =null;
		PreparedStatement myStatement = null;
		ResultSet resultSet=null;
		Map<Integer,Map<String,Object>> map =null;
		try {
			inputConn = getConnection();
			myStatement = inputConn.prepareStatement(sql);
			myStatement.setLong(1, accountNumber);
			resultSet=myStatement.executeQuery();
			ResultSetMetaData resultMetaData =(ResultSetMetaData) resultSet.getMetaData();
			int columns = resultMetaData.getColumnCount();
			map = new HashMap<Integer,Map<String,Object>>();
			while(resultSet.next()) {
				Map<String,Object> row = new HashMap<String, Object>(columns);
				for(int i=2; i<=columns; i++) {
					row.put(resultMetaData.getColumnName(i),resultSet.getObject(i));	
				}
				map.put(resultSet.getInt("TransactionId"), row);
			}
			return map;

		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}

		finally {
			close(resultSet,myStatement,inputConn);

		}	

	}
	private Map<Integer, TransactionPojo> convertToTransactionMap(ResultSet resultSet)throws UserException{

		Map<Integer,TransactionPojo> map =null;
		try {
			map = new HashMap<Integer,TransactionPojo>();
			while(resultSet.next()) {
				TransactionPojo transPojoObj=createTransactionPojo(resultSet);
				map.put(resultSet.getInt("TransactionId"),transPojoObj);	
			}
		}
		catch(SQLException sqlEx) {
			throw new UserException("The resultset is empty",sqlEx);
		}


		return map;
	}
	private Map<Integer,Map<Long,AccountsPojo>>  convertToAccountsMap(ResultSet resultSet)throws UserException{

		Map<Integer,Map<Long,AccountsPojo>> accountMap=null;
		try {
			accountMap=new HashMap<Integer,Map<Long,AccountsPojo>>();
			Map<Long,AccountsPojo> map=null;
			while(resultSet.next()) {
				AccountsPojo transPojoObj=createAccountsPojo(resultSet);
				if(accountMap.get(transPojoObj.getUserId())==null) {
					map=new HashMap<Long,AccountsPojo>();
				}
				map.put(transPojoObj.getAccountNumber(),transPojoObj);	
				accountMap.put(transPojoObj.getUserId(), map);
			}
			
		}
		catch(SQLException sqlEx) {
			throw new UserException("The resultset is empty",sqlEx);
		}


		return accountMap;
	}
	private Map<Integer, PersonPojo> convertToUserMap(ResultSet resultSet)throws UserException{

		Map<Integer,PersonPojo> map =null;
		try {
			map = new HashMap<Integer,PersonPojo>();
			while(resultSet.next()) {
				PersonPojo personPojo=createPersonPojo(resultSet);
				map.put(resultSet.getInt("UserId"),personPojo);	
			}
		}
		catch(SQLException sqlEx) {
			throw new UserException("The resultset is empty",sqlEx);
		}


		return map;
	}
	private Map<Integer, NonTransactionRequest> convertToNonTransactionRequest(ResultSet resultSet)throws UserException{

		Map<Integer,NonTransactionRequest> map =null;
		try {
			map = new HashMap<Integer,NonTransactionRequest>();
			while(resultSet.next()) {
				NonTransactionRequest personPojo=createNonTransactionRequest(resultSet);
				map.put(resultSet.getInt("RequestId"),personPojo);	
			}
		}
		catch(SQLException sqlEx) {
			throw new UserException("The resultset is empty",sqlEx);
		}


		return map;
	}
	private Map<Integer, TransactionRequest> convertToTransactionRequest(ResultSet resultSet)throws UserException{

		Map<Integer,TransactionRequest> map =null;
		try {
			map = new HashMap<Integer,TransactionRequest>();
			while(resultSet.next()) {
				TransactionRequest personPojo=createTransactionRequest(resultSet);
				map.put(resultSet.getInt("RequestId"),personPojo);	
			}
		}
		catch(SQLException sqlEx) {
			throw new UserException("The resultset is empty",sqlEx);
		}


		return map;
	}
	private PersonPojo createPersonPojo(ResultSet inputResultSet) throws SQLException {
		PersonPojo pojoObj=new PersonPojo();
		pojoObj.setUserId(inputResultSet.getInt("UserId"));
		pojoObj.setName(inputResultSet.getString("Name"));
		pojoObj.setEmailId(inputResultSet.getString("Email"));
		pojoObj.setMobileNumber(inputResultSet.getLong("Mobile"));
		pojoObj.setIdentityToVerify(inputResultSet.getString("IdentityToVerify"));
		pojoObj.setPassword(inputResultSet.getString("Password"));
		pojoObj.setUserStatus(inputResultSet.getString("CustomerStatus"));
		return pojoObj;
	}
	private TransactionPojo createTransactionPojo(ResultSet inputResultSet) throws SQLException {
		TransactionPojo pojoObj=new TransactionPojo();
		pojoObj.setTransactionId(inputResultSet.getInt("TransactionId"));
		pojoObj.setUserId(inputResultSet.getInt("UserId"));
		pojoObj.setPrimaryAccount(inputResultSet.getLong("PrimaryAccount"));
		pojoObj.setSecondaryAccount(inputResultSet.getLong("SecondaryAccount"));
		pojoObj.setType(inputResultSet.getString("Type"));
		pojoObj.setAmounts(inputResultSet.getLong("Amount"));
		pojoObj.setStatus(inputResultSet.getString("Status"));
		pojoObj.setDetails(inputResultSet.getString("Details"));
		pojoObj.setTransactionTime(inputResultSet.getLong("TransactionTime"));
		return pojoObj;
	}
	private AccountsPojo createAccountsPojo(ResultSet inputResultSet) throws SQLException {
		AccountsPojo pojoObj=new AccountsPojo();
		pojoObj.setAccountNumber(inputResultSet.getLong("AccountNumber"));
		pojoObj.setBalance(inputResultSet.getLong("Balance"));
		pojoObj.setBranch(inputResultSet.getString("Branch"));
		pojoObj.setIfscCode(inputResultSet.getString("IFSC"));
		pojoObj.setUserId(inputResultSet.getInt("UserId"));
		pojoObj.setAccountStatus(inputResultSet.getString("AccountStatus"));

		return pojoObj;
	}
	private TransactionRequest createTransactionRequest(ResultSet inputResultSet) throws SQLException {
		TransactionRequest pojoObj=new TransactionRequest();
		pojoObj.setRequestId(inputResultSet.getInt("RequestId"));
		pojoObj.setAccountNumber(inputResultSet.getLong("AccountNumber"));
		pojoObj.setAmount(inputResultSet.getLong("Amount"));
		pojoObj.setStatus(inputResultSet.getString("Status"));
		pojoObj.setUserId(inputResultSet.getInt("UserId"));
		pojoObj.setTransactionId(inputResultSet.getInt("TransactionId"));

		return pojoObj;
	}
	private NonTransactionRequest createNonTransactionRequest(ResultSet inputResultSet) throws SQLException {
		NonTransactionRequest pojoObj=new NonTransactionRequest();
		pojoObj.setRequestId(inputResultSet.getInt("RequestId"));
		pojoObj.setAccountNumber(inputResultSet.getLong("AccountNumber"));
		pojoObj.setStatus(inputResultSet.getString("Status"));
		pojoObj.setUserId(inputResultSet.getInt("UserId"));
		pojoObj.setStatement(inputResultSet.getString("Statement"));
		pojoObj.setRequestStatus(inputResultSet.getString("RequestStatus"));

		return pojoObj;
	}
	
	public PersonPojo getUserIdDetails(int userId,String password) throws UserException {
		String sql_select="select * ,CustomerTable.CustomerStatus from PersonTable inner join CustomerTable on UserId=CustomerId where UserId = ? and Password= ?";
		ResultSet resultSet=null;
		PreparedStatement myStatement = null;
		Connection inputConn =null;
		PersonPojo identityToVerify =null;
		try {
			inputConn = getConnection();
			myStatement = inputConn.prepareStatement(sql_select);
			myStatement.setInt(1, userId);
			myStatement.setString(2, password);
			resultSet = myStatement.executeQuery();
			if(resultSet.next()) {
				identityToVerify =createPersonPojo(resultSet);
			}
			return identityToVerify;

		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}

		finally {
			close(resultSet,myStatement,inputConn);

		}	

	}


	@Override
	public void sendTheMoney(long senderAccountNumber,long recieverAccountNumber, int amount) throws UserException {


		long senderBalance=getBalance(senderAccountNumber); 
		if(senderBalance<amount) {
			throw new UserException("Your balance is lower than the sending amount ");
		}
		long recieverBalance =getBalance(recieverAccountNumber); 
		if(recieverBalance==-1) {
			throw new UserException("The Receiver Account number does not exist");
		}
		long millis= System.currentTimeMillis();
		String refId="Ref"+String.valueOf(millis);
		recieverBalance=recieverBalance+amount;
		senderBalance=senderBalance-amount;
		changeBalance(recieverBalance,recieverAccountNumber);
		changeBalance(senderBalance,senderAccountNumber);
		int sendUserId=getUserId(senderAccountNumber);
		int recieverUserId=getUserId(recieverAccountNumber);
		TransactionPojo sender =new TransactionPojo();
		sender.setPrimaryAccount(senderAccountNumber);
		sender.setSecondaryAccount(recieverAccountNumber);
		sender.setUserId(sendUserId);
		sender.setAmounts(amount);
		sender.setStatus("Debit");
		sender.setBalance(senderBalance);
		sender.setTransactionTime(millis);
		sender.setReferenceId(refId);
		updateTheTransactionTable(sender);
		
		TransactionPojo reciever =new TransactionPojo(recieverUserId,recieverAccountNumber,senderAccountNumber,"Credit",amount,recieverBalance);
		reciever.setTransactionTime(millis);
		reciever.setReferenceId(refId);
		updateTheTransactionTable(reciever);
	}

	@Override
	public void deposit(int userId, long accountNumber, int amount) throws UserException {
		long balance=getBalance(accountNumber);
		balance=balance+amount;
		changeBalance(balance,accountNumber);
		TransactionPojo input = new TransactionPojo();
		input.setBalance(balance);
		input.setUserId(userId);
		input.setPrimaryAccount(accountNumber);
		input.setAmounts(amount);
		updateForDeposit(input);



	}
	@Override
	public void withDraw(int userId, long accountNumber, int amount) throws UserException {
		long balance=getBalance(accountNumber);
		if(balance<amount) {
			throw new UserException("The balance is lesser than transaction amount");
		}
		TransactionPojo input = new TransactionPojo();
		input.setBalance(balance);
		input.setUserId(userId);
		input.setPrimaryAccount(accountNumber);
		input.setAmounts(amount);
		
		//changeBalance(balance,accountNumber);
		updateForWithdraw(input);

	}

	@Override
	public void changePassword(int userId, String inputPassword) throws UserException {
		String sql ="UPDATE PersonTable SET Password = ? WHERE UserId = ?";


		try (Connection inputConn = getConnection();
				PreparedStatement myStatement = inputConn.prepareStatement(sql);){

			myStatement.setString(1, inputPassword);
			myStatement.setInt(2, userId);

			myStatement.executeUpdate();


		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}




	}



	@Override
	public void edit(PersonPojo inputPerson,int choice) throws UserException {
		// TODO Auto-generated method stub
		try (Connection inputConn = getConnection();
				Statement statement1=inputConn.createStatement();){
			String sqlBuild="UPDATE PersonTable SET";
			String sqlName=" Name = '"+inputPerson.getName()+"'";
			String sqlEmail=" Mobile = "+inputPerson.getMobileNumber();
			String sqlMobile=" Email= '"+inputPerson.getEmailId()+"'";
			String sqlWhere=" WHERE UserId = " +inputPerson.getUserId();

			switch(choice) {
			case 1:
				
				StringBuilder sqlBuilder = new StringBuilder(sqlBuild);
				sqlBuilder.append(sqlName);
				sqlBuilder.append(sqlWhere);
				String sql=sqlBuilder.toString();
				statement1.executeUpdate(sql);
				break;
			case 2:
				
				StringBuilder sqlBuilder2 = new StringBuilder(sqlBuild);
				sqlBuilder2.append(sqlMobile);
				sqlBuilder2.append(sqlWhere);
				String sql2 =sqlBuilder2.toString();
				statement1.executeUpdate(sql2);
				break;
			case 3: 
				StringBuilder sqlBuilder3 = new StringBuilder(sqlBuild);
				sqlBuilder3.append(sqlEmail);
				sqlBuilder3.append(sqlWhere);
				String sql3 =sqlBuilder3.toString();
				statement1.executeUpdate(sql3);
				break;
			case 4:
				StringBuilder sqlBuilder4 = new StringBuilder(sqlBuild);
				sqlBuilder4.append(sqlName);
				sqlBuilder4.append(','+sqlMobile);
				sqlBuilder4.append(sqlWhere);
				String sql4 =sqlBuilder4.toString();
				statement1.executeUpdate(sql4);

				break;
			case 5:{
				StringBuilder sqlBuilder5 = new StringBuilder(sqlBuild);
				sqlBuilder5.append(sqlName);
				sqlBuilder5.append(','+sqlEmail);
				sqlBuilder5.append(sqlWhere);
				String sql5 =sqlBuilder5.toString();
				statement1.executeUpdate(sql5);
			}
			break;
			case 6:{
				Util.isCorrectEmail(inputPerson.getEmailId());
				Util.isValidMobile(inputPerson.getMobileNumber());
				StringBuilder sqlBuilder6 = new StringBuilder(sqlBuild);
				sqlBuilder6.append(sqlEmail);
				sqlBuilder6.append(','+sqlMobile);
				sqlBuilder6.append(sqlWhere);
				String sql6 =sqlBuilder6.toString();
				statement1.executeUpdate(sql6);

			}

			break;
			case 7:{
				StringBuilder sqlBuilder7 = new StringBuilder(sqlBuild);
				sqlBuilder7.append(sqlName);
				sqlBuilder7.append(','+sqlEmail);
				sqlBuilder7.append(','+sqlMobile);
				sqlBuilder7.append(sqlWhere);
				String sql7 =sqlBuilder7.toString();
				statement1.executeUpdate(sql7);

			}

			break;

			default:
				break;
			}

		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}

	}

	@Override
	public Map<String, Map<Integer, Map<String, Object>>> viewFullStatement(long accountNumber) throws UserException {
		String sqlSender="select TransactionTable.TransactionId, TransactionTable.RecieverAccount,TransactionTable.Statement,TransactionTable.Amount from TransactionTable where TransactionTable.SenderAccount= ? ";
		String sqlReciever="select TransactionTable.TransactionId, TransactionTable.SenderAccount,TransactionTable.Statement,TransactionTable.Amount from TransactionTable where TransactionTable.RecieverAccount= ? ";
		Map<Integer,Map<String,Object>> sender =convertToTransactionsMap(sqlSender,accountNumber);
		Map<Integer,Map<String,Object>> reciever =convertToTransactionsMap(sqlReciever,accountNumber);
		Map<String,Map<Integer,Map<String,Object>>> transaction = new HashMap<String,Map<Integer,Map<String,Object>>>();
		transaction.put("Sender", sender);
		transaction.put("Reciever", reciever);
		return transaction;
	}
	@Override
	public Map<Integer, PersonPojo> viewUserDetails(int... userId) throws UserException {
		if(userId.length==0){
			getAllUserDetails();
		}
		String sql="select * ,CustomerTable.CustomerStatus from PersonTable inner join CustomerTable on UserId=CustomerId where UserId = ?";
		Connection inputConn =null;
		PreparedStatement myStatement = null;
		ResultSet resultSet=null;
		Map<Integer, PersonPojo> person=new HashMap<Integer, PersonPojo>();
		
		try {
			inputConn = getConnection();
			myStatement = inputConn.prepareStatement(sql);
			for(int i=0;i<userId.length;i++) {
				PersonPojo person1=new PersonPojo();
				myStatement.setInt(1, userId[i]);
				resultSet = myStatement.executeQuery();
				if(resultSet.next()) {
					person1=createPersonPojo(resultSet);
				}
				person.put(userId[i], person1);
			}
			
			
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}

		finally {
			close(resultSet,myStatement,inputConn);


		}	
		return person;

	}
	@Override
	public Map<Integer,TransactionPojo> getTransactionDetails(long accountNumber) throws UserException {
		String sql="select * from TransactionTable where TransactionTable.PrimaryAccount= ? ";
		Connection inputConn =null;
		PreparedStatement myStatement = null;
		ResultSet resultSet=null;
		Map<Integer,TransactionPojo>  transactionMap=null;
		try {
			inputConn = getConnection();
			myStatement = inputConn.prepareStatement(sql);
			myStatement.setLong(1, accountNumber);
			resultSet=myStatement.executeQuery();
			transactionMap=convertToTransactionMap(resultSet);

		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}

		finally {
			close(resultSet,myStatement,inputConn);

		}

		return transactionMap;
	}
	@Override
	public List<Long> getUserAccountList(int userId) throws UserException {
		String sql="select AccountDetails.AccountNumber from AccountDetails where UserId=?";
		Connection inputConn =null;
		PreparedStatement myStatement = null;
		ResultSet resultSet=null;
		List<Long> accountList=null;
		try {
			inputConn = getConnection();
			myStatement = inputConn.prepareStatement(sql);
			myStatement.setInt(1, userId);
			resultSet = myStatement.executeQuery();
			accountList=new ArrayList<Long>();
			while(resultSet.next()) {
				accountList.add(resultSet.getLong("AccountNumber"));
			}
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}

		finally {
			close(resultSet,myStatement,inputConn);


		}	
		return accountList;



	}
	@Override
	public Map<Integer, TransactionPojo> getAllTransactionDetails() throws UserException {
		String sql="select * from TransactionTable  ";
		Connection inputConn =null;
		PreparedStatement myStatement = null;
		ResultSet resultSet=null;
		Map<Integer,TransactionPojo>  transactionMap=null;
		try {
			inputConn = getConnection();
			myStatement = inputConn.prepareStatement(sql);
			resultSet=myStatement.executeQuery();
			transactionMap=convertToTransactionMap(resultSet);
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}

		finally {
			close(resultSet,myStatement,inputConn);

		}

		return transactionMap;

	}
	@Override
	public Map<Integer,Map<Long,AccountsPojo>> viewAccountDetails(int userId) throws UserException {
		String sql="select * from AccountDetails where UserId=?" ;
		Connection inputConn =null;
		PreparedStatement myStatement = null;
		ResultSet resultSet=null;
		Map<Integer,Map<Long,AccountsPojo>>   accountsMap=null;
		try {
			inputConn = getConnection();
			myStatement = inputConn.prepareStatement(sql);
			myStatement.setInt(1, userId);
			resultSet=myStatement.executeQuery();
			accountsMap=convertToAccountsMap(resultSet);
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}

		finally {
			close(resultSet,myStatement,inputConn);

		}
		return accountsMap;
	}
	@Override
	public Map<Integer,Map<Long,AccountsPojo>>  getAllAccountDetailsDetails() throws UserException {
		String sql="select * from AccountDetails " ;
		Connection inputConn =null;
		PreparedStatement myStatement = null;
		ResultSet resultSet=null;
		Map<Integer,Map<Long,AccountsPojo>>  accountsMap=null;
		try {
			inputConn = getConnection();
			myStatement = inputConn.prepareStatement(sql);
			resultSet=myStatement.executeQuery();
			accountsMap=convertToAccountsMap(resultSet);
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}

		finally {
			close(resultSet,myStatement,inputConn);

		}
		return accountsMap;
	}

	@Override

	public Map<Integer,PersonPojo> getAllUserDetails()throws UserException{
		String sql_select="select * ,CustomerTable.CustomerStatus from PersonTable inner join CustomerTable on UserId=CustomerId ";
		Connection inputConn =null;
		PreparedStatement myStatement = null;
		ResultSet resultSet=null;
		Map<Integer,PersonPojo>  userMap=null;
		try {
			inputConn = getConnection();
			myStatement = inputConn.prepareStatement(sql_select);
			resultSet=myStatement.executeQuery();
			userMap=convertToUserMap(resultSet);

		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}

		finally {
			close(resultSet,myStatement,inputConn);

		}
		return userMap;

	}
	@Override
	public Map<Integer, TransactionRequest>  getWithdrawlRequests() throws UserException {
		String sql="select * from TransactionRequest Where Status='Requested'";
		Connection inputConn =null;
		PreparedStatement myStatement = null;
		ResultSet resultSet=null;
		Map<Integer, TransactionRequest> transactionMap=null;
		try {
			inputConn = getConnection();
			myStatement = inputConn.prepareStatement(sql);
			resultSet=myStatement.executeQuery();
			transactionMap=convertToTransactionRequest(resultSet);

		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}

		finally {
			close(resultSet,myStatement,inputConn);

		}

		return transactionMap;
	}
	@Override
	public void updateTheTransactionRequest(TransactionRequest input) throws UserException {
		String sql="update TransactionRequest set status=? where RequestId=? ";
		TransactionPojo transaction =new TransactionPojo();
		long balance=0;
		try (Connection inputConn = getConnection();
				PreparedStatement myStatement = inputConn.prepareStatement(sql);){
			myStatement.setString(1, input.getStatus());
			myStatement.setInt(2, input.getRequestId());
			myStatement.executeUpdate();
			if(input.getStatus().equals("Success")) {
				balance=getBalance(input.getAccountNumber());
				balance=balance-input.getAmount();
				transaction.setStatus("Success");
				transaction.setBalance(balance);
				transaction.setTransactionId(input.getTransactionId());
				changeBalance(balance,input.getAccountNumber());
				
			}
		
			else {
				balance=getBalance(input.getAccountNumber());
				transaction.setStatus("Rejected");
				transaction.setBalance(balance);
				transaction.setTransactionId(input.getTransactionId());
			}
			
			changeForWithdraw(transaction);
			
		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}
	}
	@Override
	public void requestForApproval(NonTransactionRequest input) throws UserException {
		insertNonTransactionRequest(input);
		
	}
	@Override
	public void updateTheRequest(NonTransactionRequest input) throws UserException{
		changeForNonTransactionRequest(input);
	}
	@Override
	public Map<Integer, NonTransactionRequest>  getAllAccountRequests() throws UserException {
		String sql="select * from TransactionRequest Where Status='Requested'";
		Connection inputConn =null;
		PreparedStatement myStatement = null;
		ResultSet resultSet=null;
		Map<Integer, NonTransactionRequest> transactionMap=null;
		try {
			inputConn = getConnection();
			myStatement = inputConn.prepareStatement(sql);
			resultSet=myStatement.executeQuery();
			transactionMap=convertToNonTransactionRequest(resultSet);

		}
		catch(SQLException sqlEx) {
			throw new UserException("You enter a wrong query",sqlEx);
		}

		finally {
			close(resultSet,myStatement,inputConn);

		}

		return transactionMap;
	}

}
