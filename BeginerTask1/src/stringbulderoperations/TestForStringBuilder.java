package stringbulderoperations;
import java.util.*;

import exception.UserException;

import java.lang.*;

public class TestForStringBuilder {
	static Scanner myObj = new Scanner(System.in);

	public static String getUserInput() {
		String userName = myObj.next();
		return userName;
	}
	public static int getUserInputInt() {
		while (!myObj.hasNextInt()) {
			System.out.println("Please enter in  integer format");
			myObj.next();
		}
		int num =myObj.nextInt() ;
		return num;

	}
	public static char getUserInputChar() {
		char character = myObj.next().charAt(0);
		return character;
	}
	public static String[] getMultipleDaata() {
		System.out.println("How many string you need ");
		int count1 = getUserInputInt();
		String[] stringArray1=new String[count1];
		for (int i = 0; i < count1; i++) {
			System.out.println("Enter the string");
			String strings = getUserInput();
			stringArray1[i] = strings;
		}
		return stringArray1;
	}
	public static void printTheStringBuilder(StringBuilder inputName) throws UserException {
		StringBuilderMethods stringObject1=new StringBuilderMethods();
		try {
			int length= stringObject1.getLength(inputName);
			System.out.println("The Original string is  "+inputName);
			System.out.println("The Length before adding is "+length);
		}
		catch (Exception ex) {
			System.out.println("Caught the exception");


			System.out.println("Exception occured: " + ex);


		}

	}

	public static void main(String[] args) throws UserException {
		StringBuilderMethods stringObject=new StringBuilderMethods();
		String space=" ";
		char space1 =' ';
		boolean flag=true;
		while(flag==true) {
			int choices = 0;
			System.out.println("Enter the method number");


			choices = getUserInputInt();
			try {
				switch(choices) {

				case 1:
					StringBuilder stringBuilderObj = stringObject.getStringBuilder();
					int length= stringObject.getLength(stringBuilderObj);
					System.out.println("The Length before adding is "+length);
					System.out.println("Enter the name");

					String userName = getUserInput();
					stringBuilderObj=stringObject.appends(stringBuilderObj, userName);
					int length1= stringObject.getLength(stringBuilderObj);
					printTheStringBuilder(stringBuilderObj);
					break;


				case 2:
					StringBuilder stringBuilderObj1 = stringObject.getStringBuilder();
					int length2= stringObject.getLength(stringBuilderObj1);
					System.out.println("The Length before adding is "+length2);

					String[] stringArray=getMultipleDaata();

					System.out.println("Enter What the character should be in the middle");
					String middle = getUserInput();
					stringBuilderObj1= stringObject.appendsChar( stringBuilderObj1, middle,stringArray);
					printTheStringBuilder(stringBuilderObj1);
					break;

				case 3:

					StringBuilder stringbuild3 = stringObject.getStringBuilder(); 


					String[] stringArray1=getMultipleDaata();
					stringbuild3=stringObject.appendsChar(stringbuild3,space,stringArray1);
					printTheStringBuilder(stringbuild3);
					System.out.println("Enter the string to add");

					String userName3 = getUserInput();
					stringbuild3=stringObject.insert(stringbuild3, space,userName3);
					printTheStringBuilder(stringbuild3);
					break;
				case 4:

					StringBuilder stringBuild = stringObject.getStringBuilder(); 
					String[] stringArray2=getMultipleDaata();
					stringBuild=stringObject.appendsChar( stringBuild,space,stringArray2);
					printTheStringBuilder(stringBuild);
					stringBuild=stringObject.deleteFirstString(stringBuild,space);
					printTheStringBuilder(stringBuild);
					break;

				case 5:
					StringBuilder stringBuild1 = stringObject.getStringBuilder(); 
					String[] stringArray3=getMultipleDaata();
					stringBuild1=stringObject.appendsChar( stringBuild1,space,stringArray3);  
					printTheStringBuilder(stringBuild1);

					System.out.println("Enter What the character should be in the middle");
					String middle1 = getUserInput();

					stringBuild1=stringObject.insertChar(stringBuild1, middle1,space1);
					printTheStringBuilder(stringBuild1);
					break;
				case 6:
					StringBuilder stringBuild2 = stringObject.getStringBuilder();
					String[] stringArray4=getMultipleDaata();
					stringBuild2=stringObject.appendsChar( stringBuild2,space,stringArray4);
					printTheStringBuilder(stringBuild2);    
					stringBuild2=stringObject.reverse(stringBuild2);
					printTheStringBuilder(stringBuild2);  
					break;
				case 7:
					StringBuilder stringBuild3 = stringObject.getStringBuilder();
					String[] stringArray8=getMultipleDaata();
					stringBuild3=stringObject.appendsChar( stringBuild3,space,stringArray8); 
					printTheStringBuilder(stringBuild3); 

					System.out.println("Enter the starting value of ");
					int start = getUserInputInt();
					System.out.println("Enter the ending value of  ");
					int end = getUserInputInt();
					stringBuild3= stringObject.deleteTheRequiredChar(stringBuild3, start, end);
					printTheStringBuilder(stringBuild3); 
					break;
				case 8:
					StringBuilder stringBuild4 = stringObject.getStringBuilder(); 
					String[] stringArray5=getMultipleDaata();
					stringBuild4=stringObject.appendsChar(stringBuild4,space,stringArray5);  
					printTheStringBuilder(stringBuild4); 

					System.out.println("Enter the starting value of  ");
					int start1 = getUserInputInt();
					System.out.println("Enter the ending value of  ");
					int end1 = getUserInputInt();
					System.out.println("Enter the string to add");

					String userName4 = getUserInput();
					stringBuild4= stringObject.replace(stringBuild4, start1, end1,userName4);
					printTheStringBuilder(stringBuild4); 

					break;
				case 9:

					StringBuilder stringBuild11 = stringObject.getStringBuilder();
					String[] stringArray6=getMultipleDaata();
					stringBuild11=stringObject.appendsChar(stringBuild11,space,stringArray6);
					printTheStringBuilder(stringBuild11); 

					System.out.println("Enter What the character should be in the middle");
					String middle4 = getUserInput();

					stringBuild11=stringObject.insertChar(stringBuild11, middle4,space1);
					int index1=stringObject.getLastIndex(stringBuild11, middle4);
					System.out.println("The length is : " + index1); 
					break;
				case 10:
					StringBuilder stringBuild12 = stringObject.getStringBuilder();  
					String[] stringArray7=getMultipleDaata();

					stringBuild12=stringObject.appendsChar(stringBuild12,space,stringArray7);
					printTheStringBuilder(stringBuild12);

					System.out.println("Enter What the character should be in the middle");
					String middle44 = getUserInput();
					stringBuild12=stringObject.insertChar(stringBuild12, middle44,space1);
					int index=stringObject.getFirstIndex(stringBuild12, middle44);
					System.out.println("The length is : " + index); 
					break;
				default:
					System.out.println("You are exit from the methods");
					flag=false;	

				}

			}
			catch (Exception ex) {
				System.out.println("Caught the exception");


				System.out.println("Exception occured: " + ex);


			}

		}


	}



}
