package com.betulsahin.schoolmanagementsystemdemov4.exception;

public class CourseIsAlreadyExistException extends RuntimeException{
    public CourseIsAlreadyExistException(String message){
        super(message);
    }
}
