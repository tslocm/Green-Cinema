package com.green.cinemamanagement;

import com.green.cinemamanagement.dao.StaffDAO;
import com.green.cinemamanagement.dbhelper.DBManager;
import com.green.cinemamanagement.entity.Staff;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory viewFactory = new ViewFactory();
//        DBManager dbManager=new DBManager();
//        dbManager.getDBManager();

//        StaffDAO s=new StaffDAO();
//        s.insertStaff(new Staff("LocM", "Nam","HCM", "022222222"));
        //viewFactory.showLoginWindow();
        //viewFactory.showLoginWindow();
        viewFactory.showStaftWindow();
//        UserDAO userDAO=new UserDAO();
//        userDAO.getAllUser();
    }
}
