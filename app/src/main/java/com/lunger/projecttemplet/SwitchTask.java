package com.lunger.projecttemplet;

/**
 * Created by Lunger on 2017/8/3 0003.
 */

import android.os.Handler;
import android.support.v4.view.ViewPager;

/**
 * ViewPager auto scroll task
 */
public class SwitchTask extends Handler implements Runnable {
    private ViewPager view_pager;

    public SwitchTask(ViewPager view_pager) {
        this.view_pager = view_pager;
    }

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
