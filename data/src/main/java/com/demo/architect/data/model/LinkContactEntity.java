package com.demo.architect.data.model;

import com.demo.architect.data.model.offline.ContactEntity;
import com.demo.architect.data.model.offline.IncomeUserEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Skull on 18/12/2017.
 */

public class LinkContactEntity implements Serializable {

    @SerializedName("linkContact")
    @Expose
    private ArrayList<ContactEntity> linkContact;

    public ArrayList<ContactEntity> getLinkContact() {
        return linkContact;
    }

    public void setLinkContact(ArrayList<ContactEntity> linkContact) {
        this.linkContact = linkContact;
    }
}