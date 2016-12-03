package example.com.mvpnews.model.api;

import example.com.mvpnews.bean.NewsBean;
import example.com.mvpnews.presenter.OnNewsFromSqlListener;
import example.com.mvpnews.presenter.OnNewsListener;

/**
 * Created by ASUS-NB on 2016/12/2.
 */

public interface NewsModel {
    //存储数据到数据库
        void saveInfo(NewsBean newsBean);
    //从数据库加载数据(当没有网络时执行)
        void loadInfo(OnNewsFromSqlListener listener);

    //从网络加载数据
        void getInfo(OnNewsListener listener);
}
