/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.VendingMachineDAOException;
import com.sg.vendingmachine.dto.Snack;
import java.util.List;

/**
 *
 * @author Jtooleyful
 */
public interface VendingMachineService {
    List<Snack> getAllSnacks() throws VendingMachineDAOException;
    Snack getSnack(String name) throws VendingMachineDAOException;
    Snack removeSnack(String name, Snack snack) throws VendingMachineDAOException;
    
}
