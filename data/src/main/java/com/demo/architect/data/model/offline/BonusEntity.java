package com.demo.architect.data.model.offline;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Skull on 30/11/2017.
 */

public class BonusEntity {
    @SerializedName("bonus")
    @Expose
    private String bonus;

    @SerializedName("description")
    @Expose
    private String description;

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
