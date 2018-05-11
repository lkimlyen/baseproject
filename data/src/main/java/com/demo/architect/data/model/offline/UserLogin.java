package com.demo.architect.data.model.offline;

public class UserLogin {
    private String userName;
    private String password;

    public UserLogin() {
    }

    public UserLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
