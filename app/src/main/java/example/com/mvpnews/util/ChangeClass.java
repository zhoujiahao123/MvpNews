package example.com.mvpnews.util;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import example.com.mvpnews.News;
import example.com.mvpnews.bean.NewsBean;

/**
 * Created by ASUS-NB on 2016/12/3.
 */

public class ChangeClass {
    public static List<News> changeNewsBeanToNews(NewsBean newsBean){
        List<News> list = new ArrayList<>();
        int i=newsBean.getResult().getData().size();
        for(int j=0;j<i;j++){
            News news = new News();
            news.setId(null);
            news.setTitle(newsBean.getResult().getData().get(j).getTitle());
            news.setContentUrl(newsBean.getResult().getData().get(j).getUrl());
            news.setImageUrl(newsBean.getResult().getData().get(j).getThumbnail_pic_s());
            news.setDate(newsBean.getResult().getData().get(j).getDate());
            list.add(news);
        }
        for(News news1:list){
        }
        return list;
    }
}
