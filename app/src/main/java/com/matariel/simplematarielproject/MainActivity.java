package com.matariel.simplematarielproject;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.listandgrid.multil_type_support.BaseBean;
import com.listandgrid.multil_type_support.CommonViewHolder;
import com.listandgrid.multil_type_support.MultiItemCommonAdapter;
import com.listandgrid.multil_type_support.MultiItemTypeSupport;
import com.matariel.simplematarielproject.flabbyview.FlabbyActivity;
import com.matariel.simplematarielproject.multirecycleview.BBaseBean;
import com.matariel.simplematarielproject.multirecycleview.MaterialItemViewType;
import com.matariel.simplematarielproject.stickyheader.StickyHeaderActivity;
import com.matariel.simplematarielproject.swipedismissrecyclerview.SwipeDismissRecyclerActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private RecyclerView mRecyclerView;

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
        mRecyclerView = (RecyclerView) findViewById(R.id.materialdesign_recycle);
    }

    @Override
    protected void initData() {
        mRecyclerView = (RecyclerView) findViewById(R.id.materialdesign_recycle);


        List<BaseBean> mDatas = new ArrayList<>();
        BBaseBean bBaseBean1 = new BBaseBean();
        bBaseBean1.setFlag(1);
        bBaseBean1.setName("滑动删除的recycleview");
        mDatas.add(bBaseBean1);

        BBaseBean bBaseBean2 = new BBaseBean();
        bBaseBean2.setFlag(2);
        bBaseBean2.setName("FlabbyView");
        mDatas.add(bBaseBean2);

        BBaseBean bBaseBean3 = new BBaseBean();
        bBaseBean3.setFlag(3);
        bBaseBean3.setName("带头部的recycleview");
        mDatas.add(bBaseBean3);

        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        //设置RecyclerView 布局
        mRecyclerView.setLayoutManager(layoutmanager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(new MultiItemCommonAdapter<BaseBean>(this, mDatas, new MultiItemTypeSupport() {
            @Override
            public int getLayoutId(int itemType) {
                int layoutId = -1;
                switch (itemType){
                    case MaterialItemViewType.BASE:
                        layoutId =  R.layout.item_base;
                        break;
                }
                return layoutId;
            }

            @Override
            public int getItemViewType(int position, Object o) {
                return MaterialItemViewType.BASE;
            }
        }) {
            @Override
            public void convert(CommonViewHolder holder, BaseBean baseBean) {
                //填充
                TextView type;
                TextView mame;
                switch (baseBean.getItemViewType()){
                    case MaterialItemViewType.BASE:
                        final BBaseBean bbaseBean = (BBaseBean) baseBean;
                        mame = holder.getView(R.id.id_item_materialname);
                        mame.setText(bbaseBean.getName());
                        type = holder.getView(R.id.id_item_materialtype);
                        type.setText(String.valueOf(bbaseBean.getItemViewType()));
                        holder.setOnClickListener(R.id.root, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(bbaseBean.getFlag() == 1){
                                    startActivity(SwipeDismissRecyclerActivity.class);
                                }else if(bbaseBean.getFlag() == 2){
                                    startActivity(FlabbyActivity.class);
                                }else if(bbaseBean.getFlag() == 3){
                                    startActivity(StickyHeaderActivity.class);
                                }
                            }
                        });
                        break;
                }
            }
        });
    }

    @Override
    protected void initListener() {

    }
}
