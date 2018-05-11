package com.demo.architect.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Skull on 19/04/2018.
 */
public class ResetPhoneNumberEntity {
    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public class Data {

        @SerializedName("new_phonenumber")
        @Expose
        private String newPhonenumber;
        @SerializedName("userId")
        @Expose
        private String userId;
        @SerializedName("auth_code")
        @Expose
        private Integer authCode;

        public String getNewPhonenumber() {
            return newPhonenumber;
        }

        public void setNewPhonenumber(String newPhonenumber) {
            this.newPhonenumber = newPhonenumber;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public Integer getAuthCode() {
            return authCode;
        }

        public void setAuthCode(Integer authCode) {
            this.authCode = authCode;
        }

    }
}
