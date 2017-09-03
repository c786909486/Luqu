package cn.ckz.luqu.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.vuandroidadsdk.utils.ShowToastUtil;

import java.util.List;

import cn.ckz.luqu.bean.BSDataListBean;
import cn.ckz.luqu.module.IBSImpl;
import cn.ckz.luqu.module.IBSModule;
import cn.ckz.luqu.utils.NetWorkUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import cn.ckz.luqu.view.mvpview.IBaisiView;

/**
 * Created by CKZ on 2017/8/19.
 */

public class IBaisiPresenter {
    static final String TAG = "IPicturePresenter";
    IBaisiView mView;
    IBSModule mModule;
    Context context;

    public IBaisiPresenter(Context context,IBaisiView mView){
        this.context = context;
        this.mView = mView;
        mModule = new IBSImpl(context);
    }
    //申请数据
    public void requestBSData(String url){
        getPictureNetData(url);
    }

    //后台申请数据
    public void requestBSDataBackground(String url, final OnSuccessListener listener){

        mModule.getPictureData(url, new IBSModule.OnSuccessListener() {
            @Override
            public void onSuccess(List<BSDataListBean> listBeans) {
                updateData(listBeans);
                listener.OnSuccess();
                dissmissLoadingDialog();
            }

            @Override
            public void onFaild(Object reasonObj) {
                listener.OnFaild(reasonObj);
            }
        });
    }
    public interface OnSuccessListener{
        void OnSuccess();
        void OnFaild(Object reasonObj);
    }

    private void updateData(List<BSDataListBean> mData){
        if(mView!=null){
            mView.updateData(mData);
        }
    }

    private void showLoadingDialog(){
        if (mView!=null){
            mView.showLoadingDialog();
        }
    }

    private void dissmissLoadingDialog(){
        if (mView!=null){
            mView.dissmissLoadingDialog();
        }
    }

    public void noNet(){
        if (mView!=null){
            mView.noNet();
        }
    }

    private void netError(){
        if (mView!=null){
            mView.netError();
        }
    }

    private void getPictureNetData(String bsUrl){
            if (NetWorkUtils.isNetworkConnected(context)){
                showLoadingDialog();
                mModule.getPictureData(bsUrl,new IBSModule.OnSuccessListener() {
                    @Override
                    public void onSuccess(final List<BSDataListBean> listBeans) {
                        Observable.create(new ObservableOnSubscribe<Integer>() {
                            @Override
                            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                                e.onNext(1);
                                e.onComplete();
                            }
                        }).subscribe(new Observer<Integer>() {
                            @Override
                            public void onSubscribe(Disposable d) {
                            }
                            @Override
                            public void onNext(Integer integer) {
                                updateData(listBeans);
                                Log.d(TAG,"显示数据");
                            }
                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onComplete() {
                                Log.d(TAG,"完成");
                                dissmissLoadingDialog();
                            }
                        });
                    }

                    @Override
                    public void onFaild(Object reasonObj) {
                        dissmissLoadingDialog();
                        netError();
                        Log.d(TAG,reasonObj.toString());
                    }
                });
            }else {
                noNet();
            }


    }
}
