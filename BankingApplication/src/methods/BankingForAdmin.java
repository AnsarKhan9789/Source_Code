package methods;

import java.util.Map;

import userexception.UserException;
import utilpackage.Util;

public class BankingForAdmin extends BankingForUser{

public Map<Integer,PersonPojo> getAllUserDetails() throws UserException {
	Map<Integer,PersonPojo> userMap =storeMethodObj.getAllUserDetails();
	return userMap;
	
}
public Map<Integer, Map<Long, AccountsPojo>> getAllAccountsDetails() throws UserException {
	Map<Integer, Map<Long, AccountsPojo>> accountMap =storeMethodObj.getAllAccountDetailsDetails();
	return accountMap;
	
}
public Map<Integer,TransactionPojo> getAllTransactionDetails() throws UserException {
	Map<Integer,TransactionPojo> transactionMap =storeMethodObj.getAllTransactionDetails();
	return transactionMap;
	
}

	
public Map<Integer, TransactionRequest>  getWithdrawlRequests()throws UserException{
	Map<Integer, TransactionRequest>  transactionMap =storeMethodObj.getWithdrawlRequests();
	return transactionMap;
}
public void updateTheTransactionRequest(TransactionRequest input) throws UserException
{
	storeMethodObj.updateTheTransactionRequest(input);

}
public void updateTheRequest(NonTransactionRequest input) throws UserException{
	Util.nullCheck(input);
	storeMethodObj.updateTheRequest(input);
}
	
	
//get account requestDetails
public Map<Integer, NonTransactionRequest>  getAccountRequests()throws UserException{
	Map<Integer, NonTransactionRequest>  transactionMap = null;
	return transactionMap;
}

}
