package com.demo.merchandisemot.util;

import com.demo.architect.data.model.OrderEntity;
import com.goitho.employeeapp.R;

/**
 * Created by PC on 22-Apr-2018.
 */

public class GetResult {

    public static String getStringTimeByState(OrderEntity orderEntity){
        String timeresult = "";
        switch (orderEntity.getState()){
            case "0":
                break;
            case "1":
                timeresult = orderEntity.getSurveyTime();
                break;
            case "2":
                timeresult = "";
                break;
            case "3":
                timeresult = orderEntity.getContructionTime();
                break;
            case "4":
                timeresult = orderEntity.getAcceptanceTime();
                break;
            case "5":
                break;
        }
        return timeresult;
    }

    public static String getDescriptionState(int state){
        String description = "";
        switch (state){
            case 0:
                description = "Chưa liên lạc được";
                break;
            case 1:
                description = "Chờ khảo sát";
                break;
            case 2:
                description = "Hoàn thành";
                break;
            case 3:
                description = "Chờ thi công";
                break;
            case 4:
                description = "Chưa thành công";
                break;
            case 5:
                description = "Đã hủy";
                break;
        }
        return description;
    }

}
