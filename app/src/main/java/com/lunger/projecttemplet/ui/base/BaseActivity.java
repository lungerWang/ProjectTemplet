package com.lunger.projecttemplet.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lunger on 2017/7/21.
 */

public abstract class BaseActivity extends AppCompatActivity{

    private Unbinder mUnBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnBinder = ButterKnife.bind(this);
        initWidget();
        initData();
    }

    public abstract int getLayoutId();

    public abstract void initWidget();

    public abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }
}
