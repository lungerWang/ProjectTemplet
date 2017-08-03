package com.lunger.projecttemplet.ui.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lunger.projecttemplet.R;
import com.lunger.projecttemplet.ui.adapter.HomeRecycleAdapter;
import com.lunger.projecttemplet.ui.base.BaseActivity;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.refreshLayout)
    RefreshLayout refreshLayout;
    private HomeRecycleAdapter mHomeRecycleAdapter;


    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
    }



    @Override
    public void initWidget() {
        mHomeRecycleAdapter = new HomeRecycleAdapter(this);
        rlv.setAdapter(mHomeRecycleAdapter);
        rlv.setLayoutManager(new LinearLayoutManager(this));
        refreshLayout.setEnableRefresh(false);

        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
                mHomeRecycleAdapter.addData();
            }
        });

    }

    @Override
    protected void initListener() {

    }


    @Override
    public void onEventMainThread(Object event) {

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
