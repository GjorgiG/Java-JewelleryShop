package com.example.assign1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MaterialController {
    @FXML
    TextField txtNum;

    @FXML
    TextField txtNum2;

    @FXML
    TextField txtDesc;

    public ChoiceBox<String> matType;

    public ListView listName4;

    public ListView<JewelleryItem> jwls;

    public static MaterialController controller;

    public void Home(){
        HelloApplication.primaryStage.setScene(HelloApplication.scene1);
    }

    public void addMaterial(){
        Material mat = new Material();
        int thenum = Integer.parseInt(txtNum.getText());
        int thenum2 = Integer.parseInt(txtNum2.getText());
        String description = txtDesc.getText();
        mat.description = description;
        mat.type = matType.getSelectionModel().getSelectedItem();
        mat.amount = thenum;
        mat.quality = thenum2;
        JewelleryItem ji = jwls.getSelectionModel().getSelectedItem();
        mat.theItem = ji;

        //add to linked list

        mat.next = HelloApplication.headMaterial;
        HelloApplication.headMaterial = mat;
        System.out.println(HelloApplication.headMaterial);

        HelloApplication.displayAllMaterialsToConsole();
        HelloApplication.displayAllMaterialsToList(listName4);
    }

    public void deleteMaterial(ActionEvent actionEvent) {
        int index = listName4.getSelectionModel().getSelectedIndex();
        HelloApplication.deleteMaterial(index);
        listName4.getItems().clear();
        HelloApplication.displayAllMaterialsToList(listName4);
    }

    //makes head = null, deletes entire list
    public void clearMaterial(ActionEvent actionEvent){
        HelloApplication.headMaterial = null;
        listName4.getItems().clear();
    }

    public void updateMaterialView() {
        jwls.getItems().clear();
        JewelleryItem temp = HelloApplication.headItem;
        while (temp != null) {
            jwls.getItems().add(temp);
            temp = temp.next;
        }
    }

    public void initialize() {
     controller = this;
    }

}
