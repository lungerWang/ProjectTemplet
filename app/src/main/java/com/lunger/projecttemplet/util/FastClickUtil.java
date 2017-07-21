package com.lunger.projecttemplet.util;

import android.view.View;

/**
 * Created by Lunger on 2017/7/21.
 * 判断按钮是否快速点击
 */

public class FastClickUtil {
    private static long lastTime = 0;
    private static int lastViewId = -1;
    private static int lastViewHashCode = -1;

    public static boolean isButtonFastClick(View view) {

        if (view == null) return false;

        int id = view.getId();
        long now = System.currentTimeMillis();
        int hashCode = System.identityHashCode(view);

        // 如果大于最大限制值直接不需要处理后面的代码了
        boolean fast = (now - lastTime < 2000);

        if (fast) {

            if (lastViewId == id
                    && lastViewHashCode == hashCode) {
                // 同一个控件，最小间隔400ms
                fast = (now - lastTime < 400);
            } else {
                // 不同控件，最小间隔200ms
                //fast = (now - lastTime < 200);
                return false;//不同控件不做限制
            }

            if (fast) {
                return true;
            }
        }

        // 重新设置时间
        lastTime = now;
        lastViewId = id;
        lastViewHashCode = hashCode;

        return false;
    }
}
