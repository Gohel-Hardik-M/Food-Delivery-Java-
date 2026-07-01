package com.tss.Exception;

public class InputException extends  RuntimeException{
    void InvalidInput(String msg){
        System.out.println(msg);
    }
}
