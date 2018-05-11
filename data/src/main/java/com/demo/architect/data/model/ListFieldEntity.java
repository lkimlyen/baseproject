package com.demo.architect.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Skull on 25/04/2018.
 */
public class ListFieldEntity {
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

        @SerializedName("all_field")
        @Expose
        private List<Field> allField = null;

        public List<Field> getAllField() {
            return allField;
        }

        public void setAllField(List<Field> allField) {
            this.allField = allField;
        }

    }
    public class Field {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("datetime")
        @Expose
        private String datetime;
        @SerializedName("public")
        @Expose
        private String _public;
        @SerializedName("creby")
        @Expose
        private String creby;
        @SerializedName("image")
        @Expose
        private Object image;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public String getPublic() {
            return _public;
        }

        public void setPublic(String _public) {
            this._public = _public;
        }

        public String getCreby() {
            return creby;
        }

        public void setCreby(String creby) {
            this.creby = creby;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
            this.image = image;
        }

    }

}
