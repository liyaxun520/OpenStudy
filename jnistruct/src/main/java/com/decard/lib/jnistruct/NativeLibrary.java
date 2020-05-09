package com.decard.lib.jnistruct;

import com.decard.lib.jnistruct.data.DataBean;

public class NativeLibrary {
    //javah -classpath . com.decard.lib.jnistruct.NativeLibrary
    static {
        System.loadLibrary("hk");
    }
    // 将C结构体转为Java类
    public static native DataBean getDataFromNative();
    // 将Java类转为C结构体
    public static native void transferDataToNative(DataBean dataBean);
}
