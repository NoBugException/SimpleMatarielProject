package com.matariel.simplematarielproject.pulltozoom;

import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.ecloud.pulltozoomview.PullToZoomListViewEx;
import com.matariel.simplematarielproject.BaseActivity;
import com.matariel.simplematarielproject.R;

/**
 * Author:    ZhuWenWu
 * Version    V1.0
 * Date:      2014/9/4  17:11.
 * Description:
 * Modification  History:
 * Date         	Author        		Version        	Description
 * -----------------------------------------------------------------------------------
 * 2014/9/4        ZhuWenWu            1.0                    1.0
 * Why & What is modified:
 */
public class PullToZoomListActivity extends BaseActivity {

    private PullToZoomListViewEx listView;

    @Override
    protected View getTitleView() {
        return null;
    }

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_pull_to_zoom_list_view, null);
    }

    @Override
    protected void initToolBar() {
        inflateMenu(R.menu.list_view, new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == android.R.id.home) {
                    finish();
                    return true;
                } else if (id == R.id.action_normal) {
                    listView.setParallax(false);
                    return true;
                } else if (id == R.id.action_parallax) {
                    listView.setParallax(true);
                    return true;
                } else if (id == R.id.action_show_head) {
                    listView.setHideHeader(false);
                    return true;
                } else if (id == R.id.action_hide_head) {
                    listView.setHideHeader(true);
                    return true;
                } else if (id == R.id.action_disable_zoom) {
                    listView.setZoomEnabled(false);
                    return true;
                } else if (id == R.id.action_enable_zoom) {
                    listView.setZoomEnabled(true);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void initView() {

        listView = (PullToZoomListViewEx) findViewById(R.id.listview);

        String[] adapterData = new String[]{"Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient"};

        listView.setAdapter(new ArrayAdapter<String>(PullToZoomListActivity.this, android.R.layout.simple_list_item_1, adapterData));
        listView.getPullRootView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("yunchong", "position = " + position);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("yunchong", "position = " + position);
            }
        });

        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        AbsListView.LayoutParams localObject = new AbsListView.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        listView.setHeaderLayoutParams(localObject);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
