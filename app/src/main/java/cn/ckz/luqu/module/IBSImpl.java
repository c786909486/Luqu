package cn.ckz.luqu.module;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.example.vuandroidadsdk.okhttp.CommonOkHttpClient;
import com.example.vuandroidadsdk.okhttp.listener.DisposeDataHandle;
import com.example.vuandroidadsdk.okhttp.listener.DisposeDataListener;
import com.example.vuandroidadsdk.okhttp.request.CommonRequest;

import cn.ckz.luqu.bean.BSDataBean;

/**
 * Created by CKZ on 2017/8/19.
 */

public class IBSImpl implements IBSModule {
    private Context context;

    public IBSImpl(Context context){
        this.context = context;
    }


    @Override
    public void getPictureData(String bsUrl,final OnSuccessListener listener) {
        CommonOkHttpClient.get(CommonRequest.createGetRequest(bsUrl,null),new DisposeDataHandle(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                final BSDataBean dataBean = JSON.parseObject(responseObj.toString(),BSDataBean.class);
                listener.onSuccess(dataBean.getList());
            }

            @Override
            public void onFailure(Object reasonObj) {
               listener.onFaild(reasonObj);
            }
        }));

    }
}
