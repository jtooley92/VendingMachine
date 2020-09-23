/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDAO;
import com.sg.vendingmachine.dao.VendingMachineDAOException;
import com.sg.vendingmachine.dao.VendingMachineDAOFileImpl;
import com.sg.vendingmachine.dto.Snack;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jtooleyful
 */
public class VendingMachineServiceImpl implements VendingMachineService {

    VendingMachineDAO dao = new VendingMachineDAOFileImpl();

    @Override
    public List<Snack> getAllSnacks() throws VendingMachineDAOException {

        return dao.getAllSnacks();
    }

    @Override
    public Snack getSnack(String name) throws VendingMachineDAOException {

        return dao.getSnack(name);
    }

    @Override
    public Snack removeSnack(Snack snack) throws VendingMachineDAOException {
        
        return dao.removeSnack(snack);
    }

    @Override
    public BigDecimal changeCalculion(String cash, String price) throws VendingMachineDAOException {
        BigDecimal money = new BigDecimal(cash);
        BigDecimal snackPrice = new BigDecimal(price);
        if (money.compareTo(snackPrice) == 1) {

            return money.subtract(snackPrice);
        } else if (money.compareTo(snackPrice) == 0) {

            return BigDecimal.ZERO;
        } else if (money.compareTo(snackPrice) == -1) {

            return money.subtract(snackPrice);
        }

        return money;
    }

    @Override
    public List<Integer> coinCalculation(BigDecimal change) throws VendingMachineDAOException {
        List<Integer> coinCalculation = new ArrayList<>();
        BigDecimal zero = new BigDecimal("0.00");
        BigDecimal quarter = new BigDecimal(".25");
        BigDecimal dime = new BigDecimal(".10");
        BigDecimal nickel = new BigDecimal(".05");
        BigDecimal penny = new BigDecimal(".01");

        int quarterCounter = 0;
        int dimeCounter = 0;
        int nickelCounter = 0;
        int pennyCounter = 0;

        while (change.compareTo(zero) == 1) {
            if (change.compareTo(quarter) == 1 || change.compareTo(quarter) == 0) {
                change = change.subtract(quarter);
                quarterCounter++;
            } else if (change.compareTo(dime) == 1 || change.compareTo(dime) == 0) {
                change = change.subtract(dime);
                dimeCounter++;
            } else if (change.compareTo(nickel) == 1 || change.compareTo(nickel) == 0) {
                change = change.subtract(nickel);
                nickelCounter++;
            } else if (change.compareTo(penny) == 1 || change.compareTo(penny) == 0) {
                change = change.subtract(penny);
                pennyCounter++;
            }
        }
        coinCalculation.add(quarterCounter);
        coinCalculation.add(dimeCounter);
        coinCalculation.add(nickelCounter);
        coinCalculation.add(pennyCounter);

        return coinCalculation;
    }
}
