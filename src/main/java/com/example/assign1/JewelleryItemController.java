package com.example.assign1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.controlsfx.control.ListActionView;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class JewelleryItemController implements Initializable {

    public ListView<DisplayTray> trays;

    public static JewelleryItemController controller;

    public ChoiceBox<String> jitype;

    public ListView listName3;

    @FXML
    TextField txtNum;

    @FXML
    TextField txtDesc;

    @FXML
    CheckBox male, female;

    public void Home() {
        HelloApplication.primaryStage.setScene(HelloApplication.scene1);
    }

    public void scene6() { //this loads up view all screen
        HelloApplication.primaryStage.setScene(HelloApplication.scene6);
        ViewAllController.controller.updateViewAll();
    }


    public void AddJewelleryItem() { //this creates a jewellery item
        JewelleryItem ji = new JewelleryItem();
        int thenum = Integer.parseInt(txtNum.getText());
        String theDesc = txtDesc.getText();
        ji.description = theDesc;
        ji.retailPrice = thenum;
        ji.male = male.isSelected();
        ji.female = female.isSelected();
        DisplayTray dt = trays.getSelectionModel().getSelectedItem();
        ji.type = jitype.getSelectionModel().getSelectedItem();
        ji.theTray = dt;


        //add to linked list

        ji.next = HelloApplication.headItem;
        HelloApplication.headItem = ji;
        System.out.println(HelloApplication.headItem);

        HelloApplication.saveAll();
        HelloApplication.displayAllJewelleryItemsToConsole();
        HelloApplication.displayAllJewelleryItemsToList(listName3);
    }

    public void DeleteJewelleryItem(ActionEvent actionEvent) {
        int index = listName3.getSelectionModel().getSelectedIndex();
        HelloApplication.deleteJewelleryItem(index);
        listName3.getItems().clear();
        HelloApplication.displayAllJewelleryItemsToList(listName3);
    }

    public void clearJewelleryItem(ActionEvent actionEvent) {
        HelloApplication.headItem = null;
        listName3.getItems().clear();
    }

    public void initialize() {
        controller=this;
    }

    public void updateListView() {
        trays.getItems().clear();
        DisplayTray temp = HelloApplication.headTray;
        while (temp != null) {
            trays.getItems().add(temp);
            temp = temp.next;
        }
    }




    public void initialize(URL url, ResourceBundle resourceBundle){
        controller = this;

        jitype.getItems().toString();
    }
}
