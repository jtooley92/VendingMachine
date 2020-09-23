/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDAOException;
import com.sg.vendingmachine.dto.Snack;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Jtooleyful
 */
public interface VendingMachineService {
    List<Snack> getAllSnacks() throws VendingMachineDAOException;
    Snack getSnack(String name) throws VendingMachineDAOException;
    Snack removeSnack(Snack snack) throws VendingMachineDAOException;
    BigDecimal changeCalculion (String cash, String price) throws VendingMachineDAOException;
    List<Integer> coinCalculation(BigDecimal change) throws VendingMachineDAOException;
}
