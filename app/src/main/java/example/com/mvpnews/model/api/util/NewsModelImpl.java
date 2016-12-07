package example.com.mvpnews.model.api.util;

import android.util.Log;

import example.com.mvpnews.bean.NewsBean;
import example.com.mvpnews.presenter.OnCallbackListener;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ASUS-NB on 2016/12/4.
 */

public class NewsModelImpl implements NewsModel{
    @Override
    public void saveNews() {

    }

    @Override
    public void loadNewsSql() {

    }

    @Override
    public void loadNewsNet(final OnCallbackListener listener) {
        Observable<NewsBean> observable = RequestNews.getObservable("top");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.error(e);
                    }

                    @Override
                    public void onNext(NewsBean topNewsBean) {
                        loadSheHuiNews(listener,topNewsBean);
                    }
                });
    }
    public void loadSheHuiNews(final OnCallbackListener listener, final NewsBean topNewsBean){
        Observable<NewsBean> observable = RequestNews.getObservable("shehui");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.error(e);
                    }

                    @Override
                    public void onNext(NewsBean shehuiNewsBean) {
                        loadGuoNeiNews(listener,topNewsBean,shehuiNewsBean);
                    }
                });
    }
    public void loadGuoNeiNews(final OnCallbackListener listener, final NewsBean topNewsBean, final NewsBean shehuiNewsBean){
        Observable<NewsBean> observable = RequestNews.getObservable("guonei");
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewsBean>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.error(e);
                    }

                    @Override
                    public void onNext(NewsBean guoneiNewsBean) {
                        listener.succeed(topNewsBean,shehuiNewsBean,guoneiNewsBean);
                    }
                });
    }
}
