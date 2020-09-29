/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.ui;

import com.sg.vendingmachine.dao.VendingMachineDAO;
import com.sg.vendingmachine.dto.Snack;
import com.sg.vendingmachine.service.VendingMachineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Jtooleyful
 */
@Component
public class VendingMachineView {
    @Autowired
    public VendingMachineView(UserIO io){
        this.io = io;
    }
    private UserIO io;
    private VendingMachineView view;
     private VendingMachineService service;
    
    public void displaySnackList(List<Snack> snackList) {
        String snackInfo = "";
        for (Snack selectedSnack : snackList) {
            snackInfo = String.format("%s : %s : %s",
                    selectedSnack.getName(),
                    selectedSnack.getPrice(),
                    selectedSnack.getInventory());
            io.print(snackInfo);
        }
    }

    public String getSnackName() {
        return io.readString("Please select from the above choices.");
    }


    public String getUserSnack() {
        return io.readString("Please choose a snack: ");
    }

    public String getUserCash() {
        return io.readString("Please enter your cash: ");
    }
    
    public void coinChange(List<Integer> coinCalculation) {
        io.print("Quarters:" + coinCalculation.get(0) + " Dimes:" + coinCalculation.get(1) + " Nickels:" + coinCalculation.get(2) + " Pennies:" + coinCalculation.get(3));
    }

    public void displayAllSnacksBanner() {
        io.print("=== Display All Snacks ==");
    }

    public void displaySuccessfulBanner() {
        io.print("=== Vending is processing. Please hit enter to continue.===");
    }

    public void displayExitBanner() {
        io.print("=== Thank you for vending with us! ===");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== Error ===");
        io.print(errorMsg);
    }
}
