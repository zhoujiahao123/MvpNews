package example.com.mvpnews.ui.view;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.jude.rollviewpager.Util;

import java.util.List;

import example.com.mvpnews.News;
import example.com.mvpnews.R;
import example.com.mvpnews.app.BaseActivity;
import example.com.mvpnews.bean.NewsBean;
import example.com.mvpnews.presenter.NewsPresenter;
import example.com.mvpnews.presenter.NewsPresenterImpl;
import example.com.mvpnews.ui.view.holder.NewsHolder;
import example.com.mvpnews.util.ChangeClass;

/**
 * Created by ASUS-NB on 2016/12/3.
 */

public class NewsActivity extends BaseActivity implements NewsView,View.OnClickListener,RecyclerArrayAdapter.OnLoadMoreListener, android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener{
    private EasyRecyclerView recyclerView;
    private FloatingActionButton fabGoTop;
    private RecyclerArrayAdapter adapter;
    private NewsPresenter presenter;
    private List<News> news;
    private Handler mHandler= new Handler() ;
    private int page = 0;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        init();

    }
    private void init(){
        recyclerView = (EasyRecyclerView) findViewById(R.id.recyclerview);
        fabGoTop = (FloatingActionButton) findViewById(R.id.fab);
        fabGoTop.setOnClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerDecoration decoration = new DividerDecoration(Color.GRAY, Util.dip2px(this,0.5f),Util.dip2px(this,80),0);
        decoration.setDrawLastItem(false);
        recyclerView.addItemDecoration(decoration);
        presenter = new NewsPresenterImpl(this);
        recyclerView.setAdapterWithProgress((adapter = new RecyclerArrayAdapter(this) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new NewsHolder(parent);
            }
        }));
        adapter.setMore(R.layout.view_more,this);
        recyclerView.setRefreshListener(this);
    }
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showNews(NewsBean newsBean) {
        news = ChangeClass.changeNewsBeanToNews(newsBean);
        onRefresh();
    }

    @Override
    public void showsNews(List<News> list) {
        news = list;
        onRefresh();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.fab){
            recyclerView.scrollToPosition(0);
        }
    }

    @Override
    public void onRefresh() {
        page= 0;
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.clear();
                adapter.addAll(news);
            }
        },2000);
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.addAll(news);
                page++;
            }
        },2000);
    }
}
