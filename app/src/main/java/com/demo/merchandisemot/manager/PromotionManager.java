package com.demo.merchandisemot.manager;

import com.demo.architect.data.model.PromotionEntity;

public class PromotionManager {
    private PromotionEntity promotionEntity = new PromotionEntity();
    private static PromotionManager instance;

    public static PromotionManager getInstance() {
        if (instance == null) {
            instance = new PromotionManager();
        }
        return instance;
    }

    public PromotionEntity getPromotionEntity() {
        return promotionEntity;
    }

    public void setPromotionEntity(PromotionEntity promotionEntity) {
        this.promotionEntity = promotionEntity;
    }
}
