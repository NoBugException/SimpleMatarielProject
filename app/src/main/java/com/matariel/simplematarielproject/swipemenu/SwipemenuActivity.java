package com.matariel.simplematarielproject.swipemenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.matariel.simplematarielproject.BaseActivity;
import com.matariel.simplematarielproject.R;

/**
 * Created by beixinyuan_android on 2018/4/23.
 */

public class SwipemenuActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipemenu);

    }

    @Override
    protected View getTitleView() {
        return null;
    }

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_swipemenu, null);
    }

    @Override
    protected void initToolBar() {

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

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.button1:
                startActivity(new Intent(this, SimpleActivity.class));
                break;
            case R.id.button2:
                startActivity(new Intent(this, DifferentMenuActivity.class));
                break;
        }
    }
}
