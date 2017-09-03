package cn.ckz.luqu.view.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.ckz.luqu.R;
import cn.ckz.luqu.view.fragment.ImageFragment;
import cn.ckz.luqu.view.fragment.TextFragment;
import cn.ckz.luqu.view.fragment.VideoFragment;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView mImage;
    private TextView mVideo;
    private TextView mText;
    private FragmentManager fm;

    //fragment
    private ImageFragment imageFragment;
    private VideoFragment videoFragment;
    private TextFragment textFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initFragment();
        setClick();
        mImage.performClick();
    }

    private void setClick() {
        mImage.setOnClickListener(this);
        mVideo.setOnClickListener(this);
        mText.setOnClickListener(this);
    }

    private void initFragment(){
        fm = getSupportFragmentManager();
    }

    private void init() {
        mImage = findViewById(R.id.image_btn);
        mVideo = findViewById(R.id.video_btn);
        mText = findViewById(R.id.text_btn);
        mImage.setOnClickListener(this);
        mVideo.setOnClickListener(this);
        mText.setOnClickListener(this);
    }

    //充值状态
    private void resetSelect(){
        mImage.setSelected(false);
        mVideo.setSelected(false);
        mText.setSelected(false);
    }
    private void hideAllFragment(FragmentTransaction transaction){
        if (imageFragment!=null) transaction.hide(imageFragment);
        if (videoFragment!=null) transaction.hide(videoFragment);
        if (textFragment!=null) transaction.hide(textFragment);
    }


    @Override
    public void onClick(View view) {
        FragmentTransaction transaction = fm.beginTransaction();
        hideAllFragment(transaction);
        switch (view.getId()){
            case R.id.image_btn:
                resetSelect();
                mImage.setSelected(true);
                if (imageFragment==null){
                    imageFragment = new ImageFragment();
                    transaction.add(R.id.main_fragment,imageFragment);
                }else {
                    transaction.show(imageFragment);
                }

                break;
            case R.id.video_btn:
                resetSelect();
                mVideo.setSelected(true);
                if (videoFragment == null){
                    videoFragment = new VideoFragment();
                    transaction.add(R.id.main_fragment,videoFragment);
                }else {
                    transaction.show(videoFragment);
                }

                break;
            case R.id.text_btn:
                resetSelect();
                mText.setSelected(true);
                if (textFragment == null){
                    textFragment = new TextFragment();
                    transaction.add(R.id.main_fragment,textFragment);
                }else {
                    transaction.show(textFragment);
                }
                break;
        }
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
}
