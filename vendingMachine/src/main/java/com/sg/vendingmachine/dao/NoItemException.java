/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

/**
 *
 * @author Jtooleyful
 */
public class NoItemException extends Exception{
    public NoItemException(String message) {
        super(message);
    }

    public NoItemException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
