package com.demo.merchandisemot.manager;

import com.demo.architect.data.helper.SharedPreferenceHelper;
import com.demo.architect.data.model.LinkContactEntity;
import com.demo.architect.data.model.offline.ContactEntity;
import com.demo.architect.domain.usecase.LinkContactUsecase;
import com.goitho.employeeapp.app.CoreApplication;

public class ListContactManager {
    private LinkContactEntity contactEntity;
    private static ListContactManager instance;

    public static ListContactManager getInstance() {
        if (instance == null) {
            instance = new ListContactManager();
        }
        return instance;
    }

    public void setContact(LinkContactEntity contact) {
        contactEntity = contact;
        SharedPreferenceHelper.getInstance(CoreApplication.getInstance()).pushListContactObject(contact);
    }

    public LinkContactEntity getContact() {
        if (contactEntity == null) {
            contactEntity = SharedPreferenceHelper.getInstance(CoreApplication.getInstance()).getListContactObject();
        }
        return contactEntity;
    }
}
