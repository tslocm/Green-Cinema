package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.dao.UserDAO;
import com.green.cinemamanagement.entity.User;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginWindowController extends BaseController {
    private UserDAO userDAO;
    private ArrayList<User> listUser;
    @FXML
    private AnchorPane panelLogin;

    @FXML
    private Button buttonLogin;

    @FXML
    private TextField tfEmailAddress;

    @FXML
    private TextField tfPassword;

    @FXML
    private Label lbError;

    public LoginWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void loginButtonAction(ActionEvent event) {
        String email = tfEmailAddress.getText();
        String pass = tfPassword.getText();

        userDAO = new UserDAO();
        listUser = new ArrayList<>();
        listUser = userDAO.getAllUser();

        for (int i = 0; i < listUser.size(); i++) {
            if (!email.equals(listUser.get(i).getEmail()) || !pass.equals(listUser.get(i).getPassword())) {
                lbError.setText("Email or password invalid !!!");

            }else{
                viewFactory.showMainWindow();
                closeLogin();

            }
        }


    }

    public void closeLogin(){
        Stage stage = (Stage) buttonLogin.getScene().getWindow();
        viewFactory.closeStage(stage);
    }
}
