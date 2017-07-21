package com.lunger.projecttemplet.util;

import android.support.annotation.StringRes;
import android.view.Gravity;
import android.widget.Toast;

import com.lunger.projecttemplet.MyApplication;


/**
 * Created by Lunger on 2017/6/2.
 */
public class CustomToast {

    /**
     * 防止Toast重复显示
     */
    private static Toast mToast = null;

    /**
     * 字符串提示
     *
     * @param message
     * @param params
     */
    public static void makeText(String message, int... params) {

        int showtime = params.length > 0 ? params[0] : Toast.LENGTH_SHORT;

        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.getInstance(), message, showtime);
        } else {
            mToast.setText(message);
            mToast.setDuration(showtime);
        }
        mToast.show();
    }

    /**
     * StringRes 提示
     *
     * @param message
     * @param params
     */
    public static void makeText(@StringRes int message, int... params) {

        int showtime = params.length > 0 ? params[0] : Toast.LENGTH_SHORT;

        if (mToast == null) {
            mToast = Toast.makeText(MyApplication.getInstance(), message, showtime);
            mToast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            mToast.setText(message);
            mToast.setDuration(showtime);
        }
        mToast.show();
    }

}
