package com.lunger.projecttemplet.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import de.greenrobot.event.EventBus;

/**
 * Created by Lunger on 2017/7/21.
 */

public abstract class BaseFragment<T> extends Fragment{

    protected Context mContext;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.mContext = this.getActivity();
        EventBus.getDefault().register(this);
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 事件回调方法,主线程执行
     *
     * @param event
     */
    public abstract void onEventMainThread(T event);
}
