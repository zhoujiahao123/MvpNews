package example.com.mvpnews.model.api.util;

import example.com.mvpnews.presenter.OnCallbackListener;

/**
 * Created by ASUS-NB on 2016/12/4.
 */

public interface NewsModel {
    void saveNews();

    void loadNewsSql();

    void loadNewsNet(OnCallbackListener listener);
}
