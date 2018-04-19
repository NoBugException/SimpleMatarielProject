package com.matariel.simplematarielproject.flabbyview;

import android.view.View;
import android.widget.TextView;

import com.flabbyview.listview.FlabbyListView;
import com.matariel.simplematarielproject.BaseActivity;
import com.matariel.simplematarielproject.R;

import java.util.ArrayList;

/**
 * Created by beixinyuan_android on 2018/4/18.
 */

public class FlabbyActivity extends BaseActivity {

    private ArrayList<String> list;
    private ListAdapter adapter;

    @Override
    protected View getTitleView() {
        return View.inflate(this, R.layout.layout_title_base, null);
    }

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_flabby, null);
    }

    @Override
    protected void initToolBar() {
        TextView tv_title = getView(R.id.tv_title);
        tv_title.setText("FlabbyView");
    }

    @Override
    protected void initView() {
        //构造数据源
        list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("数据源" + i);
        }

        //为适配器添加数据源
        adapter = new ListAdapter(this, list);
        //为listView的容器添加适配器
        FlabbyListView flabbyListView = (FlabbyListView) findViewById(R.id.flabbylist);
        flabbyListView.setAdapter(adapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
