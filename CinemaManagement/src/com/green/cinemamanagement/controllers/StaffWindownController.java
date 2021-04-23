package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.dao.StaffDAO;
import com.green.cinemamanagement.entity.Staff;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class StaffWindownController extends BaseController implements Initializable, AddStaffWindowController.AddStaffDelegate {

    private ObservableList<Staff> data = FXCollections.observableArrayList();
    private ArrayList<Staff> listStaff;
    private StaffDAO staftDAO;
    private int currentIndex = 0, index = 0;

    @FXML
    private Button buttonBack;

    @FXML
    private TableView<Staff> tablePanel;


    @FXML
    private TableColumn<Staff, String> Column_Gender;

    @FXML
    private TableColumn<Staff, Integer> id_Staft;

    @FXML
    private TableColumn<Staff, String> id_StaftName;

    @FXML
    private TableColumn<Staff, String> id_StaftAddress;

    @FXML
    private TableColumn<Staff, String> id_StaftPhone;

    @FXML
    private Button button_Xoa;

    @FXML
    void button_Xoa(ActionEvent event) {
        if (index == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Canh bao");
            alert.setHeaderText(null);
            alert.setContentText("Please select a row to delete!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Chu y!");
            alert.setHeaderText(null);
            alert.setContentText("Ban co chac chan muon xoa khong?");

            ButtonType btn_OK = new ButtonType("OK");
            ButtonType btn_CANCLE = new ButtonType("CANCLE");

            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(btn_OK, btn_CANCLE);

            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.get() == null) {
                System.out.println("No selection!");
            } else if (buttonType.get() == btn_OK) {
                System.out.println("Row dang chon : " + currentIndex);
                listStaff.remove(currentIndex);
                System.out.println("Deleted!");
            } else if (buttonType.get() == btn_CANCLE) {
                System.out.println("hihihi!");
            } else {
                System.out.println("Ban chon X!");
            }

        }
    }

    @FXML
    private Button button_CapNhat;

    @FXML
    void button_CapNhat(ActionEvent event) {
        update();
    }

    @FXML
    void button_Thoat(ActionEvent event) {

    }

    @FXML
    private Button button_Them;

    @FXML
    void Button_Them(ActionEvent event) {
        viewFactory.showAddStaffWindow();
    }

    public StaffWindownController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tablePanel.setEditable(true);
        initColumnName();
        initListStaff();
        uploadStaffOnTableView();
        EditDataOnTable();
        index = 0;

        //currentIndex = tablePanel.getSelectionModel().getSelectedIndex();
        tablePanel.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
            @Override
            public void onChanged(Change<? extends Integer> newValue) {
                System.out.println("Selected indices : " + newValue);
                if (newValue != null) {
                    int selectIndex = tablePanel.getSelectionModel().getSelectedIndex();
                    currentIndex = selectIndex;
                    System.out.println("Row : " + currentIndex);
                    index = 1;
                }

            }
        });

//        data.addListener(new ListChangeListener<Staff>() {
//            @Override
//            public void onChanged(Change<? extends Staff> change) {
//                tablePanel.setItems(data);
//                if (!listStaff.isEmpty()){
//                    System.out.println("list staff size = " + listStaff.size());
//                    System.out.println("data size = " + listStaff.size());
//                    tablePanel.getSelectionModel().select(listStaff.size() - 1);
//                    currentIndex = tablePanel.getSelectionModel().getSelectedIndex();
//                    System.out.println("current index =" + currentIndex);
//
//                }
//                else {
//                    currentIndex = 0;
//
//                }
//                System.out.println("select last = " + currentIndex);
//            }
//        });
    }

    private void initColumnName() {
        id_Staft.setCellValueFactory(new PropertyValueFactory<>("id"));

        id_StaftName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        id_StaftName.setCellFactory(TextFieldTableCell.<Staff> forTableColumn());

//        ObservableList<Gender> genderList = FXCollections.observableArrayList(//
//                Gender.values());
//        List<String> genderList=new ArrayList<>();
        Column_Gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        Column_Gender.setCellFactory(ComboBoxTableCell.forTableColumn("Male","Female"));

        id_StaftAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        id_StaftPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));


    }

    private void initListStaff() {
        // hien thi cac dong du lieu
        staftDAO = new StaffDAO();
        listStaff = staftDAO.getAllStaff();
    }

    public void uploadStaffOnTableView() {
        data.setAll(listStaff);
        tablePanel.setItems(data);
        tablePanel.getSelectionModel().selectLast();
    }

    public void update() {
        initListStaff();
        uploadStaffOnTableView();
    }

    public void Close() {
        Stage stage = (Stage) buttonBack.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    public void EditDataOnTable() {
        id_StaftName.setOnEditCommit((TableColumn.CellEditEvent<Staff, String> event) -> {
            TablePosition<Staff, String> pos = event.getTablePosition();
            String newFullName = event.getNewValue();
            int row = pos.getRow();
            Staff s = event.getTableView().getItems().get(row);
            s.setFullName(newFullName);
        });
    }

    @Override
    public void onStaffAdd() {
        AddStaffWindowController.AddStaffDelegate delegate=this;

        update();
        System.out.println("Da update");
    }
}
