package com.demo.architect.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Skull on 27/04/2018.
 */
public class AddListFieldEntity {

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

        @SerializedName("id_linhvuc")
        @Expose
        private String idLinhvuc;
        @SerializedName("ten_linhvuc")
        @Expose
        private String tenLinhvuc;

        public String getIdLinhvuc() {
            return idLinhvuc;
        }

        public void setIdLinhvuc(String idLinhvuc) {
            this.idLinhvuc = idLinhvuc;
        }

        public String getTenLinhvuc() {
            return tenLinhvuc;
        }

        public void setTenLinhvuc(String tenLinhvuc) {
            this.tenLinhvuc = tenLinhvuc;
        }

    }
}
