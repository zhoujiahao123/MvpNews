package example.com.mvpnews.config;

import example.com.mvpnews.bean.NewsBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ASUS-NB on 2016/12/2.
 */

public interface Api {
    @GET("index?")
    Observable<NewsBean> getNews(@Query("type")String type, @Query("key")String key);
}