package methods;

import java.util.List;
import java.util.Map;

import storagelayer.DatabaseMethods;
import storagelayer.StorageMethods;
import userexception.UserException;
import utilpackage.Util;

public class BankingForUser {
	public PersonPojo user = new PersonPojo();
	public StorageMethods storeMethodObj =new DatabaseMethods();


	// if the userId and password is correct it will return their pojo class if it fails it return empty strin
	// it will give -1 if the userid and account number is wrong;
	
	public long getBalance(int userId,long accountNumber) throws UserException {
		long balance =storeMethodObj.getBalance( accountNumber);
		if(balance==-1) {
			throw new UserException("Please enter the valid user Id");
		}
		return balance;
	}
	
	public void sendMoney(long accountNumber,long recieverAccoundNumber,int amount) throws UserException {
		if(recieverAccoundNumber==accountNumber) {
			throw new UserException("You should cant transfer in same accout");
		}
			try {
				long balance=storeMethodObj.getBalance(accountNumber);
				long recieverBalance =storeMethodObj.getBalance(recieverAccoundNumber); 
				if(recieverBalance==-1) {
					throw new UserException("The Receiver Account number does not exist");
				}
				if(balance==-1) {
					throw new UserException("Please enter valid user account number");
				}
				if(balance<amount) {
					throw new UserException("The balance is less than the Amount");
				}	
				storeMethodObj.sendTheMoney(accountNumber,recieverAccoundNumber,amount);
			}
			catch(UserException e) {
				throw new UserException("Please enter valid reciever account number");
			}
			
			
		
		
	}
	public Map<String, Map<Integer, Map<String, Object>>> viewFullStatement(long accountNumber) throws UserException {
		
		Map<String,Map<Integer,Map<String,Object>>> transaction=storeMethodObj.viewFullStatement(accountNumber);
		if(transaction==null) {
			throw new UserException("Please enter correct Account number");
		}
		return transaction;
	}
	
	public void changePassword(int userId,String newPassword) throws UserException {
		Util.isCorrectPassword(newPassword);
		 user.setPassword(newPassword);
		storeMethodObj.changePassword(userId, newPassword);
	}
	public void editUser(PersonPojo inputPerson,int choice) throws UserException {
		//1 for name 2 for mobile 3 for email 4 for name and mobile
		//5 for name and email 6 for mobile and email
		//7 for all the three
		
		Util.nullCheck(inputPerson);
		storeMethodObj.edit(inputPerson, choice);
			
	}
	
	
//need to change this
	public Map viewUserDetails(int userId) throws UserException {
		Map user =storeMethodObj.viewUserDetails(userId);
		return user;
	
	} 
	public List<Long> getAccountList(int userId) throws UserException {
		List<Long> accountList = storeMethodObj.getUserAccountList(userId);
		if(accountList==null) {
			throw new UserException("Please enter the correct Account Number");
			
		}
		return accountList;
	}
	public void deposit(int userId,long accountNumber,int amount) throws UserException {
		if(amount<0) {
			throw new UserException("Please enter the correct Account Number");
		}
		storeMethodObj.deposit(userId, accountNumber, amount);
	}
	public void withDraw(int userId,long accountNumber,int amount) throws UserException{
		long balance=storeMethodObj.getBalance(accountNumber);
		if(balance<amount) {
			throw new UserException("The balance is lesser than transaction amount");
		}
		if(amount<0) {
			throw new UserException("Please enter the correct Account Number");
		}
		storeMethodObj.withDraw(userId, accountNumber, amount);
	}
	public Map<Integer,TransactionPojo> getTransactionDetails(long accountNumber)throws UserException{
		Map<Integer,TransactionPojo> transactionMap =storeMethodObj.getTransactionDetails(accountNumber);
		if(transactionMap==null) {
			throw new UserException("Please enter correct Account Number");
		}
		return transactionMap;
	}
	public void requestForApproval(NonTransactionRequest input) throws UserException {
		Util.nullCheck(input);
		storeMethodObj.requestForApproval(input);
	}
}
