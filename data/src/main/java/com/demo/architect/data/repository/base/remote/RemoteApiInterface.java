package com.demo.architect.data.repository.base.remote;

import com.demo.architect.data.model.BaseResponse;
import com.demo.architect.data.model.LinkContactEntity;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by uyminhduc on 10/16/16.
 */

public interface RemoteApiInterface {
    @Headers("Authorization: Basic Y2FsbGNlbnRlcl9nb2l0aG86Y2FsbCEjQCNAJCNAQEA=")
    @POST("https://callcenter2.goitho.com/api/v2/GoiTho/linkContact")
    Call<BaseResponse<LinkContactEntity>> linkContact();
}
