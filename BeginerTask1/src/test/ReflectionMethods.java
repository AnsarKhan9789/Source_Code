package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import exception.UserException;
import testerror.TestError;

public class ReflectionMethods {
	
public Class<?> getClass(String className) throws UserException {
	TestError.nullCheck(className);
	Class<?> reflectClass=null;
	try {
		reflectClass = Class.forName(className);
	} catch (ClassNotFoundException e) {
	
		throw new UserException("There is no such class exist"+e);
	}
	return reflectClass;
}
public Constructor<?> getConstructor(Class<?> reflectClass,Class<?>...classes) throws UserException  {
	Constructor<?> defaultConstructor =null;
	TestError.nullCheck(reflectClass);
	try {
		defaultConstructor = reflectClass.getDeclaredConstructor(classes);
	} catch (NoSuchMethodException | SecurityException e) {
		throw new UserException("There is a issue in "+ e);
	}
	return defaultConstructor;
}
public Object getInstance(Constructor<?> reflectConstructor,Object...objects)throws UserException {
	Object reflectObj=null;
	TestError.nullCheck(reflectConstructor);
	try {
		 reflectObj=reflectConstructor.newInstance(objects);
		
	} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
		throw new UserException("There is a issue in "+ e);
	}
	return reflectObj;
}
public Method getMethod(Class<?> reflectClass,String methodName,Class<?>...classes) throws UserException  {
	Method method;
	TestError.nullCheck(reflectClass);
	TestError.nullCheck(methodName);
	
	try {
		method = reflectClass.getDeclaredMethod(methodName, classes);
	} catch (NoSuchMethodException | SecurityException e) {
		throw new UserException("There is a issue in "+ e);
	}
	return method;
}
public Object executeMethod(Method method,Object inputObj,Object...inputArgs) throws UserException {
	TestError.nullCheck(method,inputObj);
	try {
		return method.invoke(inputObj, inputArgs);
	} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
		throw new UserException("There is a issue in "+ e);
	}
	
}



}
