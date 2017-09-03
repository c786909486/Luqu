package cn.ckz.luqu.view.fragment;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import cn.ckz.luqu.R;
import cn.ckz.luqu.adapter.BSAdapter;
import cn.ckz.luqu.api.BaisiApi;
import cn.ckz.luqu.bean.BSDataListBean;
import cn.ckz.luqu.presenter.IBaisiPresenter;
import cn.ckz.luqu.view.mvpview.IBaisiView;
import cn.ckz.luqu.view.view.CircleProgressDialog;
import cn.ckz.luqu.view.view.JCVideoCustom;

/**
 * Created by CKZ on 2017/8/27.
 */

public class VideoFragment extends Fragment implements View.OnClickListener,IBaisiView{
    private static final String TAG = "VideoFragment";
    private TextView mTitle;
    private RecyclerView mRecycler;
    private RelativeLayout mError;
    private RelativeLayout mNoNet;
    private List<BSDataListBean> mData;
    private BSAdapter mAdapter;
    private FloatingActionButton mButton;
    private CircleProgressDialog dialog;
    private TwinklingRefreshLayout mRefresh;
    private IBaisiPresenter presenter;
    private ObjectAnimator animator;


    @SuppressLint("ObjectAnimatorBinding")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new IBaisiPresenter(getContext(),this);
        View view = inflater.inflate(R.layout.fragment_video,container,false);
        init(view);
        animator = ObjectAnimator.ofFloat(mButton, "rotation", 0f,90f,180f,270f, 0f);
        animator.setDuration(500);
        setScroll();
        return view;
    }
    private void init(View view){
        mTitle = view.findViewById(R.id.top_title);
        mTitle.setText(R.string.video);
        mRefresh = view.findViewById(R.id.refresh_layout);
        mRecycler = view.findViewById(R.id.recycler_view);
        mError = view.findViewById(R.id.get_error_layout);
        mNoNet = view.findViewById(R.id.no_net_layout);
        mButton = view.findViewById(R.id.refresh_button);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mData = new ArrayList<>();
        mAdapter = new BSAdapter(getActivity(),mData);
        mRecycler.setAdapter(mAdapter);
        dialog = new CircleProgressDialog(getContext());
        mError.setOnClickListener(this);
        mNoNet.setOnClickListener(this);
        mButton.setOnClickListener(this);
        mRefresh.setEnableLoadmore(false);
        mRefresh.setEnableRefresh(false);
        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mRecycler);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.requestBSData(BaisiApi.VIDEO);
    }

    @Override
    public void onPause() {
        super.onPause();
        JCVideoCustom.releaseAllVideos();
    }



    private void hideAll(){
        mRecycler.setVisibility(View.INVISIBLE);
        mError.setVisibility(View.GONE);
        mNoNet.setVisibility(View.GONE);
    }

    private void setScroll(){
        mRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (Math.abs(dy)>60){
                    JCVideoCustom.releaseAllVideos();
                }
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.get_error_layout:
            case R.id.no_net_layout:
               //重新获取数据
                presenter.requestBSData(BaisiApi.VIDEO);
                break;
            case R.id.refresh_button:
                presenter.requestBSData(BaisiApi.VIDEO);
                animator.start();
                break;
        }
    }

    @Override
    public void updateData(final List<BSDataListBean> data) {
        JCVideoCustom.releaseAllVideos();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hideAll();
                mRecycler.setVisibility(View.VISIBLE);
                mData.clear();
                mData.addAll(data);
                mAdapter.notifyDataSetChanged();
                mRecycler.scrollToPosition(0);
                mRefresh.finishRefreshing();
            }
        });
    }

    @Override
    public void showLoadingDialog() {
        dialog.start();
    }

    @Override
    public void dissmissLoadingDialog() {
        dialog.stop();
    }

    @Override
    public void noNet() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hideAll();
                mNoNet.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void netError() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hideAll();
                mError.setVisibility(View.VISIBLE);
            }
        });
    }
}
