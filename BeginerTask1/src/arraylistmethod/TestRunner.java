package arraylistmethod;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	    public static float getUserInputFloat() {
	        while (!myObj.hasNextFloat()) {
	            System.out.println("Please enter in  Decimal format");
	           myObj.next();
	        }
	        float num =myObj.nextFloat() ;
	        return num;

	    }
	    public static long getUserInputLong() {
	        while (!myObj.hasNextFloat()) {
	            System.out.println("Please enter in  Decimal format");
	           myObj.next();
	        }
	        long num =myObj.nextLong() ;
	        return num;

	    }
	    
	    
	    public static void main(String[] args) throws Exception {
	    	ArrayListMethods arrayListMethodObj = new ArrayListMethods();
			  boolean flag=true;
			  int def = 0;
			  String str="";
			  while(flag==true) {
				   int choices = 0;
		            System.out.println("Enter the method number");


		            choices = getUserInputInt();
		            switch(choices) {
		            case 1:
		            	List<Integer> list = arrayListMethodObj.getArrayList(def);
		            
		            	System.out.println("Enter How many data you need ");
		            	int len3 =getUserInputInt();
		            	Integer [] arrInt=new Integer[len3];
		            	for(int i=0;i<len3;i++) {
		            		System.out.println("Enter  integer you need ");
		            		int contain1=getUserInputInt();
		            		arrInt[i]=contain1;
		            	}
		            	
		            	
		            	arrayListMethodObj.add(list, arrInt);
		            	System.out.println("The ArayList size will be "+arrayListMethodObj.getLength(list));
		            	break;
		            case 2:
		            	List <String>stringList = arrayListMethodObj.getArrayList(str);
		            	System.out.println("Enter How many data you need ");
		            	int len4 =getUserInputInt();
		            	for(int i=0;i<len4;i++) {
		            		System.out.println("Enter The string ");
		            		String stringListContain1=getUserInput();
		            		stringList.add(stringListContain1);
		            	}
		            	
		            	System.out.println("The ArayList size will be "+arrayListMethodObj.getLength(stringList));
		            	break;
		            case 3:
		            	List<Employee> employeeList = new ArrayList<>();
		            	Employee emp1=new Employee("Ansar",22,"Developer");
		            	Employee emp2=new Employee("Jeba",22,"Developer");
		            	employeeList.add(emp1);
		            	employeeList.add(emp2);
		            	System.out.println("The ArayList size will be "+arrayListMethodObj.getLength(employeeList));
		            	break;
		            case 4:
		            	List multipleList= new ArrayList<>();
		            	System.out.println("Enter How many data you need ");
		            	int len =getUserInputInt();
		            	for(int i=0;i<len;i++) {
		            		System.out.println("Enter the Integer");
		            		int contain=getUserInputInt();
		            		multipleList.add(contain);
		            	}
		            	System.out.println("Enter How many data you need ");
		            	int len1 =getUserInputInt();
		            	for(int i=0;i<len1;i++) {
		            		System.out.println("Enter the strings ");
		            		String stringListContain=getUserInput();
		            		multipleList.add(stringListContain);
		            	}
		            	Employee emp4=new Employee("Ansar",22,"Developer");
		            	Employee emp5=new Employee("Jeba",22,"Developer");
		            	multipleList.add(emp4);
		            	multipleList.add(emp5);
		            	System.out.println("The ArayList size will be "+arrayListMethodObj.getLength(multipleList));
		            	break;
		            case 5:
		            	List multipleList1= new ArrayList<>();
		            	System.out.println("Enter How many data you need ");
		            	int len2 =getUserInputInt();
		            	for(int i=0;i<len2;i++) {
		            		System.out.println("Enter the Strings");
		            		String stringListContain1=getUserInput();
		            		multipleList1.add(stringListContain1);
		            	}
		            	System.out.println("Enter the String to check ");
	            		String checkVar=getUserInput();
	            		int index=arrayListMethodObj.getIndex(multipleList1, checkVar);
	            		if (index!=-1) {
	            		System.out.println("The Index of "+checkVar+" is at the Position "+ index);
	            		}
	            		else {
	            			System.out.println("The String "+checkVar+" is not available ");
	            		}
		            	break;
		            case 6:
		            	List<String> iterateList= arrayListMethodObj.getArrayList(str);
		            	System.out.println("Enter How many data you need ");
		            	int len6=getUserInputInt();
		            	for(int i=0;i<len6;i++) {
		            		System.out.println("Enter the Strings");
		            		String stringListContain2=getUserInput();
		            		iterateList.add(stringListContain2);
		            	}
		            	arrayListMethodObj.printUsingIterator(iterateList);
		            	arrayListMethodObj.printUsingForLoop(iterateList);
		            	break;
		            case 7:
		            	List<String> listWIthDuplicates= arrayListMethodObj.getArrayList(str);
		            	System.out.println("Enter How many data you need ");
		            	int len7 =getUserInputInt();
		            	for(int i=0;i<len7;i++) {
		            		System.out.println("Enter the Strings");
		            		String stringListContain2=getUserInput();
		            		listWIthDuplicates.add(stringListContain2);
		            	}
		            	
		            	System.out.println("Enter the String to check ");
	            		String checkVar1=getUserInput();
	            		int firstIndex=arrayListMethodObj.getIndex(listWIthDuplicates, checkVar1);
	            		int lastIndex=arrayListMethodObj.getLastIndex(listWIthDuplicates, checkVar1);
	            		System.out.println("The Index of "+checkVar1+" is at the Position "+ firstIndex);
	            		System.out.println("The last Index of "+checkVar1+" is at the Position "+ lastIndex);
	            		break;
		            case 8:
		              	List <String> arrayList8 = arrayListMethodObj.getArrayList(str);
		            	System.out.println("Enter How many data you need ");
		            	int len8 =getUserInputInt();
		            	for(int i=0;i<len8;i++) {
		            		System.out.println("Enter the Strings");
		            		String stringListContain2=getUserInput();
		            		arrayList8.add(stringListContain2);
		            	}
		            	System.out.println("The size before addwill be "+arrayListMethodObj.getLength(arrayList8));
		            	System.out.println("Enter the String to Add ");
	            		String addVar=getUserInput();
	            		System.out.println("Enter the position to add ");
		            	int position8 =getUserInputInt();
		            	arrayListMethodObj.insert(arrayList8,position8, addVar,"Ansar" );
		            	System.out.println("The size after addwill be "+arrayListMethodObj.getLength(arrayList8));
		            	break;
		            case 9:
		            	
		            	List<String> arrayList9 = arrayListMethodObj.getArrayList(str);
		            	System.out.println("Enter How many data you need ");
		            	int len9 =getUserInputInt();
		            	for(int i=0;i<len9;i++) {
		            		System.out.println("Enter the Strings");
		            		String stringListContain9=getUserInput();
		            		arrayList9.add(stringListContain9);
		            	}
		            	System.out.println("The size before add will be "+arrayListMethodObj.getLength(arrayList9));
		            	System.out.println("Enter the Start index");
		            	int start9 =getUserInputInt();
		            	System.out.println("Enter the last index");
		            	int end9 =getUserInputInt();
		            	List<String> alterArrayList9 = arrayListMethodObj.getArrayList(str);
		            	arrayListMethodObj.makeSubList(alterArrayList9,arrayList9, start9, end9);
		            	System.out.println("The size after addwill be "+arrayListMethodObj.getLength(alterArrayList9));
		            	break;
		            case 10:
		            	List<String> arrayList10 = arrayListMethodObj.getArrayList(str);
		            	System.out.println("Enter How many data you need ");
		            	int len10 =getUserInputInt();
		            	for(int i=0;i<len10;i++) {
		            		System.out.println("Enter the Strings");
		            		String stringListContain10=getUserInput();
		            		arrayList10.add(stringListContain10);
		            	}
		            	System.out.println("The size before add will be "+arrayListMethodObj.getLength(arrayList10));
		            	List <String> secondArrayList10 = arrayListMethodObj.getArrayList(str);
		            	System.out.println("Enter How many data you need ");
		            	int seclen10 =getUserInputInt();
		            	for(int i=0;i<seclen10;i++) {
		            		System.out.println("Enter the Strings");
		            		String stringListContain10=getUserInput();
		            		secondArrayList10.add(stringListContain10);
		            	}
		            	System.out.println("The size before add will be "+arrayListMethodObj.getLength(secondArrayList10));
		            	List<String> alterArrayList10 = arrayListMethodObj.getArrayList(str);
		            	arrayListMethodObj.addTwoArrayList(arrayList10,secondArrayList10,alterArrayList10);
		            	System.out.println("The size before add will be "+arrayListMethodObj.getLength(alterArrayList10));
		            	break;
		            case 11:
		            	List<String> arrayList11 = arrayListMethodObj.getArrayList(str);
		            	System.out.println("Enter How many data you need ");
		            	int len11 =getUserInputInt();
		            	for(int i=0;i<len11;i++) {
		            		System.out.println("Enter the Strings");
		            		String stringListContain11=getUserInput();
		            		arrayList11.add(stringListContain11);
		            	}
		            	System.out.println("The size before add will be "+arrayListMethodObj.getLength(arrayList11));
		            	List<String> secondArrayList11 =new ArrayList <String>();
		            	System.out.println("Enter How many data you need ");
		            	int seclen11 =getUserInputInt();
		            	for(int i=0;i<seclen11;i++) {
		            		System.out.println("Enter the Strings");
		            		String stringListContain11=getUserInput();
		            		secondArrayList11.add(stringListContain11);
		            	}
		            	System.out.println("The size before add will be "+arrayListMethodObj.getLength(secondArrayList11));
		            	List<String> alterArrayList11 =new ArrayList <String>();
		            	arrayListMethodObj.addListUsingIndex(arrayList11,secondArrayList11,alterArrayList11);
		            	arrayListMethodObj.printUsingForLoop(alterArrayList11);
		            	System.out.println("The size before add will be "+arrayListMethodObj.getLength(alterArrayList11));
		            	break;
		            case 12:
		            	List arrayList12 =new ArrayList ();
		            	System.out.println("Enter How many data you need ");
		            	int len12 =getUserInputInt();
		            	for(int i=0;i<len12;i++) {
		            		System.out.println("Enter the Decimal values");
		            		float floatList=getUserInputFloat();
		            		arrayList12.add(floatList);
		            	}
		            	System.out.println("The size before add will be "+arrayListMethodObj.getLength(arrayList12));
		            	arrayListMethodObj.remove(arrayList12);
		            	System.out.println("The sizeafter reduction will be "+arrayListMethodObj.getLength(arrayList12));
		            	break;
		            case 13:
		            	List arrayList13 =new ArrayList ();
		            	System.out.println("Enter How many data you need ");
		            	int len13 =getUserInputInt();
		            	for(int i=0;i<len13;i++) {
		            		System.out.println("Enter the Decimal values");
		            		float floatList13=getUserInputFloat();
		            		arrayList13.add(floatList13);
		            	}
		            	System.out.println("The size  will be "+arrayListMethodObj.getLength(arrayList13));
		            	System.out.println("Enter the position to remove ");
		            	int index13 =getUserInputInt();
		            	arrayListMethodObj.remove(arrayList13,index13);
		            	System.out.println("The size after reduction will be "+arrayListMethodObj.getLength(arrayList13));
		            	break;
		            case 14:
		            	List<String> arrayList14 =arrayListMethodObj.getArrayList(str);
		            	System.out.println("Enter How many data you need ");
		            	int len14 =getUserInputInt();
		            	for(int i=0;i<len14;i++) {
		            		System.out.println("Enter the String values");
		            		String stringList14=getUserInput();
		            		arrayList14.add(stringList14);
		            	}
		            	System.out.println("The size  will be "+arrayListMethodObj.getLength(arrayList14));
		            	List<String> secondArrayList14 =new ArrayList <String>();
		            	System.out.println("Enter How many data you need ");
		            	int seclen14 =getUserInputInt();
		            	for(int i=0;i<seclen14;i++) {
		            		System.out.println("Enter the Strings");
		            		String stringListContain14=getUserInput();
		            		secondArrayList14.add(stringListContain14);
		            	}
		            	System.out.println("The size before add will be "+arrayListMethodObj.getLength(secondArrayList14));
		            	arrayListMethodObj.removeTheDuplicates(arrayList14, secondArrayList14);
		            	arrayListMethodObj.printUsingIterator(arrayList14);
		            	System.out.println("The size  will be "+arrayListMethodObj.getLength(arrayList14));
		            	break;
		            case 15:
		            	List <String> arrayList15 =arrayListMethodObj.getArrayList(str);
		            	System.out.println("Enter How many data you need ");
		            	int len15 =getUserInputInt();
		            	for(int i=0;i<len15;i++) {
		            		System.out.println("Enter the String values");
		            		String stringList15=getUserInput();
		            		arrayList15.add(stringList15);
		            	}
		            	System.out.println("The size  will be "+arrayListMethodObj.getLength(arrayList15));
		            	List<String> secondArrayList15 =new ArrayList <String>();
		            	System.out.println("Enter How many data you need ");
		            	int seclen15 =getUserInputInt();
		            	for(int i=0;i<seclen15;i++) {
		            		System.out.println("Enter the Strings");
		            		String stringListContain15=getUserInput();
		            		secondArrayList15.add(stringListContain15);
		            	}
		            	System.out.println("The size before add will be "+arrayListMethodObj.getLength(secondArrayList15));
		            	arrayListMethodObj.removeOddValues(arrayList15, secondArrayList15);
		            	arrayListMethodObj.printUsingIterator(arrayList15);
		            	System.out.println("The size before add will be "+arrayListMethodObj.getLength(arrayList15));
		            	break;
		            case 16:
		            	Long l=(long) 0;
		            	List<Long> arrayList16 =arrayListMethodObj.getArrayList(l);
		            	System.out.println("Enter How many data you need ");
		            	int len16 =getUserInputInt();
		            	for(int i=0;i<len16;i++) {
		            		System.out.println("Enter the String values");
		            		long longList16=getUserInputLong();
		            		arrayList16.add(longList16);
		            			
		            	}
		            	System.out.println("The size before add will be "+arrayListMethodObj.getLength(arrayList16));
		            	arrayListMethodObj.removeAll(arrayList16);
		            	System.out.println("The size before add will be "+arrayListMethodObj.getLength(arrayList16));
	            		break;
		            case 17:
		              
		            	List<String> arrayList17 =arrayListMethodObj.getArrayList(str);
		            	System.out.println("Enter How many data you need ");
		            	int len17 =getUserInputInt();
		            	for(int i=0;i<len17;i++) {
		            		System.out.println("Enter the String values");
		            		String stringList17=getUserInput();
		            		arrayList17.add(stringList17);
		            			
		            	}
		            	System.out.println("The size before add will be "+arrayListMethodObj.getLength(arrayList17));
		            	System.out.println("Enter the value to search  ");
		            	String searchValue =getUserInput();
		            	boolean flagForExist=arrayListMethodObj.isExist(arrayList17, searchValue);
		            	if(flagForExist==true) {
		            		System.out.println("The value is exist");
		            	}
		            	else {
		            		System.out.println("It is not exist");
		            	}
		            	
		            	
		            }
		            }
		            }
}
