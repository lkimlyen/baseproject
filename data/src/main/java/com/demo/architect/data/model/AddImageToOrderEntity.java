package com.demo.architect.data.model;

import com.demo.architect.data.model.offline.ImageEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class AddImageToOrderEntity implements Serializable {
    @SerializedName("imageList")
    @Expose
    private ArrayList<ImageEntity> imageList;

    public ArrayList<ImageEntity> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<ImageEntity> imageList) {
        this.imageList = imageList;
    }
}