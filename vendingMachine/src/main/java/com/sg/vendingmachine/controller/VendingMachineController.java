/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.controller;

import com.sg.vendingmachine.dao.VendingMachineDAO;
import com.sg.vendingmachine.dao.VendingMachineDAOException;
import com.sg.vendingmachine.dao.VendingMachineDAOFileImpl;
import com.sg.vendingmachine.dto.Snack;
import com.sg.vendingmachine.service.VendingMachineService;
import com.sg.vendingmachine.ui.UserIO;
import com.sg.vendingmachine.ui.UserIOConsoleImpl;
import com.sg.vendingmachine.ui.VendingMachineView;
import java.util.List;

/**
 *
 * @author Jtooleyful
 */
public class VendingMachineController {

    public VendingMachineController(VendingMachineView view, VendingMachineService service) {
        this.service = service;
        this.view = view;
    }

    private VendingMachineService service;
    private VendingMachineView view;
    private UserIO io = new UserIOConsoleImpl();

    public void run() throws VendingMachineDAOException {
        boolean keepGoing = true;
        int menuSelection = 0;
             listSnacks();
             userSnack();
             userCash();
             exitMessage();
    }


    private void listSnacks() throws VendingMachineDAOException {
        view.displayAllSnacksBanner();
        List<Snack> snackList = service.getAllSnacks();
        view.displaySnackList(snackList);
    }
    
    private void userSnack() throws VendingMachineDAOException {
        view.getUserSnack();
    }
    
    private void userCash() throws VendingMachineDAOException {
        view.getUserCash();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
