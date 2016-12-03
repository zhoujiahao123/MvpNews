package example.com.mvpnews.presenter;

import java.util.List;

import example.com.mvpnews.News;

/**
 * Created by ASUS-NB on 2016/12/2.
 */

public interface OnNewsFromSqlListener {
    void succeed(List<News> list);

    void error(Exception e);
}
