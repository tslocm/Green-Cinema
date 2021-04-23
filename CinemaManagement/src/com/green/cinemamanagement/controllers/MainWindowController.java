package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.views.ViewFactory;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class MainWindowController extends BaseController{

    private String TAG = "MainWindowController";

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void menuOptionAction(ActionEvent event) {
        System.out.println(TAG + "::menuOptionAction()");
        viewFactory.showOptionWindow();
    }

    @FXML
    void menuStaftAction(ActionEvent event) {
        System.out.println(TAG + ":menuStaft");
        viewFactory.showStaftWindow();
    }

    public void clickExit(){


    }
}
