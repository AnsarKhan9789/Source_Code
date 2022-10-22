package test;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import exception.UserException;

public class TestConstructor   {
	static Logger logger =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static void main(String args[]) throws Exception {
		ReflectionMethods reflectObj = new ReflectionMethods();
		Object training1=null;
		//boolean flag=true;
//		while(flag) {
//			int x= 2;
//			switch(x) {
//			case 1:
//				break;
//			case 2:
//				break;
//			case 3:
//				break;
//				
//			}
//		}
	try {
		Class<?> reflectClass= reflectObj.getClass("filesoperation.PojoForFiles");
		
		Constructor<?> defaultConstructor=reflectObj.getConstructor(reflectClass);
		
		 training1=reflectObj.getInstance(defaultConstructor);
		
		
		 Class[]inputClassType= {String.class,int.class};
		Constructor<?> defaultConstructor1=reflectObj.getConstructor(reflectClass,inputClassType);
		Object training12=reflectObj.getInstance(defaultConstructor1,"Ansar",22);

			
			Method setName=reflectObj.getMethod(reflectClass, "setName",String.class);//thoooooooo-change the method name
			Method getName=reflectObj.getMethod(reflectClass, "getName");//thoooooooo- change the method name
			Method getAge=reflectObj.getMethod(reflectClass, "getAge");
			
			//logger.info(setName);//thoooooooogl-change the method name
			reflectObj.executeMethod(setName, training1, "Ansar");
			String name=(String) reflectObj.executeMethod(getName, training1);//thoooooooo-change the method name
			int age=(Integer)reflectObj.executeMethod(getAge, training12);
			logger.info(""+age);
			logger.info(name);//thoooooooo-change the method name

	}catch(UserException classNotFound) {
		classNotFound.printStackTrace();
	}
		
	
}
}
