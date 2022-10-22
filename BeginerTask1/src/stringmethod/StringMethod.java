package stringmethod;

import java.util.Objects;

import exception.UserException;

public class StringMethod {

    private void nullCheck(Object obj) throws UserException {
        if (Objects.isNull(obj)) {
            throw new UserException("Object should not be null");
        }

    }
      private void nullCheck(Object obj,Object obj1) throws UserException {
        if (Objects.isNull(obj)||Objects.isNull(obj1)) {
            throw new UserException("Object should not be null");
        }

    }
    private void isCorrectValue(int subStringIndex,int length) throws UserException {
        if (subStringIndex < 0) {
            throw new UserException("Number value should not be negative");
        }
        
        else if(length < subStringIndex) {
            throw new UserException("The Index of sub string should not be exceed from the String");
        } 


    }
    private void isEmptyString(String inputNames) throws UserException {
        if ( Objects.isNull(inputNames) || inputNames.isEmpty()) {
            throw new UserException("InputNames should not be empty or null");
        }
    }
    public int getLength(String inputNames) throws UserException {

       nullCheck(inputNames);
        return inputNames.length();
        
    }

    public char[] convertToArray(String inputNames) throws UserException {
           nullCheck(inputNames);
        char[] charArray = inputNames.toCharArray();
        return charArray;
    }
    public int getTheOccurenceOfChar(String inputNames, char searchChar) throws UserException {

      
       
        char[] charArray = convertToArray(inputNames);
         int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (searchChar == charArray[i]) {
                count++;
            }
        }
        return count;

    }
    public int getThePositionOfChar(String inputNames, char searchChar) throws UserException {
        nullCheck(inputNames);
       return inputNames.lastIndexOf(searchChar);

    }
    public String getRequiredSubString(String inputNames, int subStringIndex) throws UserException {

        int stringLength = getLength(inputNames);
          isCorrectValue(subStringIndex,stringLength);
         int subStringStartPosition = stringLength - subStringIndex;
            return inputNames.substring(subStringStartPosition);
    }
    
    public char getLastChar(String inputNames) throws UserException {
        int lastCharIndex = getLength(inputNames) - 1;
      return inputNames.charAt(lastCharIndex);
    }
    
    public String getFirstRequiredChar(String inputNames, int subStringIndex) throws UserException {
        int length = getLength(inputNames);
        isCorrectValue(subStringIndex,length); 
         return inputNames.substring(0, subStringIndex);
    }
    
    public boolean isStartWithString(String inputNames, String start) throws UserException {
        nullCheck(inputNames);
      return inputNames.startsWith(start);
    }

    public String replaceReqValues(String inputNames, String alter, int num) throws UserException {

        String replaceName = getFirstRequiredChar(inputNames, num);
        return inputNames.replaceFirst(replaceName, alter);
    }
    public boolean isEndWithString(String inputNames, String end) throws UserException {
        nullCheck(inputNames);

        return inputNames.endsWith(end);

    }
    public String convertToUpper(String inputNames) throws UserException {
        nullCheck(inputNames);
       return inputNames.toUpperCase();

        
    }
    public String convertToLower(String inputNames) throws UserException {
        nullCheck(inputNames);
       return inputNames.toLowerCase();

        
    }
    public String reverseTheString(String inputNames) throws UserException {
        int length = getLength(inputNames);
        String reverse = "";
        char reverseChar;
        for (int i = 0; i < length; i++) {
            reverseChar = inputNames.charAt(i);
            reverse = reverseChar + reverse;
        }
        return reverse;

    }

    public String removeTheSpace(String inputNames) throws UserException {

        isEmptyString(inputNames);
        return inputNames.replace(" ", "");
       

    }
    public String[] convertToStrArray(String inputNames) throws UserException {

        isEmptyString(inputNames);
        String[] stringArray = inputNames.split(" ");
        return stringArray;
    }

    public String getStringFromArray(String[] inputNames, char mid) throws UserException {

        nullCheck(inputNames);
        String middle=String.valueOf(mid);
      
        String stringWithChar = String.join(middle, inputNames);
        
        return stringWithChar;

    }

    public boolean equalStrings(String inputNames1, String inputNames2) throws UserException {
        nullCheck(inputNames1,inputNames2);
        
       return inputNames1.equals(inputNames2);
        
    }
    public boolean isEqual(String inputNames1, String inputNames2) throws UserException {
      nullCheck(inputNames1,inputNames2);
      return inputNames1.equalsIgnoreCase(inputNames2);
      
    }

    public String getTheCorrectFormat(String inputNames) throws UserException {
        isEmptyString(inputNames);
        return inputNames.trim();
       
    }

}