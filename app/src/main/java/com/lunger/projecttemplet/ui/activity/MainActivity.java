package com.lunger.projecttemplet.ui.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.lunger.projecttemplet.R;
import com.lunger.projecttemplet.ui.adapter.GoodsAdapter;
import com.lunger.projecttemplet.ui.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rlv)
    RecyclerView rlv;


    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
    }



    @Override
    public void initWidget() {
        rlv.setAdapter(new GoodsAdapter(this));
        rlv.setLayoutManager(new LinearLayoutManager(this));
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
