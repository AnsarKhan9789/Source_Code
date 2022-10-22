package arraylistmethod;

import java.util.ArrayList;
import java.util.Iterator;

import java.util.List;

import java.util.Objects;

import exception.UserException;

public class ArrayListMethods {
	
    private void nullCheck(Object obj) throws UserException {
        if (Objects.isNull(obj)) {
            throw new UserException("Object should not be null");
        }

    }
	private void isCorrectValue(int index) throws UserException {
		if(index<0) {
			throw new UserException("Index should not be negative");
		}
	}
	private void isCorrectValue(int start,int end,int length) throws UserException {
		if (start < 0 || end<0) {
			throw new UserException("Index value should not be negative "+start+" "+end);
		}

		else if(length < start || length < end) {
			throw new UserException("The Index of sub list should not be exceed from the list");
		} 

	}
    public <T>List<T> getArrayList(T type) {
    	List<T> arrayList=new ArrayList<>();
    	return arrayList;
    }
    public <T> void add(List<T> inputList,T[] inputArray)throws UserException {
    	nullCheck(inputList);
    	nullCheck(inputArray);
    	for(int i=0;i<inputArray.length;i++) {
    		inputList.add(inputArray[i]);
    		
    	}
    
    }
  
	public  <T> int getLength(List<T> parameterList) throws UserException{
		nullCheck(parameterList);
		return parameterList.size();
	}
	public <T> int getIndex(List<T> list,T checkVariable) throws UserException {
		nullCheck(list);
		nullCheck(checkVariable);
		return list.indexOf(checkVariable);
	}
	public<T> void printUsingIterator(List<T> list) throws UserException {
		nullCheck(list);
		 Iterator<T> iterateList = list.iterator();
		 while(iterateList.hasNext()) {
			 System.out.print(iterateList.next());
			 System.out.println("");
		 }
	}
	public<T>  void printUsingForLoop(List<T> list) throws UserException {
		nullCheck(list);
		for(T stringValue: list) {
			System.out.print(stringValue);
		}
		
	}
	public <T> int getLastIndex(List<T> list,T checkVariable) throws UserException {
		nullCheck(list);
		nullCheck(checkVariable);
		return list.lastIndexOf(checkVariable);
	}
	public <T>void insert(List<T> list,int index,T... insertVariable) throws UserException {
		nullCheck(list);
		nullCheck(insertVariable);
		isCorrectValue(index);
				for(T insertVariables: insertVariable) {
					list.add(index,  insertVariables);
				}
		 
	}
	public<T> void makeSubList(List<T> alterArrayList,List<T> list,int start,int last) throws UserException {
		nullCheck(alterArrayList);
		int length=getLength(list);
		isCorrectValue(start,last,length);
		alterArrayList.addAll(list.subList(start, last)) ;
		
	}
	public<T> void addTwoArrayList(List<T> firstList,List<T> secondList,List<T> toAlterList) throws UserException {
		nullCheck(firstList);
		nullCheck(secondList);
		nullCheck(toAlterList);
		firstList.addAll(secondList)	;
		toAlterList.addAll(firstList);
	}
	public<T> void addListUsingIndex(List<T> firstList,List<T> secondList,List<T> toAlterList) throws UserException {
		nullCheck(firstList);
		nullCheck(secondList);
		nullCheck(toAlterList);
		firstList.addAll(0,secondList)	;
		toAlterList.addAll(firstList);
	}
	public<T> void remove(List<T> list) throws UserException {
		int index =getLength(list)-1;
		list.remove(index);
		
	}
	public<T> void remove(List<T> list,int index) throws UserException {
		isCorrectValue(index);
		nullCheck(list);
		list.remove(index);
		
	}
	public<T> void removeTheDuplicates(List<T> list,List<T> secondList) throws UserException {
		nullCheck(secondList);
		nullCheck(list);
		list.removeAll(secondList);
		
	}
	public<T> void removeOddValues(List<T> list,List<T> secondList) throws UserException {
		nullCheck(secondList);
		nullCheck(list);
		list.retainAll(secondList);
		
	}
	public <T>void removeAll(List<T> list) throws UserException {
		nullCheck(list);
		removeAll(list);
		
	}
	public<T> boolean isExist(List<T> list,T search) throws UserException {
		nullCheck(list);
		//nullCheck(search);//swami
		return list.contains(search);
	}
	
}
