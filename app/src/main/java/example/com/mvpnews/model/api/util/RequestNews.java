package example.com.mvpnews.model.api.util;

import example.com.mvpnews.bean.NewsBean;
import example.com.mvpnews.config.Api;
import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by ASUS-NB on 2016/12/2.
 */

public class RequestNews {
        private static final String key = "cd6f63aca9759092dac67543050661f1";
    public static Observable<NewsBean> getObservable(String type){
        Retrofit retrofit = RetrofitFroAllUtils.getRetrofitInstance();
        Api api = retrofit.create(Api.class);
        Observable<NewsBean> observable = (Observable<NewsBean>) api.getNews(type,key);
        return observable;
    }
}
