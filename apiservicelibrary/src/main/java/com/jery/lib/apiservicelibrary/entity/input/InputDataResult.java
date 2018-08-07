package com.jery.lib.apiservicelibrary.entity.input;

import com.google.gson.annotations.SerializedName;
import com.jery.lib.networklibrary.model.BaseResult;

public class InputDataResult extends BaseResult {
    @SerializedName("result")
    private InputData result;

    public InputData getResult() {
        return result;
    }

    public void setResult(InputData result) {
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

    public static class InputData {
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
