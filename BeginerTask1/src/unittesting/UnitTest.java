package unittesting;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.UserException;

public class UnitTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, UserException {  
		Class<?> reflectClass=Class.forName("stringmethod.StringMethod")  ;
		Object training =reflectClass.getDeclaredConstructor().newInstance();
		Method[] methods=reflectClass.getDeclaredMethods();
		Map<String,List<String>> map=new HashMap<>();
		List<String> list =new ArrayList<>();
		List<String>list2 =new ArrayList<>();
		int count=0;
		for(Method method:methods) {
			Class[] parameter = method.getParameterTypes();
			
			int parameterCount=  method.getParameterCount();
			method.setAccessible(true);

			Object[] valueArr = new Object[parameterCount];

			for(int i=0;i<parameterCount;i++) {
				if(parameter[i].getName()=="char") {
					valueArr[i]='\0';
				}
				else if(parameter[i].isPrimitive()) {
					valueArr[i]=0;
				}

				else {
					valueArr[i]=null;
				}


			}

			try{
				method.invoke(training,valueArr);
			}
			catch(Exception e ) {
				{
					if(e.getCause().getClass().getName()!="exception.UserException") {
						list.add(method.getName());
						map.put( "Failed",list);
					}
					else {
						list2.add(method.getName());
						map.put( "Passed",list2);
					}
					count++;
				}
			}

		}

		System.out.println(map);


	}
}


