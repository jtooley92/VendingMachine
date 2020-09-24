/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Snack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jtooleyful
 */
public class VendingMachineDAOMock implements VendingMachineDAO{

    @Override
    public List<Snack> getAllSnacks() throws VendingMachineDAOException {
    Map<String, Snack> snacks = new HashMap<>();
        return new ArrayList (snacks.values());
    }

    @Override
    public Snack getSnack(String name) throws VendingMachineDAOException {
        Snack nothing = new Snack("nun");
        return nothing;
    }

    @Override
    public Snack removeSnack(Snack snack) throws VendingMachineDAOException {
        Snack nothing = new Snack("nun");
        return nothing;
    }
    
}
