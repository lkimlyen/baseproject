package com.demo.architect.data.model.offline;

import android.graphics.Bitmap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Skull on 30/11/2017.
 */

public class ImageEntity {
    @SerializedName("imageId")
    @Expose
    private String imageId;

    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ImageEntity(String imageId, String imageUrl) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
    }

    public ImageEntity(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
