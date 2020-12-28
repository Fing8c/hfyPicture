package com.hfy.matisse.internal.utils;

import android.os.Build;

/**
 * @author hfy
 * @description
 * @time 2020/7/17
 */
public class Platform {
    public static boolean hasICS() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    }

    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }
}
