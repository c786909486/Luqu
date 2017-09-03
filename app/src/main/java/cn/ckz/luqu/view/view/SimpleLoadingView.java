package cn.ckz.luqu.view.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by CKZ on 2017/8/17.
 */

public class SimpleLoadingView extends View {
    private static final String TAG = "SimpleLoadingView";

    private static final int DAFULT_COLOR = Color.parseColor("#e8e8e8");//默认颜色

    private int width;

    private int height;

    private int color = Color.WHITE;//背景色

    private Paint outPaint = new Paint();//外圆画笔

    private Paint mPain = new Paint();//progress画笔

    private int progress;//进度

    private RectF rectF;

    private float startAngle = -90;//开始角度

    private float mmSweepAngleStart = 0f;//起点

    private float mSweepAngle = mmSweepAngleStart;//扫过的角度

    private int lastProgress;

    public SimpleLoadingView(Context context) {
        this(context,null);
    }

    public SimpleLoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SimpleLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init(){
        width = getWidth();
        height = getHeight();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        if (width > height) {
            setMeasuredDimension(height, height);
        } else {
            setMeasuredDimension(width, width);
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        if (progress>0 && progress<100){
            init();
            outPaint.setAntiAlias(true);
            outPaint.setColor(color);
            outPaint.setStyle(Paint.Style.STROKE);
            outPaint.setStrokeWidth(4);
            canvas.drawCircle(width/2,height/2,width<height?width/2-4:height/2-4,outPaint);
            mPain.setAntiAlias(true);
            mPain.setColor(color);
            mPain.setStyle(Paint.Style.FILL);
            rectF = new RectF(12,12,width-12,height-12);
            mSweepAngle = 360*progress/100;
            canvas.drawArc(rectF,startAngle,mSweepAngle,true,mPain);
        }
        lastProgress = progress;
        if (listener!=null&&progress>=100){
            listener.onFinish();
            progress = 0;
            lastProgress = 0;
            animator.cancel();
            setVisibility(GONE);
        }
    }

    public SimpleLoadingView setProgress(int progress){
        this.progress = progress;
//        start();
        invalidate();
//        Log.d(TAG,progress+""+lastProgress);
        return this;
    }
    private ValueAnimator animator;
    public SimpleLoadingView start(){
        setVisibility(VISIBLE);
        animator = ValueAnimator.ofFloat(lastProgress,progress);
        animator.setDuration(500);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float current = (float) animator.getAnimatedValue();
                setProgress((int) current);
            }
        });
        animator.start();
        return this;
    }

    private OnFinishListener listener;
    public void setOnFinishListener(OnFinishListener listener){
        this.listener = listener;
    }
    public interface OnFinishListener{
        void onFinish();
    }
}
