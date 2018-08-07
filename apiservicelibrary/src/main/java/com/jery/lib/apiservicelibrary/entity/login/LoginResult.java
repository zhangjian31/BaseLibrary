package com.jery.lib.apiservicelibrary.entity.login;

import com.google.gson.annotations.SerializedName;
import com.jery.lib.networklibrary.model.BaseResult;

public class LoginResult extends BaseResult {
    @SerializedName("result")
    private LoginBean result;

    public LoginBean getResult() {
        return result;
    }

    public void setResult(LoginBean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "InputDataResult{" +
                "result=" + result +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }

    public static class LoginBean {
        @SerializedName("username")
        private String username;
        @SerializedName("passwd")
        private String passwd;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPasswd() {
            return passwd;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }

        @Override
        public String toString() {
            return "InputData{" +
                    "username='" + username + '\'' +
                    ", passwd='" + passwd + '\'' +
                    '}';
        }
    }

}
