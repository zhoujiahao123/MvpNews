package example.com.mvpnews.ui.view.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import example.com.mvpnews.News;
import example.com.mvpnews.R;
import example.com.mvpnews.app.BaseActivity;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by ASUS-NB on 2016/12/3.
 */

public class NewsHolder extends BaseViewHolder<News>{
    private ImageView img;
    private TextView mTitle,mContent;

    public NewsHolder(ViewGroup parent) {
        super(parent, R.layout.recycle_item);
        mTitle=$(R.id.tv_title);
        mContent = $(R.id.tv_content);
        img = $(R.id.image);
    }

    @Override
    public void setData(final News data) {
        mTitle.setText(data.getTitle());
        mContent.setText(data.getTitle());
        Glide.with(getContext())
                .load(data.getImageUrl())
                .placeholder(R.drawable.ic_top)
                .bitmapTransform(new CropCircleTransformation(getContext()))
                .into(img);
    }
}
