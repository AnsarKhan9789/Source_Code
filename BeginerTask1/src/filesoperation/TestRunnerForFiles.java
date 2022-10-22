package filesoperation;
import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;  // Import the IOException class to handle errors
import java.text.DateFormatSymbols;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

import exception.UserException;

public class TestRunnerForFiles {
	static Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	static Scanner myObj = new Scanner(System.in);
	static Scanner myObj2 = new Scanner(System.in);

	public static String getUserInput() {
		String userName = myObj.next();
		return userName;
	}
	public static String getUserMultipleInput() {

		String userName = myObj2.nextLine();
		return userName;
	}
	public static int getUserInputInt() {
		while (!myObj.hasNextInt()) {
			logger.info("Please enter in  integer format");
			myObj.next();
		}
		int num =myObj.nextInt() ;
		return num;

	}
	public static char getUserInputChar() {
		char character = myObj.next().charAt(0);
		return character;
	}

	public static void main(String[] args) {
		FilesOperation fileOperations=new FilesOperation();


		boolean iterateChoice=true;
		while(iterateChoice==true){
			logger.info("Please enter the int");
			int choices=getUserInputInt();

			try {

				switch(choices) {
				case 1:

					//logger.info("Please enter the File name");
					//String fileName=getUserInput();
					//logger.info("Enter the contents to add ");
					//String writeVar=getUserMultipleInput();
					File fileObj = fileOperations.createFile("vf");
					if (fileObj.createNewFile()) {
						logger.info("File created: " + fileObj.getName());
					} else {
						logger.info("File already exists.");
					}
					fileOperations.writeFile(fileObj, null);
					  
					break;
				case 22:
					logger.info("Please enter the key");
					String key=getUserInput();
					logger.info("Please enter the value");
					String value=getUserInput();
					fileOperations.writeProperties( "info",key, value);
					File file22= fileOperations.createFile("info");   
					try(FileReader fileReadObj=new FileReader(file22); ){
						int loopVar;    
						while((loopVar=fileReadObj.read())!=-1) {
							System.out.print((char)loopVar);  
						}   
					}
					   
					

					//fileReadObj.close();    //thoooooooo//thoooooooo//-used try with resources

					Properties prop1 = fileOperations.loadProperties(file22);
					
					logger.info(""+prop1);

					break;
				case 33:
//					logger.info("Please enter the Directory");
//					String directory=getUserInput();
//					logger.info("Please enter the File name");
//					String fileName33=getUserInput();
					File file33=fileOperations.createDirectories("sita","Ansar");
					for(int i=0;i<5;i++) {
						logger.info("Enter the string");
						String writeVar1=getUserMultipleInput();
						fileOperations.writeFile(file33, writeVar1);
					}

				try(BufferedReader bufferReader= new BufferedReader(new FileReader(file33));){

					String stringForBuffer;

					while ((stringForBuffer = bufferReader.readLine()) != null){

						logger.info(stringForBuffer);
					}//thoooooooo//thoooooooo//thoooooooo//thoooooooo--put in while loop with {}
					
				}




					//bufferReader.close();//thooooooooooooooooooooooooooooo- used try with resources
					break;
				case 2:
					logger.info(""+Rainbow.Blue);

					break;
				case 3:
					Training trainObj=new Training("constructor");
					logger.info(""+trainObj);
					break;
				case 4:
					Training trainObj1=new Training("constructor");
					logger.info(""+trainObj1);
					break;
				case 5:
					PojoForFiles trainObj2=new PojoForFiles();
					trainObj2.setName("ansar");
					trainObj2.setAge(22);
					logger.info(""+trainObj2);
					break;
				case 6:
					Singleton obj1 = Singleton.getInstance();

					// Instantiating Singleton class with variable y
					Singleton obj2 = Singleton.getInstance();

					// Instantiating Singleton class with variable z
					obj1.singletonName="Ansar";

					logger.info(""+obj1);
					logger.info(""+obj2);


					break;
				case 7:
					DateAndTimeOperation dateAndTime=new DateAndTimeOperation();
					logger.info(""+dateAndTime.getCurrentTime());
					
					logger.info(""+dateAndTime.getDateOfDay(1404128471000L));
					logger.info(""+dateAndTime.getMonth(1404128471000L));
					logger.info(""+dateAndTime.getYear(1404128471000L));
				
				System.out.println(dateAndTime.getTimeWithTimeZone(null));
					break;
				default:
					logger.info("The application closed");
					iterateChoice=false;
					
				}

			} catch (IOException e) {
				
				logger.info("An error occurred.");
				e.printStackTrace();
			} catch (UserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}

	}

}
