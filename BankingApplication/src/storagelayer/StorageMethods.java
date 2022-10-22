package storagelayer;


import java.util.List;
import java.util.Map;

import methods.AccountsPojo;
import methods.NonTransactionRequest;
import methods.PersonPojo;
import methods.TransactionPojo;
import methods.TransactionRequest;
import userexception.UserException;

public interface StorageMethods {
	PersonPojo getUserIdDetails(int userId,String password) throws UserException;
	Map<Integer,PersonPojo> viewUserDetails(int... userId)throws UserException;
	Map<Integer,Map<Long,AccountsPojo>>  viewAccountDetails(int userId)throws UserException;
	void deposit(int userId,long accountNumber,int amount)throws UserException;
	void withDraw(int userId,long accountNumber,int amount)throws UserException;
	Map<Integer,TransactionPojo> getTransactionDetails(long accountNumber)throws UserException;
	Map viewFullStatement(long accountNumber)throws UserException;
	void changePassword(int userId,String inputPassword) throws UserException;
	void sendTheMoney(long senderAccountNumber,long recieverAccountNumber,int amount) throws UserException;
	void edit(PersonPojo inputPerson,int choice) throws UserException;	  
	List<Long> getUserAccountList(int userId)throws UserException;	
	//admin
	Map<Integer,TransactionPojo> getAllTransactionDetails()throws UserException;
	Map<Integer,Map<Long,AccountsPojo>> getAllAccountDetailsDetails()throws UserException;
	Map<Integer,PersonPojo> getAllUserDetails()throws UserException;
	long getBalance(long accountNumber)throws UserException;
	Map<Integer, TransactionRequest>  getWithdrawlRequests()throws UserException;
	void updateTheTransactionRequest(TransactionRequest input) throws UserException;
	void requestForApproval(NonTransactionRequest input) throws UserException;
	void updateTheRequest(NonTransactionRequest input) throws UserException;
	Map<Integer, NonTransactionRequest>  getAllAccountRequests() throws UserException ;
}
