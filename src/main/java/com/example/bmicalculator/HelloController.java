package com.example.bmicalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {


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
    @FXML
    private ChoiceBox<String> myChoiceBox;

    private String[] systems= {"metric","imperial"};
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(systems);
    }

    double height, mass;
    double BMIValue;

    @FXML
    public void submit(){
    try {
        height = Integer.parseInt(heightInput.getText());
        mass = Integer.parseInt(massInput.getText());
        String chbx = myChoiceBox.getValue();

        if(systems[0].equals(chbx)) {
            height = height / 100;
            height = height * height;
            BMIValue = mass / height;
            valueOutput.setText(String.valueOf(BMIValue));
        }
        else{
            height = height * height;
            BMIValue = mass / height;
            BMIValue = BMIValue * 703;
            valueOutput.setText(String.valueOf(BMIValue));
        }
        if(BMIValue<18.5)
            statusOutput.setText("Underweight");
        if(BMIValue>18.5&&BMIValue<24.5)
            statusOutput.setText("Normal");
        if(BMIValue>24.5&&BMIValue<29.5)
            statusOutput.setText("Overweight");
        if(BMIValue>29.5)
            statusOutput.setText("Obese");
    }
    catch(NumberFormatException e){
        errorMessage.setText("write only numbers!!!");
    }
    }
}