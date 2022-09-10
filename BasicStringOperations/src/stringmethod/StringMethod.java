package stringmethod;

import java.util.Objects;

public class StringMethod {

    private void nullCheck(Object obj) throws Exception {
        if (Objects.isNull(obj)) {
            throw new Exception("Object should not be null");
        }

    }
      private void nullCheck(Object obj,Object obj1) throws Exception {
        if (Objects.isNull(obj)||Objects.isNull(obj1)) {
            throw new Exception("Object should not be null");
        }

    }
    private void isCorrectValue(int subStringIndex,int length) throws Exception {
        if (subStringIndex < 0) {
            throw new Exception("Number value should not be negative");
        }
        
        else if(length < subStringIndex) {
            throw new Exception("The Index of sub string should not be exceed from the String");
        } 


    }
    private void isEmptyString(String inputNames) throws Exception {
        if ( Objects.isNull(inputNames) || inputNames.isEmpty()) {
            throw new Exception("InputNames should not be empty or null");
        }
    }
    public int getLength(String inputNames) throws Exception {

        nullCheck(inputNames);
        return inputNames.length();
        
    }

    public char[] convertToArray(String inputNames) throws Exception {
           nullCheck(inputNames);
        char[] charArray = inputNames.toCharArray();
        return charArray;
    }
    public int getTheOccurenceOfChar(String inputNames, char searchChar) throws Exception {

      
       
        char[] charArray = convertToArray(inputNames);
         int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (searchChar == charArray[i]) {
                count++;
            }
        }
        return count;

    }
    public int getThePositionOfChar(String inputNames, char searchChar) throws Exception {
        nullCheck(inputNames);
       return inputNames.lastIndexOf(searchChar);

    }
    public String getRequiredSubString(String inputNames, int subStringIndex) throws Exception {

        int stringLength = getLength(inputNames);
          isCorrectValue(subStringIndex,stringLength);
         int subStringStartPosition = stringLength - subStringIndex;
            return inputNames.substring(subStringStartPosition);
    }
    
    public char getLastChar(String inputNames) throws Exception {
        int lastCharIndex = getLength(inputNames) - 1;
      return inputNames.charAt(lastCharIndex);
    }
    
    public String getFirstRequiredChar(String inputNames, int subStringIndex) throws Exception {
        int length = getLength(inputNames);
        isCorrectValue(subStringIndex,length); 
         return inputNames.substring(0, subStringIndex);
    }
    
    public boolean isStartWithString(String inputNames, String start) throws Exception {
        nullCheck(inputNames);
      return inputNames.startsWith(start);
    }

    public String replaceReqValues(String inputNames, String alter, int num) throws Exception {

        String replaceName = getFirstRequiredChar(inputNames, num);
        return inputNames.replaceFirst(replaceName, alter);
    }
    public boolean isEndWithString(String inputNames, String end) throws Exception {
        nullCheck(inputNames);

        return inputNames.endsWith(end);

    }
    public String convertToUpper(String inputNames) throws Exception {
        nullCheck(inputNames);
       return inputNames.toUpperCase();

        
    }
    public String convertToLower(String inputNames) throws Exception {
        nullCheck(inputNames);
       return inputNames.toLowerCase();

        
    }
    public String reverseTheString(String inputNames) throws Exception {
        int length = getLength(inputNames);
        String reverse = "";
        char reverseChar;
        for (int i = 0; i < length; i++) {
            reverseChar = inputNames.charAt(i);
            reverse = reverseChar + reverse;
        }
        return reverse;

    }

    public String removeTheSpace(String inputNames) throws Exception {

        isEmptyString(inputNames);
        return inputNames.replace(" ", "");
       

    }
    public String[] convertToStrArray(String inputNames) throws Exception {

        isEmptyString(inputNames);
        String[] stringArray = inputNames.split(" ");
        return stringArray;
    }

    public String getStringFromArray(String[] inputNames, char mid) throws Exception {

        nullCheck(inputNames);
        String stringWithChar = "";
        int length = inputNames.length;
        for (int i = 0; i < length; i++) {
           
                stringWithChar = stringWithChar + inputNames[i] + mid;  
        }
        
        int stringLength=getLength(stringWithChar)-1;
        String stringPlusChar=stringWithChar.substring(0,stringLength);
        return stringPlusChar;

    }

    public boolean equalStrings(String inputNames1, String inputNames2) throws Exception {
        nullCheck(inputNames1,inputNames2);
        
       return inputNames1.equals(inputNames2);
        
    }
    public boolean isEqual(String inputNames1, String inputNames2) throws Exception {
       nullCheck(inputNames1,inputNames2);
      return inputNames1.equalsIgnoreCase(inputNames2);
      
    }

    public String getTheCorrectFormat(String inputNames) throws Exception {
        isEmptyString(inputNames);
        return inputNames.trim();
       
    }

}