package example.com.mvpnews.ui.view;

import java.util.List;

import example.com.mvpnews.News;
import example.com.mvpnews.bean.NewsBean;

/**
 * Created by ASUS-NB on 2016/12/2.
 */

public interface NewsView {
    public void showLoading();

    public void hideLoading();

    public void showError();

    public void showNews(NewsBean newsBean);

    public void showsNews(List<News> list);
}
