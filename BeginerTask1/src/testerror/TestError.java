package testerror;

import java.util.Objects;

import exception.UserException;

public class TestError {
    public static void nullCheck(Object obj) throws UserException {
        if (Objects.isNull(obj)) {
            throw new UserException("Object should not be null");
        }

    }
      public static void nullCheck(Object obj,Object obj1) throws UserException {
        if (Objects.isNull(obj)||Objects.isNull(obj1)) {
            throw new UserException("Object should not be null");
        }

    }
    public static void isCorrectValue(int subStringIndex,int length) throws UserException {
        if (subStringIndex < 0) {
            throw new UserException("Number value should not be negative");
        }
        
        else if(length < subStringIndex) {
            throw new UserException("The Index of sub string should not be exceed from the String");
        } 


    }
    public static void isEmptyString(String inputNames) throws UserException {
        if ( Objects.isNull(inputNames) || inputNames.isEmpty()) {
            throw new UserException("InputNames should not be empty or null");
        }
    }
}
