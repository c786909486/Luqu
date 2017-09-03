package cn.ckz.luqu.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by CKZ on 2017/8/19.
 */

public class BSDataBean {



    @JSONField(name = "info")
    private InfoBean info;
    @JSONField(name = "list")
    private List<BSDataListBean> list;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<BSDataListBean> getList() {
        return list;
    }

    public void setList(List<BSDataListBean> list) {
        this.list = list;
    }

    public static class InfoBean {
        /**
         * count : 20
         * np : null
         */

        @JSONField(name = "count")
        private int count;
        @JSONField(name = "np")
        private Object np;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Object getNp() {
            return np;
        }

        public void setNp(Object np) {
            this.np = np;
        }
    }

}
