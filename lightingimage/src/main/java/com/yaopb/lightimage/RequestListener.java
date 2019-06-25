package com.yaopb.lightimage;

import android.graphics.Bitmap;

public interface RequestListener {
   boolean onSuccess(Bitmap bitmap);
   boolean onFailed();
}
