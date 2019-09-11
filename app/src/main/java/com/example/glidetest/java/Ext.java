package com.example.glidetest.java;

import android.content.Context;

public class Ext {


    /**
     * px ->dp
     * @param context
     * @param value
     * @return
     */
    public static int get(Context context, int value) {
        return (int) (value * context.getResources().getDisplayMetrics().density);
    }
}
