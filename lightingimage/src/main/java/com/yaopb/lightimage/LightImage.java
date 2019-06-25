package com.yaopb.lightimage;

import android.content.Context;

/**
 *
 */
public class LightImage {
    public static BitmapRequest with(Context context) {
        return new BitmapRequest(context);
    }
}
