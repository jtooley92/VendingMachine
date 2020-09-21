/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author Jtooleyful
 */
public class Snack {
    
   private String name;
   private BigDecimal price;
   private int inventory;

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
   
   public Snack (String name){
       this.name = name;
   }
   
   public String getName() {
       return name;
   }
   
   public void setPrice (BigDecimal price){
       this.price = price;
   }
   
   public BigDecimal getPrice() {
       return price;
   }
}
