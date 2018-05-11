package com.demo.merchandisemot.manager;

import com.demo.architect.data.helper.SharedPreferenceHelper;
import com.demo.architect.data.model.UserEntity;
import com.goitho.employeeapp.app.CoreApplication;

public class UserManager {
    private UserEntity userEntity;
    private static UserManager instance;

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void setUser(UserEntity user) {
        userEntity = user;
        SharedPreferenceHelper.getInstance(CoreApplication.getInstance()).pushUserObject(userEntity);
    }

    public UserEntity getUser() {
        if (userEntity == null) {
            userEntity = SharedPreferenceHelper.getInstance(CoreApplication.getInstance()).getUserObject();
        }
        return userEntity;
    }

    public boolean isUserField(String id) {
        if( userEntity.getListFields().size() == 0)
            return false;

        for (UserEntity.Field field: userEntity.getListFields()) {
            if (field.getId() == null) {
                continue;
            }
            if(field.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
