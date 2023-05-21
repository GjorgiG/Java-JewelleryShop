package com.example.assign1;
import java.io.Serializable;

public class JewelleryItem implements Serializable {

    public static DisplayCase theCase;
    public String description;
    public boolean male;
    public boolean female;
    public int retailPrice;
    public JewelleryItem next;
    public DisplayTray theTray;
    public String type;

    public static void AddJewelleryItem(int retailPrice, boolean male, boolean female, String description){
        JewelleryItem ji = new JewelleryItem();
        ji.female = female;
        ji.male = male;
        ji.retailPrice = retailPrice;
        ji.setDescription(description);
        ji.next = HelloApplication.headItem;
        HelloApplication.headItem = ji;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return theTray + ", " + " Jewellery Item{" +
//                "next=" + next +
                "description=" + description +
                ", type=" + type +
                ", male='" + male + '\'' +
                ", female='" + female + '\'' +
                   ", price=" + retailPrice +
                '}';
    }
}
