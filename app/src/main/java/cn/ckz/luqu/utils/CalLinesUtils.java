package cn.ckz.luqu.utils;

import android.app.Activity;
import android.content.Context;

/**
 * Created by CKZ on 2017/3/5.
 */

public class CalLinesUtils {

    /**
     * 计算文本的长度是否超过最大行
     *
     * @param
     * @param string
     * @return
     */
    public static boolean calLines(Activity context, String string) {
        // 获得字体的宽度，sp转px的方法，网上很多，19为textview中所设定的textSize属性值
        int txtWidth = DisplayUtils.sp2px(context, 15);
        // 获得屏幕的宽度
        int winWidth = DisplayUtils
                .getWindowWidth(context);
        // 获得textView控件的宽度，15为xml中所设定marginleft 和 marginright的值，这里都是15，所以直接乘以2了。
        int viewWidth = winWidth
                - DisplayUtils.dip2px(context, 21) * 2;
        // 获得单行最多显示字数
        int maxWords = viewWidth / txtWidth;
        // 计算字符串长度，
        int stringLen = string.length();
        // 字符串长度除以单行最多显示字数为行数
        int lines = stringLen / maxWords;

        if (lines > 5) {
            // 如果大于指定行数，则直接返回
            return true;
        } else if (lines == 5) {
            // 否则需要判断下是否等于最大行，但是有余数
            if (stringLen % maxWords > 0) {
                return true;
            }
        }
        return false;
    }
}
