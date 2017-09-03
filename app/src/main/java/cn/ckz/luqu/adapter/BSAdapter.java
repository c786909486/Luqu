package cn.ckz.luqu.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.example.vuandroidadsdk.glideLoader.GlideImageLoader;
import com.example.vuandroidadsdk.glideLoader.progress.OnGlideImageViewListener;
import com.example.vuandroidadsdk.okhttp.CommonOkHttpClient;
import com.example.vuandroidadsdk.okhttp.listener.DisposeDataHandle;
import com.example.vuandroidadsdk.okhttp.listener.DisposeDataListener;
import com.example.vuandroidadsdk.okhttp.request.CommonRequest;
import com.example.vuandroidadsdk.utils.ShowToastUtil;

import java.util.List;

import javax.annotation.Nullable;

import cn.ckz.luqu.R;
import cn.ckz.luqu.api.BaisiApi;
import cn.ckz.luqu.bean.BSDataListBean;
import cn.ckz.luqu.utils.CalLinesUtils;
import cn.ckz.luqu.utils.MyIntegerUtils;
import cn.ckz.luqu.view.view.CircleImageView;
import cn.ckz.luqu.view.view.JCVideoCustom;
import cn.ckz.luqu.view.view.SimpleLoadingView;
import fm.jiecao.jcvideoplayer_lib.JCMediaManager;
import fm.jiecao.jcvideoplayer_lib.JCUtils;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager;

import static fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.WIFI_TIP_DIALOG_SHOWED;
import static fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.backPress;

/**
 * Created by CKZ on 2017/8/21.
 */

public class BSAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "BSAdapter";
    private static final int IMAGE_TYPE = 0;
    private static final int GIF_TYPE = 1;
    private static final int VIDEO_TYPE = 2;
    private static final int TEXT_TYPE = 3;
    private static final int QUANWEN = -1;
    private static final int SHOUQI = -2;
    private int currentType = QUANWEN;

    private List<BSDataListBean> mData;
    private Activity mActivity;

    public BSAdapter(Activity activity, List<BSDataListBean> mData){
        this.mActivity = activity;
        this.mData = mData;
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position).getImage()!=null){
            return IMAGE_TYPE;
        }else if (mData.get(position).getGif()!=null){
            return GIF_TYPE;
        }else if (mData.get(position).getVideo()!=null){
            return VIDEO_TYPE;
        }else {
            return TEXT_TYPE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View showImage = LayoutInflater.from(mActivity).inflate(R.layout.item_type_image,parent,false);

        View showVideo = LayoutInflater.from(mActivity).inflate(R.layout.item_type_video,parent,false);

        View showText = LayoutInflater.from(mActivity).inflate(R.layout.item_type_text,parent,false);
        switch (viewType){
            case IMAGE_TYPE:
            case GIF_TYPE:
                return new ImagerViewHolder(showImage);
            case VIDEO_TYPE:
                return new VideoViewHolder(showVideo);
            case TEXT_TYPE:
                return new TextViewHolder(showText);
            default:
                return null;


        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (getItemViewType(position)){
            case IMAGE_TYPE:
                ImagerViewHolder imageHolder = (ImagerViewHolder) holder;
                setCommonData(imageHolder.mUserIcon,imageHolder.mUserName,imageHolder.mCreateTime,
                        imageHolder.textContent,imageHolder.mQuanwen,position);
                setImageData(imageHolder,position);
                if (listener!=null){
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            listener.OnItemClick(view,position);
                        }
                    });
                }
                break;
            case GIF_TYPE:
                ImagerViewHolder gifHolder = (ImagerViewHolder) holder;
                setCommonData(gifHolder.mUserIcon,gifHolder.mUserName,gifHolder.mCreateTime,
                        gifHolder.textContent,gifHolder.mQuanwen,position);
                setGifData(gifHolder,position);
                if (listener!=null){
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            listener.OnItemClick(view,position);
                        }
                    });
                }
                break;
            case VIDEO_TYPE:
               VideoViewHolder videoHolder = (VideoViewHolder) holder;
               setCommonData(videoHolder.mUserIcon,videoHolder.mUserName,videoHolder.mCreateTime,
                       videoHolder.textContent,null,position);
               setVideo(videoHolder,position);
               break;
            case TEXT_TYPE:
                TextViewHolder textHolder = (TextViewHolder) holder;
                setCommonData(textHolder.mUserIcon,textHolder.mUserName,textHolder.mCreateTime,
                        textHolder.textContent,null,position);
                break;
            default:
                break;

        }
    }

    private void setVideo(final VideoViewHolder holder, final int position){
        if (mData.get(position).getVideo()==null){
            return;
        }
        JCVideoPlayer.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE;
        holder.mPlayer.play_counts.setText(mData.get(position).getVideo().getPlaycount()+"");
        holder.mPlayer.total_duration.setText(MyIntegerUtils.ss2mm(mData.get(position).getVideo().getDuration()));
        holder.mPlayer.setUp(mData.get(position).getVideo().getVideo().get(1), JCVideoPlayer.SCREEN_LAYOUT_LIST,"");
        GlideImageLoader.create(holder.mPlayer.thumbImageView)
                .loadImage(mData.get(position).getVideo().getThumbnail().get(0),R.drawable.ic_launcher_background);

        setStartClick(holder,position);
        setFullClick(holder,position);
    }

    private void setFullClick(final VideoViewHolder holder, int position){
        holder.mPlayer.fullscreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("JieCaoVideoPlayer", "onClick fullscreen [" + this.hashCode() + "] ");

                if( holder.mPlayer.currentState == 6) {
                    return;
                }

                if( holder.mPlayer.currentScreen == 2) {
                    Log.d("JieCaoVideoPlayer", "隐藏");
                    backPress();
                } else {
                    Log.d("JieCaoVideoPlayer", "toFullscreenActivity [" + this.hashCode() + "] ");
                    holder.mPlayer.onEvent(7);
                    holder.mPlayer.startWindowFullscreen();
                    Log.d("JieCaoVideoPlayer", "显示 ");
                }
            }
        });
    }

    //重写start点击事件
    private void setStartClick(final VideoViewHolder holder, final int position) {
       holder.mPlayer.startButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Log.i("JieCaoVideoPlayer", "onClick start [" + holder.mPlayer.hashCode() + "] ");
               if(TextUtils.isEmpty(holder.mPlayer.url)) {
                   Toast.makeText(holder.mPlayer.getContext(), holder.mPlayer.getResources().getString(fm.jiecao.jcvideoplayer_lib.R.string.no_url), Toast.LENGTH_SHORT).show();
                   return;
               }
               getDanmu(position);
               if(holder.mPlayer.currentState != 0 && holder.mPlayer.currentState != 7) {
                   if(holder.mPlayer.currentState == 2) {
                       holder.mPlayer.onEvent(3);
                       Log.d("JieCaoVideoPlayer", "pauseVideo [" + holder.mPlayer.hashCode() + "] ");
                       JCMediaManager.instance().mediaPlayer.pause();
                       holder.mPlayer.setUiWitStateAndScreen(5);
                   } else if(holder.mPlayer.currentState == 5) {
                       holder.mPlayer.onEvent(4);
                       JCMediaManager.instance().mediaPlayer.start();
                       holder.mPlayer.setUiWitStateAndScreen(2);
                   } else if(holder.mPlayer.currentState == 6) {
                       holder.mPlayer.onEvent(2);
                       holder.mPlayer.prepareMediaPlayer();
                   }
               } else {
                   if(!holder.mPlayer.url.startsWith("file") && !JCUtils.isWifiConnected(holder.mPlayer.getContext()) && !WIFI_TIP_DIALOG_SHOWED) {
                       holder.mPlayer.showWifiDialog();
                       return;
                   }

                   holder.mPlayer.prepareMediaPlayer();
                   holder.mPlayer.onEvent(holder.mPlayer.currentState != 7?0:1);
               }
           }
       });
    }

    private void getDanmu(final int position){
        CommonOkHttpClient.get(CommonRequest.createGetRequest(BaisiApi.COMMENT(mData.get(position).getId()),null),new DisposeDataHandle(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {

                Log.d(TAG,mData.get(position).getText()+responseObj.toString());
            }

            @Override
            public void onFailure(Object reasonObj) {

            }
        }));

    }

    /**
     * 设置共用信息
     * @param userIcon
     * @param userName
     * @param createTime
     * @param textContent
     * @param quanwen
     * @param position
     */
    private void setCommonData(CircleImageView userIcon, TextView userName, TextView createTime,
                               TextView textContent, @Nullable final TextView quanwen, int position){
        //设置用户头像
        Glide.with(mActivity).asBitmap().load(mData.get(position).getU().getHeader().get(0)).into(userIcon);
        //用户名
        userName.setText(mData.get(position).getU().getName());
        //创建时间
        createTime.setText(mData.get(position).getPasstime());
        //正文内容
        String content = mData.get(position).getText();
        textContent.setText(content);
        if (quanwen == null){
            return;
        }
        if (CalLinesUtils.calLines(mActivity,content)){
            quanwen.setVisibility(View.VISIBLE);
            quanwen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (currentType == QUANWEN){
                        quanwen.setText(R.string.shouqi);
                        quanwen.setMaxLines(Integer.MAX_VALUE);
                        currentType = SHOUQI;
                    }else {
                        quanwen.setText(R.string.quanwen);
                        quanwen.setMaxLines(5);
                        currentType = QUANWEN;
                    }
                }
            });
        }else {
            quanwen.setVisibility(View.GONE);
        }

    }

    //设置image
    private void setImageData(final ImagerViewHolder holder, int position){
        String url = mData.get(position).getImage().getBig().get(0);
        GlideImageLoader.create(holder.mShowImage)
                .loadImageWithListener(url, R.drawable.ic_launcher_background, new GlideImageLoader.OnBitmapReadyListener() {
                    @Override
                    public void onResourceReady(Bitmap bitmap) {
                       holder.mShowImage.setImageBitmap(changeBitmap(bitmap,holder));
                    }
                })
                .setOnGlideImageViewListener(url, new OnGlideImageViewListener() {
                    @Override
                    public void onProgress(int percent, boolean isDone, GlideException exception) {
                       holder.mLoading.setProgress(percent).start();
                    }
                });
    }

    //更改bitmap尺寸
    private Bitmap changeBitmap(final Bitmap bitmap, final ImagerViewHolder holder){

        Bitmap mBitmap = null;
        if (bitmap.getHeight()>700){
            mBitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(), 700);
            holder.mLarge.setVisibility(View.VISIBLE);
        }else {
            mBitmap = bitmap;
            holder.mLarge.setVisibility(View.GONE);
        }
        return mBitmap;
    }

    //设置gif
    private void setGifData(final ImagerViewHolder holder, int position){
        holder.mLarge.setVisibility(View.GONE);
        String url = mData.get(position).getGif().getImages().get(0);
        GlideImageLoader.create(holder.mShowImage).loadeGif(url, R.drawable.ic_launcher_background).setOnGlideImageViewListener(url, new OnGlideImageViewListener() {
            @Override
            public void onProgress(int percent, boolean isDone, GlideException exception) {
                holder.mLoading.setProgress(percent).start().setOnFinishListener(new SimpleLoadingView.OnFinishListener() {
                    @Override
                    public void onFinish() {

                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnItemClickListener{
        void OnItemClick(View view,int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    //图片
   public class ImagerViewHolder extends RecyclerView.ViewHolder{
        //用户信息
        CircleImageView mUserIcon;
        TextView mUserName;
        TextView mCreateTime;
        //正文内容
        TextView textContent;
        TextView mQuanwen;
        //图片
        ImageView mShowImage;
        RelativeLayout mLarge;
        SimpleLoadingView mLoading;
        //喜欢
        public ImageView mLike;
        public ImageView mDislike;

        public ImagerViewHolder(View itemView) {
            super(itemView);
            mUserIcon = itemView.findViewById(R.id.user_icon);
            mUserName = itemView.findViewById(R.id.user_name);
            mCreateTime = itemView.findViewById(R.id.create_time);
            textContent = itemView.findViewById(R.id.text_content);
            mQuanwen = itemView.findViewById(R.id.show_quanwen);
            mShowImage = itemView.findViewById(R.id.show_image);
            mLoading = itemView.findViewById(R.id.image_loading);
            mLarge = itemView.findViewById(R.id.show_large);
            mLike = itemView.findViewById(R.id.image_like);
            mDislike = itemView.findViewById(R.id.image_dislike);
        }
    }

    //视频
    class VideoViewHolder extends RecyclerView.ViewHolder{
        //用户信息
        CircleImageView mUserIcon;
        TextView mUserName;
        TextView mCreateTime;
        //正文内容
        TextView textContent;
        //视频
        JCVideoCustom mPlayer;
        public VideoViewHolder(View itemView) {
            super(itemView);
            mUserIcon = itemView.findViewById(R.id.user_icon);
            mUserName = itemView.findViewById(R.id.user_name);
            mCreateTime = itemView.findViewById(R.id.create_time);
            textContent = itemView.findViewById(R.id.text_content);
            mPlayer = itemView.findViewById(R.id.video_player);
        }
    }
    //段子
    class TextViewHolder extends RecyclerView.ViewHolder{
        //用户信息
        CircleImageView mUserIcon;
        TextView mUserName;
        TextView mCreateTime;
        //正文内容
        TextView textContent;
        public TextViewHolder(View itemView) {
            super(itemView);
            mUserIcon = itemView.findViewById(R.id.user_icon);
            mUserName = itemView.findViewById(R.id.user_name);
            mCreateTime = itemView.findViewById(R.id.create_time);
            textContent = itemView.findViewById(R.id.text_content);
        }
    }

}
