package com.matariel.simplematarielproject.pulltozoom.recyclerview;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import com.ecloud.pulltozoomview.PullToZoomRecyclerViewEx;
import com.ecloud.pulltozoomview.RecyclerViewHeaderAdapter;
import com.matariel.simplematarielproject.BaseActivity;
import com.matariel.simplematarielproject.R;


/**
 * Created by manishdeora on 13/05/15.
 */
public class PullToZoomRecyclerActivity extends BaseActivity {
    private PullToZoomRecyclerViewEx listView;

    @Override
    protected View getTitleView() {
        return null;
    }

    @Override
    protected View getRootView() {
        return View.inflate(this, R.layout.activity_pull_to_zoom_recycler_view, null);
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
        listView = (PullToZoomRecyclerViewEx) findViewById(R.id.recyclerview);


        final RecyclerViewHeaderAdapter mAdapter = new RecyclerAdapterCustom(this);

        final GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return mAdapter.getItemViewType(position) == RecyclerViewHeaderAdapter.INT_TYPE_HEADER ? 2 : 1;
            }
        });
        listView.setAdapterAndLayoutManager(mAdapter, manager);


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

    public class RecyclerAdapterCustom extends RecyclerViewHeaderAdapter<ViewHolderRecyclerPullToZoom> {
        final String[] adapterData = new String[]{"Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent", "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient",
                "DDMS", "Android Studio", "Fragment", "Loader", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient", "Activity", "Service", "Content Provider", "Intent",
                "BroadcastReceiver", "ADT", "Sqlite3", "HttpClient"};

        public RecyclerAdapterCustom(Context context) {
            super(context);
        }

        @Override
        public int getCount() {
            return adapterData.length;
        }

        @Override
        public ViewHolderRecyclerPullToZoom onCreateContentView(ViewGroup parent, int viewType) {
            return new ViewHolderRecyclerPullToZoom(new TextView(getContext()));
        }

        @Override
        public void onBindView(ViewHolderRecyclerPullToZoom view, int position) {

            view.mtextview.setText(adapterData[position]);

//            final StaggeredGridLayoutManager.LayoutParams lp =
//                    (StaggeredGridLayoutManager.LayoutParams) view.mtextview.getLayoutParams();
////
//            lp.span = span;
//            lp.height = size;
//            itemView.setLayoutParams(lp);


        }
    }

    public static class ViewHolderRecyclerPullToZoom extends RecyclerView.ViewHolder {

        TextView mtextview;

        public ViewHolderRecyclerPullToZoom(View itemView) {
            super(itemView);

            mtextview = (TextView) itemView;
        }
    }
}