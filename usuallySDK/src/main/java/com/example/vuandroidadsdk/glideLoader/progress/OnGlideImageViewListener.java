package com.example.vuandroidadsdk.glideLoader.progress;

import com.bumptech.glide.load.engine.GlideException;

/**
 * Created by CKZ on 2017/8/17.
 */

public interface OnGlideImageViewListener {
    void onProgress(int percent, boolean isDone, GlideException exception);
}
