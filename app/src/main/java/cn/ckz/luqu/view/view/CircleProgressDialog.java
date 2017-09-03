package cn.ckz.luqu.view.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ProgressBar;

/**
 * Created by CKZ on 2017/8/26.
 */

public class CircleProgressDialog extends Dialog {

    private static final String TAG = "CircleProgressDialog";

    private CircleProgress mProgress;

    public CircleProgressDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProgress = new CircleProgress(getContext());
        mProgress.setRadius(0.1f);
        mProgress.setDuration(2400);
        setContentView(mProgress);

        setCanceledOnTouchOutside(false);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    public void start(){
        show();
        mProgress.startAnim();
        Log.d(TAG,"开始");
    }

    public void stop(){
        mProgress.stopAnim();
        dismiss();
        Log.d(TAG,"停止");
    }
}
