package com.demo.architect.data.model;

import com.demo.architect.data.model.offline.ImageEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Skull on 12/04/2018.
 */
public class PromotionEntity {
    @SerializedName("promotionId")
    @Expose
    private String promotionId;
    @SerializedName("promotionName")
    @Expose
    private String promotionName;
    @SerializedName("promotionContent")
    @Expose
    private String promotionContent;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("promotionDate")
    @Expose
    private String promotionDate;
    @SerializedName("picture")
    @Expose
    private String picture;
    @SerializedName("rule")
    @Expose
    private String rule;
    @SerializedName("bonus")
    @Expose
    private String bonus;

    @SerializedName("listImage")
    @Expose
    private ArrayList<ImageEntity> listImage;

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getPromotionContent() {
        return promotionContent;
    }

    public void setPromotionContent(String promotionContent) {
        this.promotionContent = promotionContent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPromotionDate() {
        return promotionDate;
    }

    public void setPromotionDate(String promotionDate) {
        this.promotionDate = promotionDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public ArrayList<ImageEntity> getListImage() {
        return listImage;
    }

    public void setListImage(ArrayList<ImageEntity> listImage) {
        this.listImage = listImage;
    }
}