/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import com.sg.vendingmachine.dto.Snack;
import java.io.FileReader;
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
public class VendingMachineDAOFileImplIT {
    VendingMachineDAO newTestDAO;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception{
        String newTestFile = "VendingMachineUnitTest.txt";
        new FileReader(newTestFile);
        newTestDAO = new VendingMachineDAOFileImpl(newTestFile);
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetSnack() throws Exception {
        Snack newSnack = new Snack("twizzlers", new BigDecimal("2.00"), 6);
        
        Snack gotSnack = newTestDAO.getSnack("twizzlers");
        
        assertEquals(gotSnack, newSnack, "Expected to retrieve snack named");
        
    }
    
    @Test
    public void testGetAllSnack() throws Exception {
       Map<String, Snack> snack = new HashMap<>();
       List<Snack> newsnacksList = new ArrayList(snack.values());
        
        List<Snack> snacksList = newTestDAO.getAllSnacks();
        
        assertEquals(snacksList, newsnacksList, "Expected to retrieve snack list from file");
        
        
    }
}
