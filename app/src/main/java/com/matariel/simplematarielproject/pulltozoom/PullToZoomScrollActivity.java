package com.matariel.simplematarielproject.pulltozoom;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;
import com.matariel.simplematarielproject.BaseActivity;
import com.matariel.simplematarielproject.R;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2014/9/4  17:30.
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2014/9/4        ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class PullToZoomScrollActivity extends BaseActivity {

    private PullToZoomScrollViewEx scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected View getTitleView() {
        return null;
    }

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_pull_to_zoom_scroll_view, null);
    }

    @Override
    protected void initToolBar() {
        inflateMenu(R.menu.scroll_view, new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == android.R.id.home) {
                    finish();
                    return true;
                } else if (id == R.id.action_normal) {
                    scrollView.setParallax(false);
                    return true;
                } else if (id == R.id.action_parallax) {
                    scrollView.setParallax(true);
                    return true;
                } else if (id == R.id.action_show_head) {
                    scrollView.setHideHeader(false);
                    return true;
                } else if (id == R.id.action_hide_head) {
                    scrollView.setHideHeader(true);
                    return true;
                } else if (id == R.id.action_disable_zoom) {
                    scrollView.setZoomEnabled(false);
                    return true;
                } else if (id == R.id.action_enable_zoom) {
                    scrollView.setZoomEnabled(true);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void initView() {
        loadViewForCode();
        scrollView = (PullToZoomScrollViewEx) findViewById(R.id.scroll_view);
        scrollView.getPullRootView().findViewById(R.id.tv_test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("yunchong", "onClick -->");
            }
        });

        scrollView.getPullRootView().findViewById(R.id.tv_test2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("yunchong", "onClick -->");
            }
        });

        scrollView.getPullRootView().findViewById(R.id.tv_test3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("yunchong", "onClick -->");
            }
        });
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        scrollView.setHeaderLayoutParams(localObject);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    private void loadViewForCode() {
        PullToZoomScrollViewEx scrollView = (PullToZoomScrollViewEx) findViewById(R.id.scroll_view);
        View headView = LayoutInflater.from(this).inflate(R.layout.profile_head_view, null, false);
        View zoomView = LayoutInflater.from(this).inflate(R.layout.profile_zoom_view, null, false);
        View contentView = LayoutInflater.from(this).inflate(R.layout.profile_content_view, null, false);
        scrollView.setHeaderView(headView);
        scrollView.setZoomView(zoomView);
        scrollView.setScrollContentView(contentView);
    }
}
