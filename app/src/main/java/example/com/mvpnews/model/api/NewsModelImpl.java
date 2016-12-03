package example.com.mvpnews.model.api;



import android.util.Log;


import java.text.SimpleDateFormat;
import java.util.List;

import de.greenrobot.dao.query.LazyList;
import de.greenrobot.dao.query.Query;

import example.com.mvpnews.DaoSession;
import example.com.mvpnews.News;
import example.com.mvpnews.NewsDao;
import example.com.mvpnews.app.BaseApplication;
import example.com.mvpnews.bean.NewsBean;
import example.com.mvpnews.model.api.util.RequestNews;


import example.com.mvpnews.presenter.OnNewsFromSqlListener;
import example.com.mvpnews.presenter.OnNewsListener;
import example.com.mvpnews.util.ChangeClass;
import example.com.mvpnews.util.CompareTime;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ASUS-NB on 2016/12/2.
 */

public class NewsModelImpl implements NewsModel{
    private DaoSession daoSession;
    private NewsDao newsDao;
    private boolean islt;


    @Override
    public void saveInfo(NewsBean newsBean) {
        daoSession = BaseApplication.getDaoSession();
        newsDao = daoSession.getNewsDao();
        List<News> list = ChangeClass.changeNewsBeanToNews(newsBean);
        int i=list.size();
        for(int j=i;j>0;j--){
                islt=CompareTime.parseData(list.get(j).getDate(),BaseApplication.getDate());
            if(islt){
                News news = list.get(j);
                newsDao.insert(news);
            }
        }
    }

    @Override
    public void loadInfo(OnNewsFromSqlListener listener) {
        daoSession = BaseApplication.getDaoSession();
        newsDao = daoSession.getNewsDao();
        Query query =  newsDao.queryBuilder().build();
        LazyList<News> list = query.listLazy();
        if(list.size()!=0){
            listener.succeed(list);
            list.close();
        }else {
            listener.error(new Exception("数据库为空"));
            list.close();
        }
    }

    @Override
    public void getInfo(final OnNewsListener listener) {
        Observable<NewsBean> observable = RequestNews.getObservable();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<NewsBean>() {
                    @Override
                    public void onCompleted() {
                        Log.e("onCompleted","succeed");

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.error(e);
                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        listener.success(newsBean);
                    }
                });
    }
}
