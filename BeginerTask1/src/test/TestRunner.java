package test;

import stringmethod.StringMethod;

import java.util.Scanner;
public class TestRunner {
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
            System.out.println("Please enter in  integer format");
           myObj.next();
        }
        int num =myObj.nextInt() ;
        return num;

    }
    public static String getMultipleString(){
    myObj.nextLine();
    
      String userName = myObj.nextLine();
        return userName;
    }
    
    public static void main(String[] args) throws Exception {

       

        StringMethod stringObj = new StringMethod();

        char choiceForloop = '\0';

        do {
            int choices = 0;
            System.out.println("Enter the method number");


            choices = getUserInputInt();
            switch (choices) {

                case 0:

                    if (args.length != 0) {
                        try {
                         String varArgs = args[0];

                            int length = stringObj.getLength(varArgs);
                            System.out.println("The length of the string " + length);
                        } catch (Exception ex) {
                            System.out.println("Caught the exception");

                           
                            System.out.println("Exception occured: " + ex);


                        }


                    } else {
                        System.out.println("No string is present ");
                    }
                    break;

                case 1:
                    System.out.println("Enter the name");

                    String userName = getUserInput();

                   

                    try {

                        int length = stringObj.getLength(userName);
                        System.out.println("The length of the string " + length);
                    } catch (Exception ex) {
                        System.out.println("Caught the exception");

                       
                        System.out.println("Exception occured: " + ex);
                    }

                    break;
                case 2:
                    System.out.println("Enter the name");
                    String userName1 = getUserInput();
                    try{
                       char[] arr = stringObj.convertToArray(userName1);
                    System.out.println("The char array is");
                    for (int i = 0; i < arr.length; i++) {
                        System.out.println(arr[i]);
                    }
                    }
                    catch (Exception ex) {
                        System.out.println("Caught the exception");

                       
                        System.out.println("Exception occured: " + ex);
                    }
                    
                 
                    break;
                case 3:
                    System.out.println("Enter the name ");
                    String userName2 = getUserInput();

                    System.out.println("Enter character to get the occurence in your string");

                    char ch = getUserInputChar();
                    try{
                       int total = stringObj.getTheOccurenceOfChar(userName2, ch);
                    if (total == 0) {
                        System.out.println("There is no occurence of the " + ch);
                    } else {
                        System.out.println("The occurence of the " + ch + " is in the " + total);
                    }

                    }
                       catch (Exception ex) {
                        System.out.println("Caught the exception");

                       
                        System.out.println("Exception occured: " + ex);
                    }
                 

                    break;
                case 4:
                    System.out.println("Enter the name");
                    String userName3 = getUserInput();
                    System.out.println("Enter character to get the greatest position in your string");

                    char ch1 = getUserInputChar();
                    try{
                    int index = stringObj.getThePositionOfChar(userName3, ch1);
                    if (index == -1) {
                        System.out.println("There is no occurence of the " + ch1);
                    }
                    else{
                    
                    System.out.println("The greatest position of the " + ch1 + " is in the " + index);
                    }
                    }
                       catch (Exception ex) {
                        System.out.println("Caught the exception");

                       
                        System.out.println("Exception occured: " + ex);
                    }
                    
                    break;
                case 5:
                    System.out.println("Enter the name");
                    String userName4 = getUserInput();
                    System.out.println("Enter how many last char you need");
                    int lasts = getUserInputInt();
                    try {

                        String alterString = stringObj.getRequiredSubString(userName4, lasts);
                        System.out.println("Your new string is  " + alterString);
                    } catch (Exception ex) {

                       ex.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Enter username");
                    String userName5 = getUserInput();
                    System.out.println("Enter how many first char you need");
                    int firsts = getUserInputInt();

                    try {

                        String matter = stringObj.getFirstRequiredChar(userName5, firsts);

                        System.out.println("The first three character are " + matter);

                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());

                    }

                    break;
                case 7:
                    System.out.println("Enter username");
                    String userName6 = getUserInput();
                    try{
                    char lastChar = stringObj.getLastChar(userName6);
                    System.out.println("The last  character is " + lastChar);
                    }
                    catch (Exception ex) {
                        System.out.println(ex.getMessage());

                    }
                    
                    break;
                case 8:
                    System.out.println("Enter the name");
                    String userName7 = getUserInput();
                    System.out.println("Enter the value to replace");
                    String alterVal = getUserInput();
                    System.out.println("Enter how many  char in the string to be replace");
                    int reqString = getUserInputInt();
                    try {

                        String finalVar = stringObj.replaceReqValues(userName7, alterVal, reqString);
                        System.out.println("After replace  character is " + finalVar);
                    } catch (Exception ex) {
                        System.out.println("Exception occured: " + ex);
                    }

                    break;
                case 9:
                    System.out.println("Enter username");
                    String userName8 = getUserInput();
                    System.out.println("Enter String to check");
                    String startVariable = getUserInput();
                    try{
                      boolean flag = stringObj.isStartWithString(userName8, startVariable);
                    if (flag == true) {
                        System.out.println("It start with " + startVariable);
                    } else {
                        System.out.println("No, It not start with " + startVariable);
                    }
                    }
                     catch (Exception ex) {
                        System.out.println("Exception occured: " + ex);
                    }
                  
                    break;
                case 10:
                    System.out.println("Enter username");
                    String userName9 = getUserInput();
                    System.out.println("Enter String to check");
                    String endVariable = getUserInput();
                    try{
                      boolean flag1 = stringObj.isEndWithString(userName9, endVariable);
                    if (flag1 == true) {
                        System.out.println("It end with " + endVariable);
                    } else {
                        System.out.println("No, It not end with " + endVariable);
                    }
                    }
                    catch (Exception ex) {
                        System.out.println("Exception occured: " + ex);
                    }
                  
                    break;
                case 11:
                    System.out.println("Enter username");
                    String userName19 = getUserInput();
                    try{
                     String upperVar = stringObj.convertToUpper(userName19);
                    System.out.println("The upper case is " + upperVar);
                    }
                     catch (Exception ex) {
                        System.out.println("Exception occured: " + ex);
                    }
                   
                    break;
                case 12:
                    System.out.println("Enter username");
                    String userName10 = getUserInput();
                    try{
                     String lowerVar = stringObj.convertToLower(userName10);
                    System.out.println("The lower case is " + lowerVar);
                    }
                    catch (Exception ex) {
                        System.out.println("Exception occured: " + ex);
                    }
                   

                    break;
                case 13:
                    System.out.println("Enter username");
                    String userName11 = getUserInput();
                    try{
                     String nstr = stringObj.reverseTheString(userName11);
                    System.out.println("The reverse string will be " + nstr);
                    }
                    catch (Exception ex) {
                        System.out.println("Exception occured: " + ex);
                    }
                   
                    break;
                case 14:

                    System.out.println("Enter multiple string");
                    String multiString = getMultipleString();
                    //convert a multiple string without space
                    try{
                    String noSpace = stringObj.removeTheSpace(multiString);
                    System.out.println("After the removal of space " + noSpace);
                    }
                       catch (Exception ex) {
                        System.out.println("Exception occured: " + ex);
                    }
                    
                    break;
                case 15:
                    //Convert a string to array
                    System.out.println("Enter multiple string");
                    String multiString1 = getMultipleString();
                    try{
                      String[] strArr = stringObj.convertToStrArray(multiString1);
                    for (int i = 0; i < strArr.length; i++) {
                        System.out.println(strArr[i]);
                    }
                    }
                       catch (Exception ex) {
                        System.out.println("Exception occured: " + ex);
                    }
                  
                    break;
                case 16:
                    //Multiple string with -
                    System.out.println("Enter How many strings you want");
                    int length1 = getUserInputInt();
                    String[] stringValue = new String[length1];
                    for (int i = 0; i < length1; i++) {
                        System.out.println("Enter the string");
                        String strings = getUserInput();
                        stringValue[i] = strings;
                    }
                    System.out.println("Enter What the character should be in the middle");
                    char middle = getUserInputChar();
                    try{
                     String dashedString = stringObj.getStringFromArray(stringValue, middle);
                    System.out.println(dashedString);
                    }
                      catch (Exception ex) {
                        System.out.println("Exception occured: " + ex);
                    }
                   

                    break;
                case 17:
                    //Equal method
                    System.out.println("Enter Two string");


                    String firstString = getUserInput();

                    String secondString = getUserInput();
                    try{
                      boolean flag3 = stringObj.equalStrings(firstString, secondString);
                    if (flag3 == true) {
                        System.out.println("It equal ");
                    } else {
                        System.out.println("No, It not end equal ");
                    }
                    }
                      catch (Exception ex) {
                        System.out.println("Exception occured: " + ex);
                    }
                  

                    break;
                case 18:
                    System.out.println("Enter The String start with and end with space");
                    String stringWithSpace = getMultipleString();
                    try{
                     String newStr = stringObj.getTheCorrectFormat(stringWithSpace);
                    System.out.println("The correct format is " + newStr);
                    }
                     catch (Exception ex) {
                        System.out.println("Exception occured: " + ex);
                    }
                   
                    break;
                case 19:
                    System.out.println("Enter Two string");

                    myObj.nextLine();
                    String firstString1 = getUserInput();

                    String secondString1 = getUserInput();
                    try{
                     boolean flag4 = stringObj.isEqual(firstString1,secondString1);
                    if (flag4 == true) {
                        System.out.println("It equal ");
                    } else {
                        System.out.println("No, It not end equal ");
                    }
                    }
                    catch (Exception ex) {
                        System.out.println("Exception occured: " + ex);
                    }
                   
			break;
		default:
			 System.out.println("Do you want to exit");
			 System.out.println("Enter y to exit");
			    choiceForloop = getUserInputChar();
		
			  

            }

  		



        } while (choiceForloop != 'y');

    }
}