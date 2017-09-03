package cn.ckz.luqu.api;

/**
 * Created by CKZ on 2017/8/19.
 */

public class BaisiApi {
    //图片
    public static final String PICTURE = "http://d.api.budejie.com/topic/list/chuanyue/10/budejie-android-6.6.3/0-20.json";

    //视频
    public static final String VIDEO = "http://d.api.budejie.com/topic/list/chuanyue/41/budejie-android-6.6.3/0-20.json";

    //段子
    public static final String TEXT = "http://d.api.budejie.com/topic/list/chuanyue/29/budejie-android-6.6.3/0-20.json";

    public static String COMMENT(String id){
        return "http://c.api.budejie.com/topic/comment_list/"+id+"/0/budejie-android-6.6.2/0-20.json?";
    }


}
