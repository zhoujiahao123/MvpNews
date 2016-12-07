package example.com.mvpnews.ui.view;

import example.com.mvpnews.bean.NewsBean;

/**
 * Created by ASUS-NB on 2016/12/4.
 */

public interface MainView {
    void requestNews();

    void loadNews();

    void showNews(NewsBean topNewsBean, NewsBean shehuiNewsBean, NewsBean guoneiNewsBean);
}
