package org.example.Exception;
/*
Throws exception if numeric value is inserted when naming food item or type. This should not be numeric and should only be a character string.
 */
public class MenuException extends Exception{
    public MenuException(String message){
        super(message);
    }
}
