package utilpackage;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import userexception.UserException;

public class Util {
    public static void nullCheck(Object obj) throws UserException {
        if (Objects.isNull(obj)) {
            throw new UserException("Object should not be null");
        }

    }
    //swami ??????????????????
      public static void nullCheck(Object obj,Object obj1) throws UserException {
        if (Objects.isNull(obj)||Objects.isNull(obj1)) {
            throw new UserException("Object should not be null");
        }

    }
   
    public static boolean isValidMobile(long input) throws UserException {
    	nullCheck(input);
    	String input1=""+input+"";
    	Pattern patternforMobile= Pattern.compile("^[6-9][0-9]{9}");
    	Matcher matcherForMobile = patternforMobile.matcher(input1);
    	return matcherForMobile.find();
    	
    }
    public static boolean isValidName(String input) throws UserException {
    	nullCheck(input);
    	
    	Pattern patternforName= Pattern.compile("[a-zA-Z]+");
    	Matcher matcherForName= patternforName.matcher(input);
    	
    	return matcherForName.find();
    }
    public static boolean isCorrectEmail(String input) throws UserException {
    	nullCheck(input);
    	String match="^[a-z0-9]+@[a-z]+\\.[a-z]{2,6}$";
    	Pattern patternForEmail = Pattern.compile(match);
    	 Matcher matcherForEmail=patternForEmail.matcher(input);
    	 return matcherForEmail.find();
    }
    public static boolean isCorrectPassword(String input) throws UserException {
    	nullCheck(input);
    	String match="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
    	Pattern patternForPassword = Pattern.compile(match);
    	 Matcher matcherForPassword=patternForPassword.matcher(input);
    	
    	 return matcherForPassword.find();
    }
    
}
