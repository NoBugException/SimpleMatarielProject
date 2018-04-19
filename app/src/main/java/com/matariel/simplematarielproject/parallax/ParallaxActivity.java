package com.matariel.simplematarielproject.parallax;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.list.parallax.ParallaxScollListView;
import com.matariel.simplematarielproject.BaseActivity;
import com.matariel.simplematarielproject.R;

public class ParallaxActivity extends BaseActivity {

    private ParallaxScollListView mListView;
    private ImageView mImageView;

    @Override
    protected View getTitleView() {
        return View.inflate(this, R.layout.layout_title_base, null);
    }

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_parallax, null);
    }

    @Override
    protected void initToolBar() {
        TextView tv_title = getView(R.id.tv_title);
        tv_title.setText("ParallaxScollListView");
    }

    @Override
    protected void initView() {

        mListView = (ParallaxScollListView) findViewById(R.id.layout_listview);
        View header = LayoutInflater.from(this).inflate(R.layout.listview_header, null);
        mImageView = (ImageView) header.findViewById(R.id.layout_header_image);

        mListView.setZoomRatio(ParallaxScollListView.ZOOM_X2);
        mListView.setParallaxImageView(mImageView);
        mListView.addHeaderView(header);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,
                new String[]{
                        "First Item",
                        "Second Item",
                        "Third Item",
                        "Fifth Item",
                        "Sixth Item",
                        "Seventh Item",
                        "Eighth Item",
                        "Ninth Item",
                        "Tenth Item",
                        "....."
                }
        );
        mListView.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
