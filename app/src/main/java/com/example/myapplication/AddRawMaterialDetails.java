package com.example.myapplication;

import android.graphics.Bitmap;

public class AddRawMaterialDetails {
    private int id;
    private String rawmaterialname,price,quantity;
    private Bitmap image;

    public AddRawMaterialDetails(int id, String rawmaterialname, String price, String quantity, Bitmap image) {
        this.id = id;
        this.rawmaterialname = rawmaterialname;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public AddRawMaterialDetails(String rawmaterialname, String price, String quantity, Bitmap image) {
        this.rawmaterialname = rawmaterialname;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public AddRawMaterialDetails(AddAgriProductActivity addAgriProductActivity) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRawmaterialname() {
        return rawmaterialname;
    }

    public void setRawmaterialname(String rawmaterialname) {
        this.rawmaterialname = rawmaterialname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


}
