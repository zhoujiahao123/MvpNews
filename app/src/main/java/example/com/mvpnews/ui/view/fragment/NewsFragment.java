package example.com.mvpnews.ui.view.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.jude.rollviewpager.Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import example.com.mvpnews.R;
import example.com.mvpnews.app.BaseFragment;
import example.com.mvpnews.bean.NewsBean;
import example.com.mvpnews.ui.view.holder.NewsHolder;
import example.com.mvpnews.util.ChangeClass;

/**
 * Created by ASUS-NB on 2016/12/5.
 */

public class NewsFragment extends BaseFragment implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.recyclerview)
    EasyRecyclerView recyclerview;
    private Handler mHandler = new Handler();
    private RecyclerArrayAdapter adapter;
    private static NewsBean mTopNewsBean, mShehuiNewsBean, mGuoneiNewsBean;
    private static final String NEWTYPE = "type";
    private String type;

    public NewsFragment() {

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.e("tag","-------->setUserVisibleHint");
        Log.e("tah","isVisibleToUse:"+isVisibleToUser);
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onAttach(Context context) {
        Log.e("tag","-------->onAttach");
        super.onAttach(context);
    }

    public static NewsFragment newInstance(NewsBean topNewsBean, NewsBean shehuiNewsBean, NewsBean guoneiNewsBean, String type) {
        mTopNewsBean = topNewsBean;
        mShehuiNewsBean = shehuiNewsBean;
        mGuoneiNewsBean = guoneiNewsBean;
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(NEWTYPE, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.e("tag","-------->onCreate");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycle, container, false);
        ButterKnife.bind(this, view);
        type = getArguments().getString(NEWTYPE);
        init();
        Log.e("tag","-------->onCreateView");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e("tag","-------->onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.e("tag","-------->onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.e("tag","-------->onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("tag","-------->onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e("tag","-------->onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e("tag","-------->onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("tag","-------->onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e("tag","-------->onDetach");
        super.onDetach();
    }

    private void init() {
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        DividerDecoration decoration = new DividerDecoration(Color.GRAY, Util.dip2px(getContext(), 0.5f), Util.dip2px(getActivity(), 72), 0);
        decoration.setDrawLastItem(false);
        recyclerview.addItemDecoration(decoration);
        recyclerview.setAdapterWithProgress((adapter = new RecyclerArrayAdapter(getContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {

                return new NewsHolder(parent);
            }
        }));
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);
        adapter.setOnItemLongClickListener(new RecyclerArrayAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(int position) {
                adapter.remove(position);
                return true;
            }
        });
        recyclerview.setRefreshListener(this);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("jacob", "oRefresh方法执行了");
                adapter.clear();
                switch (type) {
                    case "头条":
                        adapter.addAll(ChangeClass.changeNewsBeanToNews(mTopNewsBean));
                        break;
                    case "社会":
                        adapter.addAll(ChangeClass.changeNewsBeanToNews(mShehuiNewsBean));
                        break;
                    case "国内":
                        adapter.addAll(ChangeClass.changeNewsBeanToNews(mGuoneiNewsBean));
                        break;
                    default:
                        new Exception("没有找到对应的类型，可能是传递之间出错");
                        break;
                }
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, 2000);
    }

}
