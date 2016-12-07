package example.com.mvpnews.presenter;

import example.com.mvpnews.bean.NewsBean;
import example.com.mvpnews.model.api.util.NewsModel;
import example.com.mvpnews.model.api.util.NewsModelImpl;
import example.com.mvpnews.ui.view.MainView;

/**
 * Created by ASUS-NB on 2016/12/4.
 */

public class NewsPresenterImpl implements NewPresenter,OnCallbackListener{
    private MainView mainView;
    private NewsModel newsModel;

    public NewsPresenterImpl(MainView view){
        mainView = view;
        newsModel = new NewsModelImpl();
    }
    @Override
    public void loadNewsSql() {

    }

    @Override
    public void loadNewsNet() {
        newsModel.loadNewsNet(this);
    }

    @Override
    public void setNews(NewsBean topNewsBean,NewsBean shehuiNewsBean,NewsBean guoneiNewsBean) {
        mainView.showNews(topNewsBean, shehuiNewsBean, guoneiNewsBean);
    }

    @Override
    public void succeed(NewsBean topNewsBean,NewsBean shehuiNewsBean,NewsBean guoneiNewsBean) {
        setNews( topNewsBean, shehuiNewsBean, guoneiNewsBean);
    }

    @Override
    public void error(Throwable e) {
        new Exception("在请求新闻时出现了问题");
    }
}
