package cn.ckz.luqu.view.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import cn.ckz.luqu.R;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by CKZ on 2017/2/25.
 */

public class JCVideoCustom extends JCVideoPlayerStandard {

    public TextView play_counts;
    public TextView total_duration;
    private RelativeLayout show_counts_layout;
    private LinearLayout top_layout;
    public ImageView downloadBtn;
    public JCVideoCustom(Context context) {
        super(context);
    }

    public JCVideoCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void init(Context context) {
        super.init(context);
        play_counts = (TextView) this.findViewById(R.id.play_counts);
        total_duration = (TextView) this.findViewById(R.id.total_duration);
        show_counts_layout = (RelativeLayout) this.findViewById(R.id.show_counts_layout);
        top_layout = (LinearLayout) this.findViewById(R.id.layout_top);
        downloadBtn = (ImageView) this.findViewById(R.id.download_btn);
    }

    @Override
    public void setUp(String url, int screen, Object... objects) {
        super.setUp(url, screen, objects);
        FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE;
    }
    @Override
    public int getLayoutId() {
        return R.layout.jc_video_custom;
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void setUiWitStateAndScreen(int state) {
        super.setUiWitStateAndScreen(state);
        if (state == 0){
            top_layout.setVisibility(INVISIBLE);
            show_counts_layout.setVisibility(VISIBLE);
        }else {
            show_counts_layout.setVisibility(GONE);
            top_layout.setVisibility(VISIBLE);
        }
        if (this.currentScreen == 0){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                this.topContainer.setBackground(getResources().getDrawable(R.drawable.white_bg,null));
            }else {
                this.topContainer.setBackground(getResources().getDrawable(R.drawable.white_bg));
            }
        }else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                this.topContainer.setBackground(getResources().getDrawable(R.drawable.jc_title_bg,null));
            }else {
                this.topContainer.setBackground(getResources().getDrawable(R.drawable.jc_title_bg));
            }
        }
    }
}
