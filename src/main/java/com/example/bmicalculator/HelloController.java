package com.example.bmicalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label errorMessage;
    @FXML
    private Label valueOutput;
    @FXML
    private Label statusOutput;
    @FXML
    private TextField massInput;
    @FXML
    private TextField heightInput;

    int height, mass, BMIValue;

    @FXML
    public void submit(){
    try {
        height = Integer.parseInt(heightInput.getText());
        mass = Integer.parseInt(massInput.getText());

    }
    catch(NumberFormatException e){
        errorMessage.setText("write only numbers!!!");
    }
    }
}