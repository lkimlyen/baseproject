package com.demo.architect.data.repository.base.remote;


import com.demo.architect.data.model.BaseResponse;
import com.demo.architect.data.model.LinkContactEntity;
import com.demo.architect.data.model.MessageModel;
import com.demo.architect.data.model.UpdateUserEntity;
import com.demo.architect.data.model.UserEntity;

import java.util.List;

import rx.Observable;

/**
 * Created by uyminhduc on 10/16/16.
 */

public interface RemoteRepository {
    Observable<BaseResponse<LinkContactEntity>> linkContact();
}
