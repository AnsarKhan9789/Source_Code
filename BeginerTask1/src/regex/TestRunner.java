package regex;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.UserException;
import filesoperation.DateAndTimeOperation;

public class TestRunner {
	static Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);   

	static Scanner myObj = new Scanner(System.in);
	  public static String getUserInput() {
	        String userName = myObj.next();
	       
	        return userName;
	    }
	    public static char getUserInputChar() {
	        char character = myObj.next().charAt(0);
	        return character;
	    }
	    public static int getUserInputInt() {
	        while (!myObj.hasNextInt()) {
	             logger.info("Please enter in  integer format");
	           myObj.next();
	        }
	        int num =myObj.nextInt() ;
	        return num;

	    }

	
 public static void main(String args[])throws UserException {
	 RegexMethods regexObj=new RegexMethods();
	 boolean condition=true;
	 while(condition) {
		  logger.info("Enter your choice");
		 int choice=getUserInputInt();
		 logger.info("You enter a "+choice);
		 try {
			 switch(choice) {
			 case 1:
				  logger.info("Enter your phone number");
				 String mobile=getUserInput();
				 boolean isCorrect= regexObj.isValidMobile(mobile);
				 if(isCorrect) {
					 logger.info("The mobile number is correct ");  
				 }
				 else {
					  logger.info("The Mobile num is wrong");
					 
				 }
				 break;
			 case 2:
				  logger.info("Enter Alphanumeric ");
				 String Alpha=getUserInput();
				 boolean isCorrectAlpha= regexObj.isAlphaNumeric(Alpha);
				 if(isCorrectAlpha) {
					  logger.info("The String  is Alpha Numeric");
				 }
				 else {
					  logger.info("The String  is not Alpha Numeric");
				 }
				 break;
			 case 3:
				 String testString="Ansar khan";
				 String match="Ansar khan";
				 boolean s3=regexObj.isCorrectString(match, testString);
				  logger.info("The string is "+s3);
				 boolean s4=regexObj.isCorrectFullString(match,testString);
				  logger.info("The string is "+s4);
				 
				 
				 break;
				 
			 case 4:
				 String emailName="ansarkha@ngmail.com";
				 boolean isCorrectEmail=regexObj.isCorrectEmail(emailName);
				  logger.info("The email is "+isCorrectEmail);
				 break;
			 case 5:
				 String testString5="ansarkhanmohamme";
				 int range=9;
				 boolean isCorrectRange=regexObj.isCorrectRange(testString5,range);
				  logger.info("The name in corrrect range "+isCorrectRange);
				 break;
			 case 6:
				 String input="<htmL><p>ansar</p></html>";
				List list =regexObj.checkHTML(input);
				  logger.info("The name in corrrect range "+list);
					break;
			 case 7:
				 List<String> list7 =new ArrayList<String>();
				 list7.add("Ansar");
				 list7.add("khan");
				 list7.add("ansar");
				 list7.add("khan");
				 list7.add("ansaR");
				 String input7 ="ansar";
				Map m= regexObj.checkMatchingValues(input7, list7);
				System.out.println(m);
				break;
			 case 8:
				 List<String> list1 =new ArrayList<String>();
				 list1.add("Ansar");
				 list1.add("khan");
				 list1.add("Yaseer");
				 list1.add("moham");
				 list1.add("Shiekh");
				 List<String> list2 =new ArrayList<String>();
				 list2.add("Shiekh");
				 list2.add("moham");
				 Map m2=regexObj.checkMatchingList(list1, list2);
				 System.out.println(m2);
				 
			 } 
		 }
		catch(UserException ex){
			logger.warning(ex.getMessage());
		
			}
		}
	 

}
}
