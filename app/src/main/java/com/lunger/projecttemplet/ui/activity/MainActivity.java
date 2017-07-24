package com.lunger.projecttemplet.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.lunger.projecttemplet.R;
import com.lunger.projecttemplet.ui.adapter.BannerPagerAdapter;
import com.lunger.projecttemplet.ui.base.BaseActivity;
import com.lunger.projecttemplet.util.DensityUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.activity_main)
    RelativeLayout activity_main;
    @BindView(R.id.view_pager)
    ViewPager view_pager;
    @BindView(R.id.ll_dot_container)
    LinearLayout ll_dot_container;

    //模拟网络拿到的banner轮播图
    private String[] imageUrls = {"http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg",
            "http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",
            "http://pic18.nipic.com/20111215/577405_080531548148_2.jpg",
            "http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",
            "http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg"};

    private List<View> mBannerViews;
    private List<ImageView> mBannerDots;
    private SwitchTask mSwitchTask;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        mBannerViews = new ArrayList<>();
        mBannerDots = new ArrayList<>();
        initBanner();
    }

    /**
     * 初始化顶部banner数据
     */
    private void initBanner() {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        ImageView iv_dot;
        for (int i = 0; i < imageUrls.length; i++) {
            View view = layoutInflater.inflate(R.layout.view_banner, null);
            ImageView iv_banner = (ImageView) view.findViewById(R.id.iv_banner);
            Glide.with(this)
                    .load(imageUrls[i])
                    .asBitmap()
                    .into(iv_banner);
            mBannerViews.add(view);

            //初始化圆点
            iv_dot = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(DensityUtils.dp2px(this, 8), DensityUtils.dp2px(this, 8));
            if (i != 0) {
                params.setMargins(10, 0, 0, 0);
                iv_dot.setImageResource(R.drawable.shape_white_dot);
            } else {
                iv_dot.setImageResource(R.drawable.shape_red_dot);
            }
            iv_dot.setLayoutParams(params);
            ll_dot_container.addView(iv_dot);
            mBannerDots.add(iv_dot);
        }
    }

    @Override
    public void initWidget() {
        view_pager.setAdapter(new BannerPagerAdapter(mBannerViews));

        mSwitchTask = new SwitchTask();
        mSwitchTask.start();
    }

    @Override
    protected void initListener() {
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mBannerDots.size(); i++) {
                    mBannerDots.get(i).setImageResource(i == position ? R.drawable.shape_red_dot : R.drawable.shape_white_dot);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onEventMainThread(Object event) {

    }

    /**
     * ViewPager auto scroll task
     */
    private class SwitchTask extends Handler implements Runnable {

        @Override
        public void run() {
            int currentItem = view_pager.getCurrentItem();
            if (currentItem == view_pager.getAdapter().getCount() - 1) {
                currentItem = 0;
            } else {
                currentItem += 1;
            }
            view_pager.setCurrentItem(currentItem);
            this.postDelayed(this, 2500);
        }

        public void start() {
            this.removeCallbacks(this);
            this.postDelayed(this, 2500);
        }

        public void stop() {
            this.removeCallbacks(this);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mSwitchTask != null) {
            mSwitchTask.stop();
        }
    }
}
