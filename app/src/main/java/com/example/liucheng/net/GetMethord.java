package com.example.liucheng.net;



import com.example.liucheng.bean.Book;

import io.reactivex.Observable;
import retrofit2.http.GET;

 public interface GetMethord {

    @GET("/ping")
    Observable<Book> getCall();
}
