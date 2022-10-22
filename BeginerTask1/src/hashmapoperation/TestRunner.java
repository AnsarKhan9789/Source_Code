package hashmapoperation;

import java.util.Map;
import java.util.Scanner;

import exception.UserException;
import inheritancepackage.Car;

public class TestRunner {
	static Scanner myObj = new Scanner(System.in);

	public static int getUserInputInt() {
		while (!myObj.hasNextInt()) {
			System.out.println("Please enter in  integer format");
			myObj.next();
		}
		int num =myObj.nextInt() ;
		return num;

	}
	public static void main(String[] args) throws UserException   {
		HashMapMethods hashMethods=new HashMapMethods();

		boolean loopChoice=true;
		while(loopChoice==true) {
			int choices = 0;
			System.out.println("Enter the method number");
			choices = getUserInputInt();
			switch(choices) {
			case 1:
				Map<String, String> map =hashMethods.createHashMap();
				System.out.println(map);
				System.out.println(hashMethods.getLength(map));
				break;
			case 2:
				Map<String, String> map1 =hashMethods.createHashMap();
				hashMethods.put(map1, "one", "Ansar");
				hashMethods.put(map1, "two", "jeba");

				System.out.println(map1);
				System.out.println(hashMethods.getLength(map1));
				break;
			case 3:
				Map<Integer, Integer> mapInteger =hashMethods.createHashMapInteger();
				hashMethods.put(mapInteger, 1, 1);
				hashMethods.put(mapInteger, 2, 2);

				System.out.println(mapInteger);
				System.out.println(hashMethods.getLength(mapInteger));
				break;
			case 4:
				Map<String,Integer> map3=hashMethods.createHashMapS();
				hashMethods.put(map3,"1", 1);
				hashMethods.put(map3,"two", 3);
				hashMethods.put(map3,"three", 2);
				System.out.println(map3);
				System.out.println(hashMethods.getLength(map3));
				break;
			case 5:
				Car newCar=new Car();
				Map<String, Object> map4=hashMethods.createHashMapObjects();
				hashMethods.put(map4,"Ansar", newCar);
				System.out.println(map4);
				System.out.println(hashMethods.getLength(map4));
				break;
			case 6:
				Map<String, String> map5 =hashMethods.createHashMap();
				hashMethods.put(map5,null, "Ansar");
				hashMethods.put(map5,"two", "Ansar");
				hashMethods.put(map5,"three", null);
				System.out.println(map5);
				System.out.println(hashMethods.getLength(map5));
				break;
			case 7:
				Map<String,Integer> map7=hashMethods.createHashMapS();
				hashMethods.put(map7,"1", 1);
				hashMethods.put(map7,"two", 3);
				hashMethods.put(map7,"three", 2);
				boolean flag=hashMethods.isContainKey(map7, "Two");
				boolean flag2=hashMethods.isContainValue(map7, 2);
				System.out.println("The given key  "+flag);
				System.out.println("The given value is "+flag2);
				break;
			case 8:
				Map<String,String> map8=hashMethods.createHashMap();
				hashMethods.put(map8,"1", "1");
				hashMethods.put(map8,"two", "3");
				hashMethods.put(map8,"three", "2");
				Object obj1=hashMethods.getValue(map8, "1");
				System.out.println(obj1.toString());

				Object obj2=hashMethods.getValueOrDefault(map8, "10");
				System.out.println(obj2.toString());
				break;
			case 9:
				Map<String,Integer> map9=hashMethods.createHashMapS();
				hashMethods.put(map9,"1", 1);
				hashMethods.put(map9,"two", 3);
				hashMethods.put(map9,"three", 2);
				Object obj3=hashMethods.remove(map9, "1");

				System.out.println(map9);
				System.out.println(hashMethods.getLength(map9));

				Object obj4=hashMethods.remove(map9, "two",3);
				System.out.println(obj4.toString());
				System.out.println(map9);
				System.out.println(hashMethods.getLength(map9));
				break;
			case 10:
				Map<String,Integer> map10=hashMethods.createHashMapS();
				hashMethods.put(map10,"1", 1);
				hashMethods.put(map10,"two", 3);
				hashMethods.put(map10,"three", 2);
				System.out.println(map10);
				System.out.println(hashMethods.getLength(map10));
				hashMethods.replace(map10, "one",4);

				System.out.println(map10);
				System.out.println(hashMethods.getLength(map10));
				break;
			case 11:
				Map<String,Integer> map11=hashMethods.createHashMapS();
				hashMethods.put(map11,"1", 1);
				hashMethods.put(map11,"two", 3);
				hashMethods.put(map11,"three", 2);


				System.out.println(map11);
				System.out.println(hashMethods.getLength(map11));
				hashMethods.replace(map11, "one",4,5);
				System.out.println(map11);
				System.out.println(hashMethods.getLength(map11));
				break;
			case 12:
				Map<String,Integer> map12=hashMethods.createHashMapS();
				hashMethods.put(map12,"1", 1);
				hashMethods.put(map12,"two", 3);
				hashMethods.put(map12,"three", 2);
				Map<String,Integer> map6=hashMethods.createHashMapS();
				hashMethods.put(map6,"one", 21);
				hashMethods.put(map6,"two", 51);
				hashMethods.put(map6,"three", 11);
				System.out.println(map6);
				System.out.println(hashMethods.getLength(map6));
				hashMethods.copiesAll(map12,map6);
				System.out.println(map6);
				System.out.println(hashMethods.getLength(map6));
				break;
			case 13:
				Map<String,Integer> map13=hashMethods.createHashMapS();
				hashMethods.put(map13,"one", 21);
				hashMethods.put(map13,"two", 51);
				hashMethods.put(map13,"three", 11);
				hashMethods.print(map13);
				break;
			case 14:
				Map<String,Integer> map14=hashMethods.createHashMapS();
				hashMethods.put(map14,"one", 21);
				hashMethods.put(map14,"two", 51);
				hashMethods.put(map14,"three", 11);
				hashMethods.deleteAll(map14);
				System.out.println(map14);
				System.out.println(hashMethods.getLength(map14));
				break;
			default:
				loopChoice=false;
				break;



			}

		}

	}
}
