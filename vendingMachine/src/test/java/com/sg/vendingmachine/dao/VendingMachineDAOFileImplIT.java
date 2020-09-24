/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

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
public class VendingMachineDAOFileImplIT {

    VendingMachineDAO newTestDAO;

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        String newTestFile = "VendingMachineUnitTest.txt";
        FileWriter fw = new FileWriter(newTestFile);
        fw.append("twizzlers::2.00::6");
        fw.flush();
        fw.close();
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

        List<Snack> snacksList = newTestDAO.getAllSnacks();
        Snack newSnack = new Snack("twizzlers", new BigDecimal("2.00"), 6);

        assertEquals(snacksList.size(), 1, "Expected list to contain 1 item");
        assertEquals(snacksList.contains(newSnack), true, "Expected list to contain snack");

    }

    @Test
    public void testRemoveSnack() throws Exception {
        Snack snaack = new Snack("twizzlers", new BigDecimal("2.00"), 6);
        Snack removedSnack = newTestDAO.removeSnack(snaack);

        int removedSnackInventory = removedSnack.getInventory();
        int newSnack = (newTestDAO.getSnack("twizzlers").getInventory() -1);

        assertEquals(removedSnackInventory, newSnack, "Expected inventory to decrease by 1");

    }
}
