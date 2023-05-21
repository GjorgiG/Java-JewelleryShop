package com.example.assign1;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.text.View;
import java.awt.event.ActionEvent;

public class ViewAllController {

    @FXML
    public TextField search;


    public void initialize() {
        controller = this;
    }

    public static ViewAllController controller;


    public ListView mats;

    public ListView<JewelleryItem> jwls;



    public void Home(){
        HelloApplication.primaryStage.setScene(HelloApplication.scene1);
    }

    public void updateViewAll() {
        mats.getItems().clear();
        Material temp = HelloApplication.headMaterial;
        while (temp != null) {
            mats.getItems().add(temp);
            temp = temp.next;
        }
    }



    public void searchAll(javafx.event.ActionEvent actionEvent) {
        DisplayCase tempDC = DisplayCase.firstCase;
        while (tempDC != null){
            DisplayTray tempDt = tempDC.firstTray;
            while (tempDt != null){
                JewelleryItem ji = tempDt.firstJI;
                while (ji != null){
                    if(ji.getDescription().contains(search.getText()))
                        mats.getItems().add(String.valueOf(ji));
                    ji = ji.next;
                }
                tempDt = tempDt.next;
            }
            tempDC = tempDC.next;
        }
    }
}
