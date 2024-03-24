/*
 * Copyright (c) 2017. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */

/**
 *
 */
package com.example.myapplication;

/**
 * The Class Product used as model for Products.
 *
 * @author Hitesh
 */
public class Product {


    /**
     * The item short desc.
     */
    private String description = "";

    /**
     * The item detail.
     */
    private String longDescription = "";

    /**
     * The mrp.
     */
    private String mrp;

    /**
     * The discount.
     */
    private String discount;

    /**
     * The sell mrp.
     */
    private String price;

    /**
     * The quantity.
     */
    private String orderQty;

    /**
     * The image url.
     */
    private String image = "";

    /**
     * The item name.
     */
    private String rawmaterialname = "";

    private String id = "";

    /**
     * @param itemName
     * @param itemShortDesc
     * @param itemDetail
     * @param MRP
     * @param discount
     * @param sellMRP
     * @param quantity
     * @param imageURL
     */
    public Product(String itemName, String itemShortDesc, String itemDetail,
                   String MRP, String discount, String sellMRP, String quantity,
                   String imageURL, String orderId) {
        this.rawmaterialname = itemName;
        this.description = itemShortDesc;
        this.longDescription = itemDetail;
        this.mrp = MRP;
        this.discount = discount;
        this.price = sellMRP;
        this.orderQty = quantity;
        this.image = imageURL;
        this.id = orderId;
    }

    public String getProductId() {
        return id;
    }

    public void setProductId(String productId) {
        this.id = productId;
    }

    public String getItemName() {
        return rawmaterialname;
    }

    public void setItemName(String itemName) {
        this.rawmaterialname = itemName;
    }

    public String getItemShortDesc() {
        return description;
    }

    public void setItemShortDesc(String itemShortDesc) {
        this.description = itemShortDesc;
    }

    public String getItemDetail() {
        return longDescription;
    }

    public void setItemDetail(String itemDetail) {
        this.longDescription = itemDetail;
    }

    public String getMRP() {
        return this.mrp;
    }

    public void setMRP(String MRP) {
        this.mrp = MRP;
    }

    public String getDiscount() {
        return discount + "%";
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscountNumeric() {
        return discount;
    }

    public String getSellMRP() {
        return price;
    }

    public void setSellMRP(String sellMRP) {
        this.price = sellMRP;
    }

    public String getQuantity() {
        return orderQty;
    }

    public void setQuantity(String quantity) {
        this.orderQty = quantity;
    }

    public String getImageURL() {
        return image;
    }

    public void setImageURL(String imageURL) {
        this.image = imageURL;
    }

}
