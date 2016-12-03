package example.com.mvpnews.presenter;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.util.List;

import example.com.mvpnews.News;
import example.com.mvpnews.app.BaseApplication;
import example.com.mvpnews.bean.NewsBean;
import example.com.mvpnews.model.api.NewsModel;
import example.com.mvpnews.model.api.NewsModelImpl;
import example.com.mvpnews.ui.view.NewsView;

/**
 * Created by ASUS-NB on 2016/12/2.
 */

public class NewsPresenterImpl implements NewsPresenter,OnNewsFromSqlListener,OnNewsListener{
    private NewsView view;
    private NewsModel newsModel;
    private NewsBean newsBean;
    private List<News> list;
    private ConnectivityManager manager;
    NetworkInfo networkInfo;
    public NewsPresenterImpl(NewsView view){
        this.view = view;
        newsModel = new NewsModelImpl();
        manager = (ConnectivityManager) BaseApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = manager.getActiveNetworkInfo();
        if(networkInfo.isAvailable()){
            newsModel.getInfo(this);
            Log.e("news getinfo","newsModthis);");
        }else {
            newsModel.loadInfo(this);
        }
    }
    @Override
    public void loadNewsFromNet() {
        view.showNews(newsBean);
    }

    @Override
    public void loadNewsFromSql() {
        view.showsNews(list);
    }

    @Override
    public void succeed(List<News> list) {
        this.list = list;

    }

    @Override
    public void error(Exception e) {

    }

    @Override
    public void success(NewsBean newsBean) {
        this.newsBean = newsBean;
        loadNewsFromNet();
    }

    @Override
    public void error(Throwable e) {

    }
}
