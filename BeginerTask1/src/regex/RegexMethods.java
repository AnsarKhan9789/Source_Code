package regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exception.UserException;
import testerror.TestError;

public class RegexMethods {
	
public boolean isValidMobile(String input) throws UserException {
	TestError.nullCheck(input);
	Pattern patternforMobile= Pattern.compile("^[7-9][0-9]{9}");
	Matcher matcherForMobile = patternforMobile.matcher(input);
	return matcherForMobile.find();
}
public boolean isAlphaNumeric(String input) throws UserException {
	TestError.nullCheck(input);
	//Pattern patternForAlpha = Pattern.compile("^[a-zA-Z0-9]*$");
	Pattern patternForAlpha = Pattern.compile("\\w");
	 Matcher matcherForAlpha=patternForAlpha.matcher(input);
	return matcherForAlpha.find();
}
//Checks for the string end with matching string
public boolean isCorrectString(String input,String match) throws UserException {
	TestError.nullCheck(input);
	TestError.nullCheck(match);
	String match1=input+"$";
	Pattern patternForAlpha = Pattern.compile(match1);
	 Matcher matcherForAlpha=patternForAlpha.matcher(match);
	return matcherForAlpha.find();
}
//Checks for the string start with matching string
public boolean isCorrectFirstString(String input,String match) throws UserException {
	TestError.nullCheck(input);
	TestError.nullCheck(match);
	String match1="^"+input;
	Pattern patternForAlpha = Pattern.compile(match1);
	 Matcher matcherForAlpha=patternForAlpha.matcher(match);
	return matcherForAlpha.find();
}
//Checks for the string contains in matching string
public boolean isContainsString(String input,String match) throws UserException {
	TestError.nullCheck(input);
	TestError.nullCheck(match);
	StringBuilder stringForMatcher=new StringBuilder();
	stringForMatcher.append("\\b");
	stringForMatcher.append(input);
	stringForMatcher.append("\\b");
	String match1=stringForMatcher.toString();
	Pattern patternForAlpha = Pattern.compile(match1);
	 Matcher matcherForAlpha=patternForAlpha.matcher(match);
	return matcherForAlpha.find();
}
//Checks for the string is completely correct in matching string
public boolean isCorrectFullString(String input,String match) throws UserException {
	TestError.nullCheck(input);
	TestError.nullCheck(match);
	Pattern patternForAlpha = Pattern.compile(input);
	 Matcher matcherForAlpha=patternForAlpha.matcher(match);
	return matcherForAlpha.find();
}
public boolean isCorrectEmail(String input) throws UserException {
	TestError.nullCheck(input);
	String match="^[a-z0-9]+@[a-z]+\\.[a-z]{2,6}$";
	Pattern patternForEmail = Pattern.compile(match);
	 Matcher matcherForEmail=patternForEmail.matcher(input);
	return matcherForEmail.find();
}
public boolean isCorrectRange(String input,int range) throws UserException {
	TestError.nullCheck(input);
	String match="^[a-zA-Z]{2,"+range+"}$";
	Pattern patternForRange = Pattern.compile(match);
	 Matcher matcherForRange=patternForRange.matcher(input);
	return matcherForRange.find();
}
public Map<Integer,String> checkMatchingValues(String input,List<String> inputList) throws UserException {
	TestError.nullCheck(input);
	TestError.nullCheck(inputList);
	
	Pattern patrn = Pattern.compile(input, Pattern.CASE_INSENSITIVE);
	  Map<Integer,String> map=new HashMap<Integer,String>();  
	for(int i=0;i<inputList.size();i++) {
		String input1=inputList.get(i);
		Matcher match1=patrn.matcher(input1);
		if(match1.find()==true) {
			map.put(i, input1);
		}
		
	}
	return map;


    
}
// inputList is the first list and checkList is the list which will contain the values of checklist
public Map<Integer,String> checkMatchingList(List<String> inputList,List<String> toCheckList) throws UserException {
	TestError.nullCheck(inputList);
	TestError.nullCheck(toCheckList);
	 Map<Integer,String> map=new HashMap<Integer,String>();  
	for(int i=0;i<toCheckList.size();i++) {
			for(int j=0;j<inputList.size();j++) {
				Pattern patrn = Pattern.compile(toCheckList.get(i));
				String input1=inputList.get(j);
				Matcher match1=patrn.matcher(input1);
				if(match1.find()==true) {
					map.put(j, input1);
				}	
	}
	}
	return map;
}
public List checkHTML(String input) throws UserException {
	TestError.nullCheck(input);
	String regex = "</*[a-zA-z]*>";
		Pattern patternForHTML = Pattern.compile(regex);
		 Matcher matcherForHTML=patternForHTML.matcher(input);
		 List list = new ArrayList();
		while( matcherForHTML.find()) {
			list.add(matcherForHTML.group());
			 
		}
		return list;
}
        
}
