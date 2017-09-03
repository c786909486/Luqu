package cn.ckz.luqu.utils;

import java.text.DecimalFormat;

/**
 * Created by CKZ on 2017/2/21.
 */

public class MyIntegerUtils {

    public static String ss2mm(int duration){
        String time = "";
        if (duration<=3600){
            String mm = String.valueOf(duration/60);
            String ss = String.valueOf(duration%60);
            if (mm.length()==1) mm = "0"+mm;
            if (ss.length()==1) ss = "0"+ss;

            time = mm+":"+ss;
        }
        return time;
    }

    public static String int2k(int index){
        String count = "";
        if (index<1000){
            count = index+"";
        }else {
            double i = (index/1000.0);

            count = String.format("%.2f", i);
        }
        return count;
    }
    public static String int2W(int index){
        String count = "";
        if (index<1000){
            count = index+"";
        }else {
            double i = (index/10000.0);

            count = String.format("%.1f", i);
        }
        return count;
    }
}
