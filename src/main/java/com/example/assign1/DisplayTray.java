package com.example.assign1;
import java.io.Serializable;

public class DisplayTray implements Serializable {

    public int trayNumber;
    public String inlayColour;
    public int dimensions;

    public DisplayTray next;
    public DisplayTray firstTray;
    public JewelleryItem firstJI;
    public DisplayCase theCase;
    public DisplayTray headTray;

    public static void addDisplayTray(DisplayCase x,int num,int dimensions, String inlayColour) {
        DisplayTray dt = new DisplayTray();
        dt.trayNumber = num;
        dt.dimensions = dimensions;
        dt.inlayColour = inlayColour;
        dt.next = HelloApplication.headTray;
        HelloApplication.headTray = dt;
    }

    public DisplayTray getHeadTray() {
        return headTray;
    }

    public void setHeadTray(DisplayTray headTray) {
        this.headTray = headTray;
    }




    @Override
    public String toString() {
        return  theCase + " DisplayTray{" +
//                "next=" + next +
                "trayNumber=" + trayNumber +
                ", inlayColour='" + inlayColour + '\'' +
                ", dimensions='" + dimensions + '\'' +
                //   ", firstTray=" + firstTray +
                '}';
    }
}
