package com.example.vuandroidadsdk.glideLoader.progress;

import com.bumptech.glide.load.engine.GlideException;

/**
 * Created by CKZ on 2017/8/17.
 */

public interface OnProgressListener {
    void onProgress(String imageUrl, long bytesRead, long totalBytes, boolean isDone, GlideException exception);
}
