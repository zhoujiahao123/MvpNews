package example.com.mvpnews.presenter;

import example.com.mvpnews.bean.NewsBean;

/**
 * Created by ASUS-NB on 2016/12/2.
 */

public interface NewsPresenter {

        void loadNewsFromNet();

        void loadNewsFromSql();
}
