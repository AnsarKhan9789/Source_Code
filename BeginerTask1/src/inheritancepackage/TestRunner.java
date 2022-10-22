package inheritancepackage;

import java.util.Scanner;

public class TestRunner {
    static Scanner myObj = new Scanner(System.in);
    static Swift bumbleBee=new Swift();
	  static Xuv optimusPrime=new Xuv();
	  static Scross tesla=new Scross(); 

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
	  public static void accessParent(Car obj) {
    	 
    	 if(obj.equals(bumbleBee)) {
    		
       	obj.setType("Hatch");
       	String typeForCar=obj.getType();
       	 System.out.println("The Type that choose for your car is "+typeForCar);
    	 }
    	 else if(obj.equals(tesla)) {
    			obj.setType("Seedan");
    		 System.out.println("The Type that choose for your car is "+obj.getType());
    	 }
    	 else {
    	
       	obj.setType("SUV");
       	 System.out.println("The Type that choose for your car is "+obj.getType());
    	 }
    	 
    }
  public static void testSwift(Swift obj) {
	  obj.setEngineNumber("swf9078");
	  System.out.println("The Type that choose for your car is "+obj.getEngineNumber());
	  
  }
	  public static void main(String[] args) {
		  boolean flag=true;
		  while(flag==true) {
			   int choices = 0;
	            System.out.println("Enter the method number");


	            choices = getUserInputInt();
	            switch(choices) {
	            case 1:
	            	System.out.println("How Much Seater you need");
	      		  int Seater=getUserInputInt();
	      		  bumbleBee.setSeats(Seater);
	      		 
	      		  System.out.println("How Much airbags you need");
	      		  int airBags=getUserInputInt();
	      		  bumbleBee.setAirBags(airBags);
	      		 
	      		  System.out.println("What is the type you prefer ");
	      		  String model=getUserInput();
	      		  bumbleBee.setModel(model);
	      		 		  System.out.println("What is the Color you prefer ");
	      		  String color=getUserInput();
	      		  bumbleBee.setColor(color);
	      		  
	      		  System.out.println("The specification you choose for the Swift is ");
	      		  System.out.println("The Seat of the swift is "+ bumbleBee.getSeats());
	      		  System.out.println("The Air bag of the swift is "+ bumbleBee.getAirBags());
	      		  System.out.println("The Model of the swift is "+ bumbleBee.getModel());

	      		  System.out.println("The Model of the swift is "+ bumbleBee.getColor());
	      		  break;
	            case 2:
	            	System.out.println("Which year you prefer ");
	      		  int year=getUserInputInt();
	      		  tesla.setYearOfMake(year);
	      		  
	      		  System.out.println("Enter your engine number");
	      		  String engineNo=getUserInput();
	      		  tesla.setEngineNumber(engineNo);
	      		  
	      		  System.out.println("Enter your type");
	      		  String type=getUserInput();
	      		  tesla.setType(type);
	      		  
	      		  System.out.println("How Much Seater you need");
	      		  int Seater2=getUserInputInt();
	      		  tesla.setSeats(Seater2);
	      		 
	      		  System.out.println("How Much airbags you need");
	      		  int airBags2=getUserInputInt();
	      		  tesla.setAirBags(airBags2);
	      		 
	      		  System.out.println("What is the type you prefer ");
	      		  String model2=getUserInput();
	      		  tesla.setModel(model2);
	      		 		  System.out.println("What is the Color you prefer ");
	      		  String color2=getUserInput();
	      		  tesla.setColor(color2);
	      		  System.out.println("The specification of your old car is ");
	      		  System.out.println("The Year of the Car is "+ tesla.getYearOfMake());
	      		  System.out.println("The Engine number of your car is "+ tesla.getEngineNumber());
	      		  System.out.println("The type of the car is  "+ tesla.getType());

	      		  System.out.println("The Model of the Xuv is "+ tesla.getColor());
	      		  System.out.println("The specification you choose for the Xuv is ");
	      		  System.out.println("The Seat of the Xuv is "+ tesla.getSeats());
	      		  System.out.println("The Air bag of the Xuv is "+ tesla.getAirBags());
	      		  System.out.println("The Model of the Xuv is "+ tesla.getModel());

	      		  System.out.println("The Model of the Xuv is "+ tesla.getColor());
	            	break;
	            case 3:
	            	 accessParent(bumbleBee);
	            	 accessParent(tesla);
	            	 accessParent(optimusPrime);
	            	 break;
	            case 4:
	            	  testSwift(bumbleBee);
	       		 Car swift = new Swift();
	       		//testSwift(swift);
	       		//testSwift(optimusPrime);
	       		//testSwift(tesla);
	       		 break;
	            case 5:
	            	 Car scross=new Scross();
	            	  tesla.maintanance();
	            	  Car car1 =new Car();
	            	  car1.maintanance();
	        		  scross.maintanance();
	        		  bumbleBee.maintanance();
	        		  break;
	            case 6:
	            	 Car car2 =new Car("Ansar");
	            	 Xuv tesla1=new Xuv();
	            	 break;
	            case 7:
	            	//Bird bird = new Bird();
	            	  ParrotMod parrot = new ParrotMod();
	        		  parrot.fly();
	        		  parrot.speak();
	        		  break;
	            case 8:
	            	 Duck duck = new Duck();
	       		  duck.fly();
	       		  duck.speak();
	       		  break;
	            default:
	       			  System.out.println("You are exited");
	       			  flag=true;
	       		
	            }
		  }
		  
	  }

}
