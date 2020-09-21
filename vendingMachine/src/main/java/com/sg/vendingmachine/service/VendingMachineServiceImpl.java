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
import java.util.List;

/**
 *
 * @author Jtooleyful
 */
public class VendingMachineServiceImpl implements VendingMachineService{
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
    public Snack removeSnack(String name, Snack snack) throws VendingMachineDAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
