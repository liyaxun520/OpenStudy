package com.lison.retrofitdemo.net;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddCookiesInterceptor implements Interceptor {

    public AddCookiesInterceptor() {
        super();
    }
    @Override
    public Response intercept(Chain chain) throws IOException {

        final Request.Builder builder = chain.request().newBuilder();

        return chain.proceed(builder.build());
    }
}