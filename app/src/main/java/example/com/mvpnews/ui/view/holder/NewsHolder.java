package example.com.mvpnews.ui.view.holder;

import android.media.Image;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import example.com.mvpnews.News;
import example.com.mvpnews.R;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by ASUS-NB on 2016/12/5.
 */

public class NewsHolder extends BaseViewHolder<News> {
    private ImageView mImage;
    private TextView mTitle,mContent;
    public NewsHolder(ViewGroup parent) {
        super(parent, R.layout.recycle_item);
        mImage = $(R.id.image);
        mTitle = $(R.id.tv_title);
        mContent = $(R.id.tv_content);

    }

    @Override
    public void setData(News data) {
        mTitle.setText(data.getTitle());
        //这里注意一下，是因为点击过后才能看见详情
        mContent.setText(data.getTitle());
        Glide.with(getContext()).load(data.getImageUrl())
                .placeholder(R.drawable.ic_top)
                .centerCrop()
                .into(mImage);
    }
}
