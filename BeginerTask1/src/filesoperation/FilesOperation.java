package filesoperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import exception.UserException;
import testerror.TestError;

public class FilesOperation {

//	  private void nullCheck(Object obj) throws UserException {
//	        if (Objects.isNull(obj)) {
//	            throw new UserException("File or Input Stream  should not be null");
//	        }
//
//	    }//swami-- i create a class called TestError
	  
	public File createFile(String inputName) throws IOException, UserException {
		TestError.nullCheck(inputName);
		File fileObj = new File(inputName);
		return fileObj;
	}
	
	
	public void writeFile(File inputFile,String inputWrite) throws IOException, UserException  {
		TestError.nullCheck(inputFile);
		try( FileWriter fStream = new FileWriter(inputFile,true);){
			 fStream.write(inputWrite+"\n");
		}
		

	}
	public void writeProperties(String fileName,String key,String value) throws IOException, UserException   {
		TestError.nullCheck(fileName);
		TestError.nullCheck(key);
		TestError.nullCheck(value);
		Properties propObj=new Properties();  
		propObj.setProperty(key,value);  
		try(FileWriter fileWriteObj=new FileWriter(fileName);){
			propObj.store(fileWriteObj,"The key and values are");  //swami-- i enclose with try with resources
		}
	
//		File fileObj = new File(fileName);//swami- as your suggesstion i kept it as a void method
//		return fileObj;
//		
	}
	public Properties loadProperties(File inputFile) throws IOException, UserException {
		
		TestError.nullCheck(inputFile);
		Properties inputProp=  new Properties();
		try(FileInputStream fStream=new FileInputStream(inputFile);){
			inputProp.load(fStream);
		} 
		return inputProp;
		
	}
	public File createDirectories(String directory,String inputName) throws IOException, UserException {
		TestError.nullCheck(directory);
		TestError.nullCheck(inputName);
		File root=new File(directory);
		root.mkdir();//Swami-it wont create new directory if exist
		File file= new File(root,inputName);
		return file;
		
	}

	


}
