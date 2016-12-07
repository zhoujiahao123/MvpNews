package example.com.mvpnews.presenter;

import example.com.mvpnews.bean.NewsBean;

/**
 * Created by ASUS-NB on 2016/12/4.
 */

public interface NewPresenter {
    void loadNewsSql();

    void loadNewsNet();

    void setNews(NewsBean topNewsBean, NewsBean shehuiNewsBean, NewsBean guoneiNewsBean);

}
