package com.matariel.simplematarielproject.nice_spinner;

import android.view.View;
import android.widget.TextView;

import com.matariel.simplematarielproject.BaseActivity;
import com.matariel.simplematarielproject.R;
import com.nice.spinner.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by beixinyuan_android on 2018/4/18.
 */

public class NiceSpinnerActivity extends BaseActivity {

    @Override
    protected View getTitleView() {
        return View.inflate(this, R.layout.layout_title_base, null);
    }

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_nicespinner, null);
    }

    @Override
    protected void initToolBar() {
        TextView tv_title = getView(R.id.tv_title);
        tv_title.setText("NiceSpinner");
    }

    @Override
    protected void initView() {
        NiceSpinner niceSpinner = (NiceSpinner) findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        niceSpinner.attachDataSource(dataset);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
