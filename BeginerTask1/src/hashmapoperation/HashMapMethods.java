package hashmapoperation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import exception.UserException;
import inheritancepackage.Car;

public class HashMapMethods {
	
	  private void nullCheck(Object obj) throws UserException {
	        if (Objects.isNull(obj)) {
	            throw new UserException("Object should not be null");
	        }

	    }

	public Map<String, String> createHashMap() {
		
		Map<String, String> map = new HashMap<>();
		return map;
	}
	public Map<Integer, Integer> createHashMapInteger() {
		
		Map<Integer, Integer> map = new HashMap<>();
		return map;
	}
	public Map<String, Integer> createHashMapS() {
		
		Map<String, Integer> map = new HashMap<>();
		return map;
	}
	public Map<String, Object> createHashMapObjects() {
		
		Map<String, Object> map = new HashMap<>();
		return map;
	}
	public int getLength(Map map) throws UserException {
		nullCheck(map);
		return map.size();
	}
	public void put(Map<String, Object> map4, String key, Object newCar) throws UserException {
		nullCheck(map4);
		map4.put(key, newCar);
	}
	public void put(Map<String, String> map,String key,String value) throws UserException {
		nullCheck(map);
		  map.put(key, value);
	}
	public void put(Map<String, Integer> map,String key,int value) throws UserException {
		nullCheck(map);
		  map.put(key, value);
	}
	public void put(Map<Integer, Integer> map,int key,int value) throws UserException {
		nullCheck(map);
		  map.put(key, value);
	}
	public boolean isContainKey(Map<String,Integer> map,String key)throws UserException  {
		nullCheck(map);
		return map.containsKey(key);
	}
	
	public boolean isContainValue(Map<String,Integer> map,int value)throws UserException  {
		nullCheck(map);
		return map.containsValue(value);
	}
	
	public Object getValue(Map<String,String> map,String key) throws UserException {
		nullCheck(map);
		return map.get(key);
		
	}
	public Object getValueOrDefault(Map<String,String> map,String key)throws UserException  {
		nullCheck(map);
		
		return map.getOrDefault(key,"Zoho");
		
	}
	public Object remove(Map<String,Integer> map,String key) throws UserException {
		nullCheck(map);
		
		return map.remove(key);
		
	}
	public Object remove(Map<String,Integer> map,String key,int value)throws UserException  {
		nullCheck(map);
		
		return map.remove(key,value);
		
	}
	public void replace(Map<String,Integer> map,String key,int value) throws UserException {
		nullCheck(map);
		
		 map.replace(key,value);
		
	}
	public void replace(Map<String,Integer> map,String key,int value,int newValue) throws UserException  {
		nullCheck(map);
		
		 map.replace(key,value,newValue);
		
	}
	public void copiesAll(Map<String,Integer> map,Map<String,Integer> alterMap) throws UserException  {
		nullCheck(map);
		
		 alterMap.putAll(map);
		
		
	}
	public void print(Map<String,Integer> map) throws UserException {
		nullCheck(map);
		map.forEach((key, value) -> {

			      System.out.println("The key value is "+key +" The value will be " + value );
			    });
	}
	public void deleteAll(Map<String,Integer>  map) throws UserException {
		nullCheck(map);
		map.clear();
	}
	
	
}
