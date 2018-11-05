package com.example.liucheng.net;

import com.example.liucheng.bean.Book;
import com.example.liucheng.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostMethord {
    @POST("/userlogin")
    @FormUrlEncoded
    Observable<UserBean> getuser(@Field("id") String id, @Field("token") String token);
}
