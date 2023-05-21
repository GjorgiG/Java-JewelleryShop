package com.example.assign1;

import java.io.Serializable;

public class Material implements Serializable {


    public String description;
    public int amount;
    public String type;
    public int quality;

    public Material next;
    public JewelleryItem theItem;


    public static void AddMaterial(int amount, String description, int quality) {
        Material mat = new Material();
        mat.amount = amount;
        mat.description = description;
        mat.quality = quality;
        mat.next = HelloApplication.headMaterial;
        HelloApplication.headMaterial = mat;
    }

    @Override
    public String toString() {
        return theItem + ", " + " Material{" +
//                "next=" + next +
                "type=" + type +
                ", amount=" + amount +
                ", material description=" + description +
                ", quality=" + quality +
                '}';
    }
}
