package com.lunger.projecttemplet.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lunger.projecttemplet.R;
import com.lunger.projecttemplet.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.activity_main)
    RelativeLayout mActivityMain;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget() {

    }

    @Override
    public void initData() {

    }
}
