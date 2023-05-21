package com.example.assign1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class DisplayTrayController {

    public static DisplayTrayController controller;

    public ListView listName2;

    @FXML
    TextField txtNum;

    @FXML
    TextField txtColour;

    @FXML
    TextField txtDimension;

    public ChoiceBox<DisplayCase> cases;

    public void initialize() {
        controller=this;
    }


    public void Home(){
        HelloApplication.primaryStage.setScene(HelloApplication.scene1);
    }

    public void updateCasesChoiceBox() {
        cases.getItems().clear();
        DisplayCase temp = HelloApplication.headCase;
        while(temp!=null) {
            cases.getItems().add(temp);
            temp=temp.next;
        }
    }

    public void AddDisplayTray()
    {
        DisplayTray dt = new DisplayTray();
        int thenum = Integer.parseInt(txtNum.getText());
        String txt = txtColour.getText();
        int dimension = Integer.parseInt(txtDimension.getText());
        dt.trayNumber = thenum;
        dt.inlayColour = txt;
        dt.dimensions = dimension;


        DisplayCase dc = cases.getSelectionModel().getSelectedItem();
        dt.theCase=dc;

        //this adds the disply tray to the linked list

        dt.next = HelloApplication.headTray;
        HelloApplication.headTray = dt;
        System.out.println(HelloApplication.headTray);

        HelloApplication.saveAll();
        HelloApplication.displayAllDisplayTraysToConsole();
        HelloApplication.displayAllDisplayTraysToList(listName2);
    }

    public void DeleteDisplayTray(ActionEvent actionEvent) {
        int index = listName2.getSelectionModel().getSelectedIndex();
        HelloApplication.deleteDisplayTray(index);
        listName2.getItems().clear();
        HelloApplication.displayAllDisplayTraysToList(listName2);
    }

    //makes head = null, deletes entire list
    public void ClearDisplayTray(ActionEvent actionEvent) {
        HelloApplication.headTray = null;
        listName2.getItems().clear();
    }

//    public void saveTray() throws Exception {
////        XStream xstream = new XStream(new DomDriver());
////        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("trays.xml"));
//        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(trayFileName())));
//        out.writeObject(listName2);
//        out.close();
//    }


//    public void loadTray() throws Exception {
//
////        Class<?>[] classes = new Class[]{DisplayTray.class};
////
////
////        XStream xstream = new XStream(new DomDriver());
////        XStream.setupDefaultSecurity(xstream);
////        xstream.allowTypes(classes);
////
////
////        ObjectInputStream in = xstream.createObjectInputStream(new FileReader("trays.xml"));
//        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(trayFileName())));        listName2 = (ListView) in.readObject();
//        in.close();
//    }


}
