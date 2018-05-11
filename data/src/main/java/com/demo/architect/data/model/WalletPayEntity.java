package com.demo.architect.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Skull on 18/12/2017.
 */

public class WalletPayEntity implements Serializable {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("employee_id")
    @Expose
    private String employee_id;

    @SerializedName("money_plus")
    @Expose
    private int money_plus;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private String deletedAt;
    @SerializedName("access_token")
    @Expose
    private String accessToken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public int getMoney_plus() {
        return money_plus;
    }

    public void setMoney_plus(int money_plus) {
        this.money_plus = money_plus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public WalletPayEntity(String id, String employee_id, int money_plus, String description, Integer status, String createdAt, String updatedAt, String deletedAt, String accessToken) {
        this.id = id;
        this.employee_id = employee_id;
        this.money_plus = money_plus;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.accessToken = accessToken;
    }

    public WalletPayEntity() {
    }

    //    @SerializedName("employee_farmers")
//    @Expose
//    private List<Object> employeeFarmers = null;


}