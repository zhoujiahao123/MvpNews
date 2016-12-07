package example.com.mvpnews.ui.view.activity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import example.com.mvpnews.R;
import example.com.mvpnews.app.BaseActivity;
import example.com.mvpnews.bean.NewsBean;
import example.com.mvpnews.presenter.NewPresenter;
import example.com.mvpnews.presenter.NewsPresenterImpl;
import example.com.mvpnews.ui.view.MainView;
import example.com.mvpnews.ui.view.dapter.FragmentAdapter;
import example.com.mvpnews.ui.view.fragment.NewsFragment;

/**
 * Created by ASUS-NB on 2016/12/4.
 */

public class MainActivity extends BaseActivity implements MainView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private ConnectivityManager manager;
    private NetworkInfo networkInfo;
    private boolean isConnect = false;
    private NewPresenter presenter;
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);
        init();
        isConnect = isConnect();
        if (isConnect) {
            presenter.loadNewsNet();
        } else {
            presenter.loadNewsSql();
        }
    }

    private void init() {
        manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = manager.getActiveNetworkInfo();
        presenter = new NewsPresenterImpl(this);
    }

    private boolean isConnect() {
        if (networkInfo != null && networkInfo.isAvailable()) {
            return true;
        }
        Toast.makeText(this,"请检查网络情况",Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void requestNews() {

    }

    @Override
    public void loadNews() {

    }

    @Override
    public void showNews(NewsBean topNewsBean, NewsBean shehuiNewsBean, NewsBean guoneiNewsBean) {
        adapter = new FragmentAdapter(getSupportFragmentManager(), topNewsBean, shehuiNewsBean, guoneiNewsBean);
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(3);
        tab.setupWithViewPager(viewpager);
    }

}
