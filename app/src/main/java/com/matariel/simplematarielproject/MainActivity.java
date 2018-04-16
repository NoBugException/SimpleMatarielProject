package com.matariel.simplematarielproject;

import android.view.View;

public class MainActivity extends BaseActivity {



    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_main, null);
    }

    @Override
    protected void initToolBar() {
        setToolbarTitle("MatarielDemos");
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
