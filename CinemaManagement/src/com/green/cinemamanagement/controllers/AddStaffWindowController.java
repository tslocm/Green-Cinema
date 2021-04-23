package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.dao.StaffDAO;
import com.green.cinemamanagement.entity.Staff;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddStaffWindowController extends BaseController implements Initializable {

    public interface AddStaffDelegate{
        void onStaffAdd();
    }

    private String name,address,phone,gender;
    private StaffDAO staffDAO=new StaffDAO();

    public void setListener(AddStaffDelegate listener) {
        this.listener = listener;
    }

    private AddStaffDelegate listener;


    @FXML
    private TextField TextField_StaftName;

    @FXML
    private RadioButton radio_Male;

    @FXML
    private ToggleGroup radioButton;

    @FXML
    private RadioButton radio_Female;

    @FXML
    private TextField TextField_Address;

    @FXML
    private TextField TextField_Phone;

    @FXML
    private Button button_Them;

    @FXML
    private Button button_XoaRong;

    @FXML
    private Button button_Thoat;

    @FXML
    void button_Thoat(ActionEvent event) {
        Close();
    }

    @FXML
    void button_XoaRong(ActionEvent event) {
        TextField_StaftName.clear();
        TextField_Address.clear();
        TextField_Phone.clear();
    }

    @FXML
    void button_Them(ActionEvent event) {
        getAllTextField();
        Staff staff=new Staff(name,gender,address,phone);
        staffDAO.insertStaff(staff);
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        DialogPane dialogPane=alert.getDialogPane();
        alert.setTitle("Thông báo!");
        alert.setHeaderText(null);
        alert.setContentText("Thêm thành công!");
        alert.show();

        if(listener!=null){
            listener.onStaffAdd();
        }
        Close();
//        viewFactory.showStaftWindow();
    }

    public AddStaffWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void getAllTextField(){
        name= TextField_StaftName.getText();
        int gt;
        if(radio_Male.isSelected()){
            gt=0;
            gender="Male";
        }else{
            gt=1;
            gender="Female";
        }

        address=TextField_Address.getText();
        phone=TextField_Phone.getText();
    }

    public void Close(){
        Stage stage= (Stage) button_Thoat.getScene().getWindow();
        viewFactory.closeStage(stage);
    }
}
