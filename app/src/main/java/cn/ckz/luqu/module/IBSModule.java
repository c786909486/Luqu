package cn.ckz.luqu.module;

import java.util.List;

import cn.ckz.luqu.bean.BSDataListBean;

/**
 * Created by CKZ on 2017/8/18.
 */

public interface IBSModule {

   public void getPictureData(String bsUrl,OnSuccessListener listener);

   public interface OnSuccessListener{
       void onSuccess(List<BSDataListBean> listBeans);
       void onFaild(Object reasonObj);
   }
}
