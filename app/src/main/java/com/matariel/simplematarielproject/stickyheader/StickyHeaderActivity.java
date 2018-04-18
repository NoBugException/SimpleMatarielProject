package com.matariel.simplematarielproject.stickyheader;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stickyheaders.DrawOrder;
import com.example.stickyheaders.OnHeaderClickListener;
import com.example.stickyheaders.StickyHeadersBuilder;
import com.example.stickyheaders.StickyHeadersItemDecoration;
import com.matariel.simplematarielproject.BaseActivity;
import com.matariel.simplematarielproject.R;
import com.matariel.simplematarielproject.stickyheader.adapters.BigramHeaderAdapter;
import com.matariel.simplematarielproject.stickyheader.adapters.InitialHeaderAdapter;
import com.matariel.simplematarielproject.stickyheader.adapters.PersonAdapter;
import com.matariel.simplematarielproject.stickyheader.data.PersonDataProvider;

/**
 * Created by beixinyuan_android on 2018/4/18.
 */

public class StickyHeaderActivity extends BaseActivity implements OnHeaderClickListener {

    private RecyclerView list;
    private StickyHeadersItemDecoration top;
    private StickyHeadersItemDecoration overlay;
    private PersonDataProvider personDataProvider;
    private PersonAdapter personAdapter;

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_stickyheader, null);
    }

    @Override
    protected void initToolBar() {
        setCustomTitleVisibility(View.GONE);
        inflateMenu(R.menu.meun_sticky_header, new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.add_item) {
                    int addedPosition = personDataProvider.insertAfter(list.getChildPosition(list.getChildAt(0)));
                    personAdapter.notifyItemInserted(addedPosition);
                    return true;
                } else if (item.getItemId() == R.id.top_item) {
                    list.setAdapter(personAdapter);
                    list.removeItemDecoration(overlay);
                    list.addItemDecoration(top);
                    return true;
                } else if (item.getItemId() == R.id.overlay_item) {
                    list.setAdapter(personAdapter);
                    list.removeItemDecoration(top);
                    list.addItemDecoration(overlay);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void initView() {
        list = (RecyclerView)findViewById(R.id.list);

        list.setLayoutManager(new LinearLayoutManager(StickyHeaderActivity.this, LinearLayoutManager.VERTICAL, false));

        personDataProvider = new PersonDataProvider();
        personAdapter = new PersonAdapter(this, personDataProvider);

        top = new StickyHeadersBuilder()
                .setAdapter(personAdapter)
                .setRecyclerView(list)
                .setStickyHeadersAdapter(new BigramHeaderAdapter(personDataProvider.getItems()))
                .setOnHeaderClickListener(this)
                .setSticky(true)//true:header划到顶部时，动态停止并切换；false：无动态效果
                .setDrawOrder(DrawOrder.OverItems)//true：header在上面；false：header在下面
                .build();


        overlay = new StickyHeadersBuilder()
                .setAdapter(personAdapter)
                .setRecyclerView(list)
                .setStickyHeadersAdapter(new InitialHeaderAdapter(personDataProvider.getItems()), true)
                .build();

        list.setAdapter(personAdapter);
        list.removeItemDecoration(overlay);
        list.addItemDecoration(top);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onHeaderClick(View header, long headerId) {
        TextView text = (TextView)header.findViewById(R.id.title);
        Toast.makeText(getApplicationContext(), "Click on " + text.getText(), Toast.LENGTH_SHORT).show();
    }
}
