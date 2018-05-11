package com.demo.architect.data.model.offline;

/**
 * Created by Skull on 25/03/2018.
 */

public class PromotionEntity {
    String title, description;
    boolean isNew;

    public PromotionEntity() {
    }

    public PromotionEntity(String title, String description, boolean isNew) {
        this.title = title;
        this.description = description;
        this.isNew = isNew;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}
