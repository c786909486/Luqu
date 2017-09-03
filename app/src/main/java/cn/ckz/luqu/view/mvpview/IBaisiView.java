package cn.ckz.luqu.view.mvpview;

import java.util.List;

import cn.ckz.luqu.bean.BSDataBean;
import cn.ckz.luqu.bean.BSDataListBean;

/**
 * Created by CKZ on 2017/8/18.
 */

public interface IBaisiView {

    //更新数据
    public void updateData(List<BSDataListBean> mData);

    //显示loadingDialog
    public void showLoadingDialog();

    //隐藏loadingDiaog
    public void dissmissLoadingDialog();

    //没有网络
    public void noNet();
    //获取失败
    public void netError();



}
