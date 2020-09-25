/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

import com.sg.vendingmachine.dao.InsufficientFundsException;
import com.sg.vendingmachine.dao.NoItemInventoryException;
import com.sg.vendingmachine.dao.VendingMachineAuditDAO;
import com.sg.vendingmachine.dao.VendingMachineAuditDAOMock;
import com.sg.vendingmachine.dao.VendingMachineDAO;
import com.sg.vendingmachine.dao.VendingMachineDAOException;
import com.sg.vendingmachine.dao.VendingMachineDAOFileImpl;
import com.sg.vendingmachine.dao.VendingMachineDAOMock;
import com.sg.vendingmachine.dto.Snack;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jtooleyful
 */
public class VendingMachineServiceImplIT {

    VendingMachineDAO daoMock = new VendingMachineDAOMock();
    VendingMachineAuditDAO auditMock = new VendingMachineAuditDAOMock();
    VendingMachineService testService = new VendingMachineServiceImpl(daoMock, auditMock);

    public VendingMachineServiceImplIT() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testRemoveException() throws VendingMachineDAOException, NoItemInventoryException {

        Snack fakeRemove = new Snack("twizzlers");
        fakeRemove.setInventory(-1);
        Snack testSnack = new Snack("twizzlers");

        
            try {
                testSnack = testService.removeSnack(fakeRemove);
                fail();
            } catch (NoItemInventoryException e) {
                //will pass if error is caught
            }

    assertEquals(testSnack.getInventory(), 0, "Expected inventory to reset to 0");
    }
    
    @Test
    public void testChangeCalculationOverPrice() throws VendingMachineDAOException, InsufficientFundsException {
        String cash = "2.50";
        String price = "2.00";

        testService.changeCalculion(cash, price);
        
        assertEquals(testService.changeCalculion(cash, price), new BigDecimal(".50"), "Expected to return 50 cents as change");
    }
    
    @Test
    public void testChangeCalculationAtPrice() throws VendingMachineDAOException, InsufficientFundsException {
        String cash = "2.00";
        String price = "2.00";

        testService.changeCalculion(cash, price);
        
        assertEquals(testService.changeCalculion(cash, price), BigDecimal.ZERO, "Expected to return no change");
    }
    
    @Test
    public void testChangeCalculationUnderPrice() throws VendingMachineDAOException, InsufficientFundsException {
        String cash = "1.50";
        String price = "2.00";

        try{
        testService.changeCalculion(cash, price);
        fail();
        }catch(InsufficientFundsException e){
            
        }
        
    }
    
    @Test
    public void testcoinCalculation() throws VendingMachineDAOException {
        BigDecimal change = new BigDecimal(".41");
        
        List coins = testService.coinCalculation(change);
        
        assertEquals(coins.size(), 4, "Expected 4 items in list");
        assertEquals(coins.get(0), 1, "Expected 1 quarter");
        assertEquals(coins.get(1), 1, "Expected 1 dime");
        assertEquals(coins.get(2), 1, "Expected 1 nickel");
        assertEquals(coins.get(3), 1, "Expected 1 penny");
    }
    
    
}
