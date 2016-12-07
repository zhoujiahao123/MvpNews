package example.com.mvpnews.presenter;

import example.com.mvpnews.bean.NewsBean;

/**
 * Created by ASUS-NB on 2016/12/4.
 */

public interface OnCallbackListener {
        void succeed(NewsBean topNewsBean,NewsBean shehuiNewsBean,NewsBean guoneiNewsBean);

        void error(Throwable e);
}
