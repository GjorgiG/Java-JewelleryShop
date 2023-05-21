package com.example.assign1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class DisplayCaseController implements Initializable {

    public static DisplayCaseController controller;

    public ListView listName;
    @FXML
    TextField txtNum;

    @FXML
    CheckBox lighting, mounted;

    public void Home(){
        HelloApplication.primaryStage.setScene(HelloApplication.scene1);
    }


    public void AddDisplayCase() throws Exception {
        DisplayCase dc = new DisplayCase();
        int thenum = Integer.parseInt(txtNum.getText());
        dc.caseNumber=thenum;
        dc.lighting = lighting.isSelected();
        dc.mounted = mounted.isSelected();

        //add to linked list

        dc.next = HelloApplication.headCase;
        HelloApplication.headCase = dc;
        System.out.println(HelloApplication.headCase);

        HelloApplication.saveAll();
        HelloApplication.displayAllDisplayCasesToConsole();
        HelloApplication.displayAllDisplayCasesToList(listName);
    }

    public void DeleteDisplayCase(ActionEvent actionEvent) {
        int index = listName.getSelectionModel().getSelectedIndex();
        HelloApplication.deleteDisplayCase(index);
        listName.getItems().clear();
        HelloApplication.displayAllDisplayCasesToList(listName);
    }

    //makes head = null, deletes entire list
    public void ClearDisplayCase(ActionEvent actionEvent){
        HelloApplication.headCase = null;
        listName.getItems().clear();
    }

//    public void saveCase() throws Exception {
////        XStream xstream = new XStream(new DomDriver());
////        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("cases.xml"));
//        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(caseFileName())));
//        out.writeObject(listName);
//        out.close();
//
//    }
//
//    @SuppressWarnings("unchecked")
//    public void loadCase() throws Exception {
//
////        Class<?>[] classes = new Class[]{DisplayCase.class};
////
////
////        XStream xstream = new XStream(new DomDriver());
////        XStream.setupDefaultSecurity(xstream);
////        xstream.allowTypes(classes);
////
////
////        ObjectInputStream in = xstream.createObjectInputStream(new FileReader("cases.xml"));
//        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(caseFileName())));        listName = (ListView) in.readObject();
//        in.close();
//    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        controller = this;
    }

//    public String caseFileName(){
//        return "cases.dat";
//    }

}
