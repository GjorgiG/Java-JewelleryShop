package com.example.assign1;

import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.fxml.FXML;


public class DisplayCase implements Serializable {

    public DisplayCase next;
    public int caseNumber;
    public boolean lighting;
    public boolean mounted;
    public DisplayTray firstTray;
    public static DisplayCase firstCase;




    public static void addDisplayCase(int num,boolean mounted, boolean lighting) {
        DisplayCase dc = new DisplayCase();
        dc.caseNumber=num;
        dc.lighting = lighting;
        dc.mounted = mounted;
        dc.next = HelloApplication.headCase;
        HelloApplication.headCase =dc;
    }

    public static void addDisplayTray(DisplayCase x,int nums,String t, String lit) {
        DisplayTray dt = new DisplayTray();
        dt.trayNumber = nums;
        dt.next = HelloApplication.headTray;
        HelloApplication.headTray = dt;
    }

//    @FXML
//    public void load(ActionEvent actionEvent) throws Exception{
//        HelloApplication.loadData();
//    }


    public DisplayCase getNext() {
        return next;
    }

    public void setNext(DisplayCase next) {
        this.next = next;
    }

    public int getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(int caseNumber) {
        this.caseNumber = caseNumber;
    }

    public boolean isLighting() {
        return lighting;
    }

    public void setLighting(boolean lighting) {
        this.lighting = lighting;
    }

    public boolean isMounted() {
        return mounted;
    }

    public void setMounted(boolean mounted) {
        this.mounted = mounted;
    }



    public static DisplayCase getFirstCase() {
        return firstCase;
    }

    public static void setFirstCase(DisplayCase firstCase) {
        DisplayCase.firstCase = firstCase;
    }

    @Override
    public String toString() {
        return "DisplayCase{" +
//                "next=" + next +
                "caseNumber=" + caseNumber +
                ", mounted='" + mounted + '\'' +
                ", lighting='" + lighting + '\'' +
             //   ", firstTray=" + firstTray +
                '}';
    }



}
