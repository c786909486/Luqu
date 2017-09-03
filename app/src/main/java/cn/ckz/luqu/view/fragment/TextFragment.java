package cn.ckz.luqu.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.vuandroidadsdk.utils.ShowToastUtil;

import java.util.ArrayList;
import java.util.List;

import cn.ckz.luqu.R;
import cn.ckz.luqu.adapter.BSAdapter;
import cn.ckz.luqu.api.BaisiApi;
import cn.ckz.luqu.bean.BSDataListBean;
import cn.ckz.luqu.presenter.IBaisiPresenter;
import cn.ckz.luqu.view.mvpview.IBaisiView;
import cn.ckz.luqu.view.view.CircleProgressDialog;

/**
 * Created by CKZ on 2017/9/1.
 */

public class TextFragment extends Fragment implements IBaisiView,View.OnClickListener{
    private static final String TAG = "TextFragment";
    private TextView mTitle;
    private RecyclerView mRecycler;
    private RelativeLayout mError;
    private RelativeLayout mNoNet;
    private List<BSDataListBean> mData;
    private BSAdapter adapter;
    private IBaisiPresenter picturePresenter;
    private CircleProgressDialog dialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image,container,false);
        init(view);
        return view;
    }

    private void init(View view){
        mTitle = view.findViewById(R.id.top_title);
        mTitle.setText(R.string.text);
        mRecycler = view.findViewById(R.id.recycler_view);
        mError = view.findViewById(R.id.get_error_layout);
        mNoNet = view.findViewById(R.id.no_net_layout);
        mData = new ArrayList<>();
        adapter = new BSAdapter(getActivity(),mData);
        mRecycler.setAdapter(adapter);
        picturePresenter = new IBaisiPresenter(getContext(),this);
        dialog = new CircleProgressDialog(getContext());
        setRecyclerManager();
        mError.setOnClickListener(this);
        mNoNet.setOnClickListener(this);
        setRecyclerScroll();
    }

    private enum scrollState{
        RIGHT,
        LEFT
    }
    private scrollState current = scrollState.RIGHT;

    private void setRecyclerScroll() {
        mRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                //判断是当前layoutManager是否为LinearLayoutManager
                // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                    //获取最后一个可见view的位置
                    final int lastItemPosition = linearManager.findLastVisibleItemPosition();
                    //获取第一个可见view的位置
                    int firstItemPosition = linearManager.findFirstVisibleItemPosition();
                    if (lastItemPosition == adapter.getItemCount()-1 && current == scrollState.LEFT&&newState == RecyclerView.SCROLL_STATE_DRAGGING){
                        picturePresenter.requestBSDataBackground(BaisiApi.TEXT, new IBaisiPresenter.OnSuccessListener() {
                            @Override
                            public void OnSuccess() {
                                mRecycler.scrollToPosition(lastItemPosition+1);
                            }

                            @Override
                            public void OnFaild(Object reasonObj) {
                                ShowToastUtil.showToast(getContext(),"获取失败，请检查网络连接");
                            }
                        });

                    }
                    Log.d(TAG,"last:"+lastItemPosition+"\nfirst:"+firstItemPosition);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dx>0){
                   current = scrollState.LEFT;
                }else if (dx<0){
                    current = scrollState.RIGHT;
                }
            }
        });
    }

    private void hideAll(){
        mRecycler.setVisibility(View.INVISIBLE);
        mError.setVisibility(View.GONE);
        mNoNet.setVisibility(View.GONE);
    }

    private void setRecyclerManager(){
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecycler.setLayoutManager(manager);
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRecycler);
    }

    @Override
    public void updateData(final List<BSDataListBean> data) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hideAll();
                mRecycler.setVisibility(View.VISIBLE);
                mData.addAll(data);
                adapter.notifyDataSetChanged();
                Log.d(TAG,mData.size()+"");
                dialog.start();
            }
        });
    }

    @Override
    public void showLoadingDialog() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dialog.show();
            }
        });
    }

    @Override
    public void dissmissLoadingDialog() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dialog.stop();
            }
        });
    }

    @Override
    public void noNet() {
        hideAll();
        mError.setVisibility(View.VISIBLE);
    }

    @Override
    public void netError() {
        hideAll();
        mError.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStart() {
        super.onStart();
        picturePresenter.requestBSData(BaisiApi.TEXT);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.get_error_layout:
            case R.id.no_net_layout:
                picturePresenter.requestBSData(BaisiApi.TEXT);
                break;
        }
    }
}
