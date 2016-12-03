package example.com.mvpnews.model.api.util;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ASUS-NB on 2016/12/2.
 */

public class RetrofitFroAllUtils {
    public static Retrofit getRetrofitInstance(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://v.juhe.cn/toutiao/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;

    }
}
