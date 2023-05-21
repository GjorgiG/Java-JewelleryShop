package com.example.assign1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class HelloApplication extends Application implements Serializable {
    public static DisplayCase headCase = null;
    public static Scene scene1, scene2, scene3, scene4, scene5, scene6;
    public static Stage primaryStage;
    public static DisplayTray headTray = null;
    public static JewelleryItem headItem = null;
    public static Material headMaterial = null;


// these methods display the all items to the console and to each list
        public static void displayAllDisplayCasesToList (ListView listName){
            listName.getItems().clear();
            DisplayCase temp = HelloApplication.headCase;
            System.out.println("\nList of Display Cases\n==================");
            while (temp != null) {
                listName.getItems().add(temp);
                temp = temp.next;
            }
        }


        public static void displayAllDisplayTraysToList (ListView listName2){
            listName2.getItems().clear();
            DisplayTray temp = HelloApplication.headTray;
            System.out.println("\nList of Display Trays\n==================");
            while (temp != null) {
                listName2.getItems().add(temp);
                temp = temp.next;
            }
        }

        public static void displayAllJewelleryItemsToList (ListView listName3){
            listName3.getItems().clear();
            JewelleryItem temp = HelloApplication.headItem;
            System.out.println("\nList of Jewellery Items\n==================");
            while (temp != null) {
                listName3.getItems().add(temp);
                temp = temp.next;
            }
        }

        public static void displayAllJewelleryItemsToConsole () {
            JewelleryItem temp = HelloApplication.headItem;
            System.out.println("\nList of Jewellery Items\n==================");
            while (temp != null) {
                System.out.println(temp);
                temp = temp.next;
            }
        }

        public static void displayAllDisplayTraysToConsole () {
            DisplayTray temp = HelloApplication.headTray;
            System.out.println("\nList of Display Trays\n==================");
            while (temp != null) {
                System.out.println(temp);
                temp = temp.next;
            }
        }

        @Override
        public void start (Stage stage) throws IOException {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            scene1 = new Scene(fxmlLoader.load(), 300, 300);
            stage.setTitle("Hello!");
            stage.setScene(scene1);
            stage.show();
            primaryStage = stage;



            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("displaycase.fxml"));
            scene2 = new Scene(fxmlLoader.load(), 700, 450);
            stage.setTitle("Display Cases");
            stage.setScene(scene1);
            stage.show();
            primaryStage = stage;

            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("displaytray.fxml"));
            scene3 = new Scene(fxmlLoader.load(), 700, 430);
            stage.setTitle("Display Trays");
            stage.setScene(scene1);
            stage.show();
            primaryStage = stage;

            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("jewelleryitem.fxml"));
            scene4 = new Scene(fxmlLoader.load(), 601, 430);
            stage.setTitle("Jewellery Item");
            stage.setScene(scene1);
            stage.show();
            primaryStage = stage;

            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("material.fxml"));
            scene5 = new Scene(fxmlLoader.load(), 601, 430);
            stage.setTitle("Material");
            stage.setScene(scene1);
            stage.show();
            primaryStage = stage;

            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("viewall.fxml"));
            scene6 = new Scene(fxmlLoader.load(), 601, 430);
            stage.setTitle("View all");
            stage.setScene(scene1);
            stage.show();
            primaryStage = stage;

            try {
                load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void displayAllDisplayCasesToConsole() {
        DisplayCase temp=HelloApplication.headCase;
        System.out.println("\nList of Display Cases\n==================");
        while(temp!=null) {
            System.out.println(temp);
            temp=temp.next;
        }
    }

    public static void deleteDisplayCase(int index) //these methods delete items by taking in the index
    {
        if(index == 0){
            headCase=headCase.next;
        }
        else{
            DisplayCase temp = headCase;
            for(int i =1;i<index-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
    }

    public static void deleteDisplayTray(int index)
    {
        if(index == 0){
            headTray=headTray.next;
        }
        else{
            DisplayTray temp = headTray;
            for(int i =1;i<index-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
    }

    public static void deleteJewelleryItem(int index)
    {
        if(index == 0){
            headItem=headItem.next;
        }
        else{
            JewelleryItem temp = headItem;
            for(int i =1;i<index-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
    }

    public static void deleteMaterial(int index)
    {
        if(index == 0){
            headMaterial=headMaterial.next;
        }
        else{
            Material temp = headMaterial;
            for(int i =1;i<index-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
    }

    public static void displayAllMaterialsToConsole() {
        Material temp=HelloApplication.headMaterial;
        System.out.println("\nList of Materials\n==================");
        while(temp!=null) {
            System.out.println(temp);
            temp=temp.next;
        }
    }

    public static void displayAllMaterialsToList(ListView listName4) {
        listName4.getItems().clear();
        Material temp=HelloApplication.headMaterial;
        System.out.println("\nList of Materials\n==================");
        while(temp!=null) {
            listName4.getItems().add(temp);
            temp=temp.next;
        }
    }




    public static void main(String[] args) {
        launch();
    }

    public static void saveAll(){
        try {
            save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static void load() throws Exception
    {
        Class<?>[] classes = new Class[] {DisplayCase.class,DisplayTray.class, JewelleryItem.class ,Material.class};

        XStream xstream = new XStream(new DomDriver());
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);

        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("JewelleryShop.xml"));
        headCase = (DisplayCase) is.readObject();
        headTray = (DisplayTray) is.readObject();
        headItem = (JewelleryItem) is.readObject();
        headMaterial = (Material) is.readObject();
        is.close();
    }

    public static void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("JewelleryShop.xml"));
        out.writeObject(headCase);
        out.writeObject(headTray);
        out.writeObject(headItem);
        out.writeObject(headMaterial);
        out.close();

    }

}