package example.com.mvpnews.ui.view.dapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import example.com.mvpnews.bean.NewsBean;
import example.com.mvpnews.ui.view.fragment.NewsFragment;

/**
 * Created by ASUS-NB on 2016/12/5.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    private String[] mTitle={"头条","社会","国内"};
    private NewsBean topNewsBean,shehuiNewsBean,guoneiNewsBean;

    public FragmentAdapter(FragmentManager fm, NewsBean topNewsBeans,NewsBean shehuiNewsBean,NewsBean guoneiNewsBean) {
        super(fm);
        this.shehuiNewsBean = shehuiNewsBean;
        this.topNewsBean = topNewsBeans;
        this.guoneiNewsBean = guoneiNewsBean;
    }

    @Override
    public Fragment getItem(int position) {
        return NewsFragment.newInstance(topNewsBean,shehuiNewsBean,guoneiNewsBean,mTitle[position]);

    }

    @Override
    public int getCount() {
        return mTitle.length;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle[position];
    }
}
