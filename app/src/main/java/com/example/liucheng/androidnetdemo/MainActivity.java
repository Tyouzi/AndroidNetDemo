package com.example.liucheng.androidnetdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.liucheng.bean.Book;
import com.example.liucheng.bean.UserBean;
import com.example.liucheng.net.GetMethord;
import com.example.liucheng.net.PostMethord;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity implements View.OnClickListener {
   private Button button,button_post;
   private TextView textView;
   private Observable<Book> observable;
   private Observable<UserBean> postobserver;
   private  Book book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text);
        button=findViewById(R.id.button);
        button_post=findViewById(R.id.button_post);
        button.setOnClickListener(this);
        button_post.setOnClickListener(this);
        //步骤4：创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.42.182:8888") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava
                .build();
        GetMethord methord=retrofit.create(GetMethord.class);
        observable=methord.getCall();
        PostMethord postMethord=retrofit.create(PostMethord.class);
        postobserver=postMethord.getuser("1","10");
        //=============
        /*
        * const/4 v5, 0x0

    invoke-virtual {v0, v1, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;
        *
        * */
        Intent intent = new Intent();
        intent.putExtra("statuscode",0 );
        setResult(2, intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.button:
                observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Book>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("liucheng11111","subscribe");
                    }

                    @Override
                    public void onNext(Book book) {
                        Log.d("liucheng11111",book.toString());
                        textView.setText(book.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("liucheng11111",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
                break;
            case R.id.button_post:
                 postobserver.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<UserBean>() {
                     @Override
                     public void onSubscribe(Disposable d) {
                         Log.d("postobserver",d.toString()+"");
                     }

                     @Override
                     public void onNext(UserBean userBean) {
                        Log.d("postobserver",userBean.toString()+"");
                        textView.setText(userBean.toString());
                     }

                     @Override
                     public void onError(Throwable e) {
                         Log.d("postobserver",e.toString()+"");
                     }

                     @Override
                     public void onComplete() {

                     }
                 });
                break;
        }
    }
}
