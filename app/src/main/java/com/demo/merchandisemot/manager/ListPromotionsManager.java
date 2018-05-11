package com.demo.merchandisemot.manager;

import com.demo.architect.data.model.PromotionEntity;

import java.util.ArrayList;

public class ListPromotionsManager {
    private ArrayList<PromotionEntity> listPromotions = new ArrayList<>();
    private static ListPromotionsManager instance;

    public static ListPromotionsManager getInstance() {
        if (instance == null) {
            instance = new ListPromotionsManager();
        }
        return instance;
    }

    public ArrayList<PromotionEntity> getListPromotions() {
        return listPromotions;
    }


    public void setListPromotions(ArrayList<PromotionEntity> listPromotions) {
        this.listPromotions.clear();
        this.listPromotions = listPromotions;
    }

    //    public void addListOrders(ArrayList<PromotionEntity> listOrders) {
//        this.listOrders.addAll(listOrders);
//    }


    public PromotionEntity getPromotionEntityById(String orderId) {
        for (PromotionEntity promotionEntity : listPromotions) {
            if (promotionEntity.getPromotionId().equals(orderId)) {
                return promotionEntity;
            }
        }
        return null;
    }

    public void updateEntity(PromotionEntity promotionEntity) {

            for (PromotionEntity tempEntity : listPromotions) {
                if (tempEntity.getPromotionId().equals(promotionEntity.getPromotionId())) {
                    listPromotions.set(listPromotions.indexOf(tempEntity), promotionEntity);
                }
            }

    }
}
