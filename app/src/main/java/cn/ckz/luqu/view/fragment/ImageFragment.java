package cn.ckz.luqu.view.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vuandroidadsdk.recyclerManager.CardConfig;
import com.example.vuandroidadsdk.recyclerManager.CardItemTouchHelperCallback;
import com.example.vuandroidadsdk.recyclerManager.CardLayoutManager;
import com.example.vuandroidadsdk.recyclerManager.OnSwipeListener;
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
 * Created by CKZ on 2017/8/20.
 */

public class ImageFragment extends Fragment implements IBaisiView,BSAdapter.OnItemClickListener,View.OnClickListener{
    private static final String TAG = "ImageFragment";
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
        mTitle.setText(R.string.image);
        mRecycler = view.findViewById(R.id.recycler_view);
        mError = view.findViewById(R.id.get_error_layout);
        mNoNet = view.findViewById(R.id.no_net_layout);
        mData = new ArrayList<>();
        adapter = new BSAdapter(getActivity(),mData);
        mRecycler.setAdapter(adapter);
        picturePresenter = new IBaisiPresenter(getContext(),this);
        dialog = new CircleProgressDialog(getContext());
        setRecyclerManager();
        adapter.setOnItemClickListener(this);
        mError.setOnClickListener(this);
        mNoNet.setOnClickListener(this);
    }

    private void hideAll(){
        mRecycler.setVisibility(View.INVISIBLE);
        mError.setVisibility(View.GONE);
        mNoNet.setVisibility(View.GONE);
    }
    private void setRecyclerManager() {
        CardItemTouchHelperCallback callback = new CardItemTouchHelperCallback(adapter,mData);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        CardLayoutManager manager = new CardLayoutManager(mRecycler,touchHelper);
        mRecycler.setLayoutManager(manager);
        touchHelper.attachToRecyclerView(mRecycler);
        callback.setOnSwipedListener(new OnSwipeListener() {
            @Override
            public void onSwiping(RecyclerView.ViewHolder viewHolder, float ratio, int direction) {
                BSAdapter.ImagerViewHolder myHolder = (BSAdapter.ImagerViewHolder) viewHolder;
                if (direction == CardConfig.SWIPING_LEFT) {
                    myHolder.mDislike.setVisibility(View.VISIBLE);
                    myHolder.mDislike.setAlpha(Math.abs(ratio));
                } else if (direction == CardConfig.SWIPING_RIGHT) {
                    myHolder.mLike.setVisibility(View.VISIBLE);
                    myHolder.mLike.setAlpha(Math.abs(ratio));
                } else {
                    myHolder.mDislike.setVisibility(View.GONE);
                    myHolder.mLike.setVisibility(View.GONE);
                    myHolder.mDislike.setAlpha(0f);
                    myHolder.mLike.setAlpha(0f);
                }
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, Object o, int direction) {
                BSAdapter.ImagerViewHolder myHolder = (BSAdapter.ImagerViewHolder) viewHolder;
                myHolder.mDislike.setVisibility(View.GONE);
                myHolder.mLike.setVisibility(View.GONE);
                myHolder.mDislike.setAlpha(0f);
                myHolder.mLike.setAlpha(0f);
            }

            @Override
            public void onSwipedClear() {
                picturePresenter.requestBSData(BaisiApi.PICTURE);
            }
        });
    }


    @Override
    public void updateData(final List<BSDataListBean> data) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hideAll();
                mRecycler.setVisibility(View.VISIBLE);
                mData.clear();
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
        mNoNet.setVisibility(View.VISIBLE);
    }

    @Override
    public void netError() {
        hideAll();
        mError.setVisibility(View.VISIBLE);
    }

    @Override
    public void OnItemClick(View view, int position) {
        Toast.makeText(getContext(),mData.get(position).getText(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        picturePresenter.requestBSData(BaisiApi.PICTURE);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.get_error_layout:
            case R.id.no_net_layout:
                picturePresenter.requestBSData(BaisiApi.PICTURE);
                break;
        }
    }
}
