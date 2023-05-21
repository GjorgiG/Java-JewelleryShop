package com.example.assign1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class HelloController implements Initializable {


public static HelloController controller;


    public void Scene2(){
        HelloApplication.primaryStage.setScene(HelloApplication.scene2);
    }


    public void Scene3()
    {
        HelloApplication.primaryStage.setScene(HelloApplication.scene3);
        DisplayTrayController.controller.updateCasesChoiceBox();
    }

    public void Scene4(){
        HelloApplication.primaryStage.setScene(HelloApplication.scene4);
        JewelleryItemController.controller.updateListView();
    }

    public void Scene5(){
        HelloApplication.primaryStage.setScene(HelloApplication.scene5);
        MaterialController.controller.updateMaterialView();
    }


    public void initialize(URL url, ResourceBundle resourceBundle){
        controller = this;
    }

    public void reset(ActionEvent actionEvent) { //this makes all the heads = null so resets the entire list

        System.out.println("Resetting system....");
        HelloApplication.headCase = null;
        HelloApplication.headTray = null;
        HelloApplication.headItem = null;
        HelloApplication.headMaterial = null;


        if (DisplayCaseController.controller.listName != null) {
            DisplayCaseController.controller.listName.getItems().clear();
        }

        System.out.println("Reset System!");
    }
}

