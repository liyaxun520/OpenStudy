package com.lison.retrofitdemo.net;

public interface DataCallBack<T> {

    void callBackData(T data);

    void callError(Throwable t);
}
