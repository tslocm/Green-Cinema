package com.green.cinemamanagement.controllers;

import com.green.cinemamanagement.emum.ColorTheme;
import com.green.cinemamanagement.emum.FontSize;
import com.green.cinemamanagement.views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionWindowController extends BaseController implements Initializable {

    private final String TAG = "OptionWindowController";

    public OptionWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private Slider sliderFontSize;

    @FXML
    private ChoiceBox<ColorTheme> cboxColorTheme;

    @FXML
    private Button buttonCancel;

    @FXML
    private Button buttonApply;

    @FXML
    void applyAction(ActionEvent event) {
        System.out.println(TAG + "applyAction");
        closeStage();
    }

    @FXML
    void cancelAction(ActionEvent event) {
        System.out.println(TAG + "cancelAction");
        closeStage();
    }

    private void closeStage() {
        Stage stage = (Stage) buttonApply.getScene().getWindow();
        viewFactory.closeStage(stage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initSliderFontSize();
        initChoiceBoxTheme();
    }

    private void initSliderFontSize() {
        sliderFontSize.setMin(0);
        sliderFontSize.setMax(FontSize.values().length - 1);
        sliderFontSize.setValue(viewFactory.getFontSize().ordinal());
        sliderFontSize.setMajorTickUnit(1);
        sliderFontSize.setMinorTickCount(0);
        sliderFontSize.setBlockIncrement(1);
        sliderFontSize.setSnapToTicks(true);
        sliderFontSize.setShowTickLabels(true);
        sliderFontSize.setShowTickMarks(true);
        sliderFontSize.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double aDouble) {
                int i = aDouble.intValue();
                return FontSize.values()[i].toString();
            }

            @Override
            public Double fromString(String s) {
                return null;
            }
        });
    }

    private void initChoiceBoxTheme() {
        cboxColorTheme.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        cboxColorTheme.setValue(viewFactory.getColorTheme());
    }
}
