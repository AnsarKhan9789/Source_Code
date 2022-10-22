package mainclass;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import methods.BankingForAdmin;
import methods.BankingForUser;
import methods.LoginPage;
import methods.PersonPojo;
import methods.TransactionPojo;
import methods.TransactionRequest;
import userexception.UserException;
import utilpackage.Util;

public class TesterForBanking {
	static Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	static Scanner myObj = new Scanner(System.in);
	static Scanner myObj2 = new Scanner(System.in);
	public static int count=0;


	private static String getUserInput() {
		String userName = myObj.next();
		return userName;
	}
	private static String getUserMultipleInput() {

		String userName = myObj2.nextLine();
		return userName;
	}
	private static int getUserInputInt() {
		while (!myObj.hasNextInt()) {
			logger.info("Please enter in integer format");
			myObj.next();
		}
		int num =myObj.nextInt() ;
		return num;

	}
	private static long getUserInputLong() {
		while (!myObj.hasNextLong()) {
			logger.info("Please enter in integer format");
			myObj.next();
		}
		long num =myObj.nextLong() ;
		return num;

	}
	private static char getUserInputChar() {
		char character = myObj.next().charAt(0);
		return character;
	}
	private static PersonPojo login() {

		LoginPage login =new LoginPage();
		boolean loginCondition=false;
		PersonPojo identity=null;
		do {
			try {
				logger.info("Enter User Id ");
				int useerId = getUserInputInt();
				logger.info("Enter Password ");
				String password=getUserInput();
				identity =login.getUserIdDetails(useerId, password);
			}
			catch(UserException e) {
				count++;

				if(count<3) {
					System.out.println(e.getMessage());
					identity=login();
				}
				else {
					count=0;
					System.out.println("Please Login later");
					loginCondition=false;

				}
			}
		}while(loginCondition==true);

		return identity;

	}
	private static long mainMenu(int userId,BankingForUser user) throws UserException {
		List<Long> accountList =user.getAccountList(userId);
		long accountNumber=0;
		for(int i=0;i<accountList.size();i++) {
			System.out.println(accountList.get(i));

		}
		System.out.println("Choose your account number ");
		int element = getUserInputInt(); 
		if(element>=0 && element <accountList.size()) {
			accountNumber = accountList.get(element-1);
			System.out.println("You choose this account number" + accountNumber);
		}
		return accountNumber;
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws UserException {




		boolean whileCondition=true;
		PersonPojo identity=login();


		if(identity!=null) {
			int userId=identity.getUserId();

			if(identity.getIdentityToVerify().equals("user")) {	

				BankingForUser user =new BankingForUser();
				long accountNumber=mainMenu(userId,user);
				System.out.println("1 for Balance Enquiry");
				System.out.println("2 for Withdraw");
				System.out.println("3 for deposit");
				System.out.println("4 for Password change");
				System.out.println("5 for Transaction");
				System.out.println("6 for Edit your details");
				System.out.println("7 for switch Account Number");
				System.out.println("Press other key to exit or 99");

				while(whileCondition) {
					System.out.println();
					System.out.println("Please Enter the num for your Preference");
					int Choice = getUserInputInt();
					switch(Choice) {
					case 1:
						long balance =user.getBalance(userId,accountNumber);
						System.out.println("Your balance is "+balance);
						break;
					case 2:

						System.out.println("Enter the amount for withdrawl");
						int amount = getUserInputInt();
						user.withDraw(userId, accountNumber, amount);
						System.out.println("Request sent Successfully");


						break;
					case 3:
						try {
							System.out.println("Enter the amount for deposit");
							int amount1 = getUserInputInt();
							user.deposit(userId, accountNumber, amount1);

						}
						catch(UserException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 4:
						try {
							System.out.println("Enter the old Password ");
							String oldPassword = getUserInput();
							while(!identity.getPassword().equals(oldPassword)) {
								System.out.println("Your old password is wrong");
								oldPassword = getUserInput();
							}
							System.out.println("Enter the new Password ");
							String password = getUserInput();
							user.changePassword(userId, password);
							System.out.println("Your password change successfullly");
							System.out.println("Please re login ");
							identity=login();

						}
						catch(UserException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 5:
						Map<Integer,TransactionPojo> transactionDetails=user.getTransactionDetails(accountNumber);
						System.out.println("Trans\tSender\t Reciever\tStatement\t\tAmount");
						System.out.println(transactionDetails);


						break;
					case 6:
						System.out.println("Please choose to edit");

						System.out.println("1 Name 2 Email 3 Mobile Number ");
						System.out.println("4 mobile and name 5  name and email 6 for mobile and email 7 for all");
						int choice =getUserInputInt();

						switch(choice) {
						case 1:
							System.out.println("Please enter your new  name");
							String name=getUserInput();
							boolean boolName=Util.isValidName(name);
							while(boolName==false) {
								System.out.println("Please enter name only in alpha");
								name=getUserInput();
							}
							identity.setName(name);
							user.editUser(identity, 1);
							break;
						case 2:
							System.out.println("Please enter your new Email");
							String email=getUserInput();
							boolean boolEmail=Util.isCorrectEmail(email);
							while(boolEmail==false) {
								System.out.println("Please enter xyz123@abc.com format");
								email=getUserInput();
							}
							identity.setEmailId(email);
							user.editUser(identity, 2);
							break;
						case 3:
							System.out.println("Please enter your new Mobile");
							long mobile=getUserInputLong();
							boolean boolNumber=Util.isValidMobile(mobile);
							while(boolNumber==false) {
								System.out.println("Please enter number start with 6-9 and contain only 10 digit");
								mobile=getUserInputLong();
							}
							identity.setMobileNumber(mobile);
							user.editUser(identity, 3);
							break;
						case 4:
							System.out.println("Please enter your new  name");
							String name1=getUserInput();
							boolean boolName1=Util.isValidName(name1);
							while(boolName1==false) {
								System.out.println("Please enter name only in alpha");
								name1=getUserInput();
							}
							identity.setName(name1);
							System.out.println("Please enter your new Mobile");
							long mobile1=getUserInputLong();
							boolean boolNumber1=Util.isValidMobile(mobile1);
							while(boolNumber1==false) {
								System.out.println("Please enter number start with 6-9 and contain only 10 digit");
								mobile1=getUserInputLong();
							}
							identity.setMobileNumber(mobile1);
							user.editUser(identity, 4);
							break;
						case 5:
							System.out.println("Please enter your new  name");
							String name2=getUserInput();
							boolean boolName2=Util.isValidName(name2);
							while(boolName2==false) {
								System.out.println("Please enter name only in alpha");
								name2=getUserInput();
							}
							identity.setName(name2);
							System.out.println("Please enter your new Email");
							String email1=getUserInput();
							boolean boolEmail1=Util.isCorrectEmail(email1);
							while(boolEmail1==false) {
								System.out.println("Please enter xyz123@abc.com format");
								email1=getUserInput();
							}
							identity.setEmailId(email1);
							user.editUser(identity, 5);
							break;
						case 6:
							System.out.println("Please enter your new Mobile");
							long mobile2=getUserInputLong();
							boolean boolNumber2=Util.isValidMobile(mobile2);
							while(boolNumber2==false) {
								System.out.println("Please enter number start with 6-9 and contain only 10 digit");
								mobile2=getUserInputLong();
							}
							identity.setMobileNumber(mobile2);
							System.out.println("Please enter your new Email");
							String email2=getUserInput();
							boolean boolEmail2=Util.isCorrectEmail(email2);
							while(boolEmail2==false) {
								System.out.println("Please enter xyz123@abc.com format");
								email2=getUserInput();
							}
							identity.setEmailId(email2);
							user.editUser(identity, 6);
							break;
						case 7:
							System.out.println("Please enter your new  name");
							String name3=getUserInput();
							boolean boolName3=Util.isValidName(name3);
							while(boolName3==false) {
								System.out.println("Please enter name only in alpha");
								name3=getUserInput();
							}
							identity.setName(name3);
							System.out.println("Please enter your new Mobile");
							long mobile3=getUserInputLong();
							boolean boolNumber3=Util.isValidMobile(mobile3);
							while(boolNumber3==false) {
								System.out.println("Please enter number start with 6-9 and contain only 10 digit");
								mobile3=getUserInputLong();
							}
							identity.setMobileNumber(mobile3);
							System.out.println("Please enter your new Email");
							String email3=getUserInput();
							boolean boolEmail3=Util.isCorrectEmail(email3);
							while(boolEmail3==false) {
								System.out.println("Please enter xyz123@abc.com format");
								email3=getUserInput();
							}
							identity.setEmailId(email3);
							user.editUser(identity, 7);
							break;


						default:
							System.out.println("Please enter Valid buttons");
							break;

						}
						System.out.println("Edit completed");
						break;
					case 7:
						accountNumber=mainMenu(userId,user);
						break;
					case 8:
						whileCondition=false;
						System.out.println("Application closed");
						break;
					default:

						whileCondition=false;
						System.out.println("Please enter the valid number");
						break;
					}
				}


			}
			// put method to print map
			//check admin
			else {
				int adminUserId=identity.getUserId();
				long adminAccountNumber=0;
				BankingForAdmin admin= new BankingForAdmin();

				System.out.println("1 view all user details");
				System.out.println("2 view all Accounts");
				System.out.println(" 3 view all Transaction");
				System.out.println(" 4 view  withdrawl request");
				System.out.println(" 5 view user details ");
				System.out.println(" 6 view Account details ");
				System.out.println(" 7 My  details ");

				System.out.println("Press other key to exit or 99");
				while(whileCondition) {
					System.out.println();
					System.out.println("Please Enter the num for your Preference");
					int Choice = getUserInputInt();
					switch(Choice) {
					case 1:
						Map userMap = admin.getAllUserDetails();
						System.out.println(userMap);
						break;
					case 2:
						Map accountMap=admin.getAllAccountsDetails();
						System.out.println(accountMap);
						break;
					case 3:
						Map<Integer,TransactionPojo> transactionMap=admin.getAllTransactionDetails();
						for (Map.Entry<Integer,TransactionPojo>entry : transactionMap.entrySet()) {
							TransactionPojo tr =entry.getValue();

							System.out.print("Key = " + entry.getKey() );
							System.out.print("\t"+tr.getPrimaryAccount());     
							System.out.print("\t"+tr.getStatus()); 
							System.out.print("\t"+tr.getTransactionId()); 
							System.out.print("\t"+tr.getBalance()); 
							System.out.print("\t"+tr.getSecondaryAccount()); 
							System.out.println();
						}
						break;
					case 4:{
						Map<Integer, TransactionRequest> transactionMapForRequest=admin.getWithdrawlRequests();
						for (Map.Entry<Integer, TransactionRequest> entry : transactionMapForRequest.entrySet()) {
							TransactionRequest tr =entry.getValue();

							System.out.print("Key = " + entry.getKey() );
							System.out.print("\t"+tr.getAccountNumber());     
							System.out.print("\t"+tr.getStatus()); 
							System.out.print("\t"+tr.getTransactionId()); 
							System.out.print("\t"+tr.getAmount()); 
							System.out.println();
						}
						System.out.println("Enter the id to select");
						int selectId=getUserInputInt();
						TransactionRequest tr= transactionMapForRequest.get(selectId);
						System.out.println("1 for accept 2 for Reject");
						int choiceForUpdate=getUserInputInt();
						if(choiceForUpdate==1) {
							tr.setStatus("Success");
							admin.updateTheTransactionRequest(tr);
						}
						else {
							tr.setStatus("Rejected");
							admin.updateTheTransactionRequest(tr);
						}
						System.out.println("Successfully changed status");


					}
					break;
					case 5:{
						System.out.println("Please enter whose User Id to check");
						int usersUserId=getUserInputInt();
						Map<Integer, PersonPojo> reqUser=null;
						try {
							reqUser=admin.viewUserDetails(usersUserId);
						}
						catch(UserException e) {
							System.out.println(e.getMessage());
						}



					}
					break;
					case 55:{
						System.out.println("2 for  my Password change");

						//please fetch old password and check with it
						System.out.println("Please enter your old Password");
						String oldPassword=getUserInput();
						while(identity.getPassword().equals(oldPassword)) {
							System.out.println("Your old password is eqaul to old pass word");
							oldPassword=getUserInput();
						}
						System.out.println("Please enter your old Password");
						String newPassword=getUserInput();
						boolean isCheck=Util.isCorrectPassword(newPassword);
						while(isCheck==false) {
							System.out.println("Your password is too weak please enter strong");
							newPassword=getUserInput();
						}
						admin.changePassword(adminUserId, newPassword);
						System.out.println("Password change successfully");
						whileCondition=false;
						identity=login();						
					}
					break;
					case 66:{
						System.out.println("1 Name 2 Email 3 Mobile Number ");
						System.out.println("4 mobile and name 5  name and email 6 for mobile and email 7 for all");
						int choice =getUserInputInt();

						switch(choice) {
						case 1:
							System.out.println("Please enter your new  name");
							String name=getUserInput();
							boolean boolName=Util.isValidName(name);
							while(boolName==false) {
								System.out.println("Please enter name only in alpha");
								name=getUserInput();
							}
							identity.setName(name);
							admin.editUser(identity, 1);
							break;
						case 2:
							System.out.println("Please enter your new Email");
							String email=getUserInput();
							boolean boolEmail=Util.isCorrectEmail(email);
							while(boolEmail==false) {
								System.out.println("Please enter xyz123@abc.com format");
								email=getUserInput();
							}
							identity.setEmailId(email);
							admin.editUser(identity, 2);
							break;
						case 3:
							System.out.println("Please enter your new Mobile");
							long mobile=getUserInputLong();
							boolean boolNumber=Util.isValidMobile(mobile);
							while(boolNumber==false) {
								System.out.println("Please enter number start with 6-9 and contain only 10 digit");
								mobile=getUserInputLong();
							}
							identity.setMobileNumber(mobile);
							admin.editUser(identity, 3);
							break;
						case 4:
							System.out.println("Please enter your new  name");
							String name1=getUserInput();
							boolean boolName1=Util.isValidName(name1);
							while(boolName1==false) {
								System.out.println("Please enter name only in alpha");
								name1=getUserInput();
							}
							identity.setName(name1);
							System.out.println("Please enter your new Mobile");
							long mobile1=getUserInputLong();
							boolean boolNumber1=Util.isValidMobile(mobile1);
							while(boolNumber1==false) {
								System.out.println("Please enter number start with 6-9 and contain only 10 digit");
								mobile1=getUserInputLong();
							}
							identity.setMobileNumber(mobile1);
							admin.editUser(identity, 4);
							break;
						case 5:
							System.out.println("Please enter your new  name");
							String name2=getUserInput();
							boolean boolName2=Util.isValidName(name2);
							while(boolName2==false) {
								System.out.println("Please enter name only in alpha");
								name2=getUserInput();
							}
							identity.setName(name2);
							System.out.println("Please enter your new Email");
							String email1=getUserInput();
							boolean boolEmail1=Util.isCorrectEmail(email1);
							while(boolEmail1==false) {
								System.out.println("Please enter xyz123@abc.com format");
								email1=getUserInput();
							}
							identity.setEmailId(email1);
							admin.editUser(identity, 5);
							break;
						case 6:
							System.out.println("Please enter your new Mobile");
							long mobile2=getUserInputLong();
							boolean boolNumber2=Util.isValidMobile(mobile2);
							while(boolNumber2==false) {
								System.out.println("Please enter number start with 6-9 and contain only 10 digit");
								mobile2=getUserInputLong();
							}
							identity.setMobileNumber(mobile2);
							System.out.println("Please enter your new Email");
							String email2=getUserInput();
							boolean boolEmail2=Util.isCorrectEmail(email2);
							while(boolEmail2==false) {
								System.out.println("Please enter xyz123@abc.com format");
								email2=getUserInput();
							}
							identity.setEmailId(email2);
							admin.editUser(identity, 6);
							break;
						case 7:
							System.out.println("Please enter your new  name");
							String name3=getUserInput();
							boolean boolName3=Util.isValidName(name3);
							while(boolName3==false) {
								System.out.println("Please enter name only in alpha");
								name3=getUserInput();
							}
							identity.setName(name3);
							System.out.println("Please enter your new Mobile");
							long mobile3=getUserInputLong();
							boolean boolNumber3=Util.isValidMobile(mobile3);
							while(boolNumber3==false) {
								System.out.println("Please enter number start with 6-9 and contain only 10 digit");
								mobile3=getUserInputLong();
							}
							identity.setMobileNumber(mobile3);
							System.out.println("Please enter your new Email");
							String email3=getUserInput();
							boolean boolEmail3=Util.isCorrectEmail(email3);
							while(boolEmail3==false) {
								System.out.println("Please enter xyz123@abc.com format");
								email3=getUserInput();
							}
							identity.setEmailId(email3);
							admin.editUser(identity, 7);
							break;


						default:
							System.out.println("Please enter Valid buttons");
							break;

						}

					}
					System.out.println("Edit completed successfully");
						break;

					}
				}

			}

		}





	}
}
