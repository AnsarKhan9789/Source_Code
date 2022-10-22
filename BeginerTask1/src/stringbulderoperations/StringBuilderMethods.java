package stringbulderoperations;

import java.util.Objects;

import exception.UserException;

public class StringBuilderMethods {

	private void nullCheck(Object obj) throws UserException {
		if (Objects.isNull(obj)) {
			throw new UserException("Object should not be null");
		}

	}
	private void isCorrectValue(int start,int length,int end) throws UserException {
		if (start < 0 || end<0) {
			throw new UserException("Index value should not be negative "+start+" "+end);
		}

		else if(length < start || length < end) {
			throw new UserException("The Index of sub string should not be exceed from the String");
		} 

	}


	private void isCorrectValue(int index) throws UserException {
		if(index<0) {
			throw new UserException("The character you enter is not exist");
		}
	}
	public StringBuilder getStringBuilder() {
		StringBuilder stringBuilderObject=new StringBuilder();
		return stringBuilderObject;
	}

	public int getLength(StringBuilder inputName) throws UserException {
		nullCheck(inputName);
		int length=inputName.length();
		return length;
	}
	public StringBuilder appends(StringBuilder inputName,String... inputName1)throws UserException {
		nullCheck(inputName);
		nullCheck(inputName1);
		int length=inputName1.length;

		if(length<0) {
			throw new UserException("The value should not be empty");
		}

		for(int i=0;i<length;i++) {

			inputName.append(inputName1[i]);
		}

		return inputName;
	}

	public StringBuilder appendsChar(StringBuilder inputName,String mid,String... stringArray) throws UserException {
		nullCheck(inputName);
		nullCheck(stringArray);
		for(int i=0;i<stringArray.length;i++) {
			inputName.append(stringArray[i]);
			inputName.append(mid);
		}
		int length=inputName.length();
		inputName.delete(length-1, length);
		return inputName;

	}
	public StringBuilder insert(StringBuilder inputName,String searchValue,String... name) throws UserException {

		nullCheck(name);

		int length=name.length;

		if(length<0) {
			throw new UserException("The value should not be empty");
		}
		for(int i=0;i<length;i++) {

			int index=getLastIndex(inputName,searchValue);
			isCorrectValue(index);
			inputName.insert(index, searchValue);
			inputName.insert(index+1,name[i]);
		}

		return inputName;



	}
	public StringBuilder insertChar(StringBuilder inputName,String replaceString,char searchValue) throws UserException {
		int len=getLength(inputName);
		StringBuilder alterStringBuilder= getStringBuilder();
		for(int i=0;i<len;i++) {
			if(inputName.charAt(i)== searchValue) {

				alterStringBuilder=replace(inputName,i,i+1,replaceString);

			}
		}
		return alterStringBuilder;

	}

	public StringBuilder deleteFirstString(StringBuilder inputName,String searchValue) throws UserException {

		int index=getFirstIndex(inputName,searchValue);
		isCorrectValue(index);
		return inputName.delete(0,index);

	}
	public StringBuilder reverse(StringBuilder inputName)throws UserException{
		nullCheck(inputName);
		return inputName.reverse();
	}
	public StringBuilder deleteTheRequiredChar(StringBuilder inputName,int first,int last) throws UserException {
		int length=getLength(inputName);
		isCorrectValue(first,length,last);
		return inputName.delete(first,last);
	}
	public StringBuilder replace(StringBuilder inputName,int first,int last,String middle) throws UserException {
		int length=getLength(inputName);
		isCorrectValue(first,length,last);
		return inputName.replace(first,last,middle);
	}
	public int getFirstIndex(StringBuilder inputName,String searchValue) throws UserException {
		nullCheck(inputName);
		return inputName.indexOf(searchValue);
	}
	public int getLastIndex(StringBuilder inputName,String searchValue) throws UserException {
		nullCheck(inputName);

		return inputName.lastIndexOf(searchValue);
	}



}
