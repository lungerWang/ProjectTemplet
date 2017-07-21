package com.lunger.projecttemplet.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.greenrobot.event.EventBus;

/**
 * Created by Lunger on 2017/7/21.
 */

public abstract class BaseActivity<T> extends AppCompatActivity{

    protected Context mContext;
    private Unbinder mUnBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        EventBus.getDefault().register(this);
        mUnBinder = ButterKnife.bind(this);
        initWidget();
        initData();
        mContext = this;
    }

    public abstract int bindLayout();

    public abstract void initWidget();

    public abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 事件回调方法,主线程执行
     *
     * @param event
     */
    public abstract void onEventMainThread(T event);
}
