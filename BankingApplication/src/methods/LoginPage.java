package methods;

import storagelayer.DatabaseMethods;
import storagelayer.StorageMethods;
import userexception.UserException;

public class LoginPage {
	public PersonPojo getUserIdDetails(int inputUserId,String password) throws UserException {
		StorageMethods storeMethodObj =new DatabaseMethods();
		PersonPojo verifyForUser=storeMethodObj.getUserIdDetails(inputUserId,password);
		if(verifyForUser==null) {
			throw new UserException("Enter the correct UserId");
		}
		return verifyForUser;
	}
}
