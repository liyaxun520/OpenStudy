package com.lison.retrofitdemo.net;

import android.util.Log;

import com.lison.retrofitdemo.Repo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class NetManager {

    private  String BASE_URL = "https://api.github.com";
    public static final String TAG = "NetManager";
    private GitHubService apiService;
    private static NetManager instance;


    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            try {
                String text = URLDecoder.decode(message, "utf-8");
                Log.e("OKHttp-----",""+text);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                Log.e("OKHttp-----",""+message);
            }

        }
    });


    private NetManager() {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.addInterceptor(new AddCookiesInterceptor());
        builder.addInterceptor(interceptor);
        builder.connectTimeout(5, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL + "/")
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        apiService = retrofit.create(GitHubService.class);
    }

    public static NetManager getInstance() {
        if (instance == null) {
            synchronized (NetManager.class) {
                if (instance == null) {
                    instance = new NetManager();
                }
            }
        }
        return instance;
    }

    public void listRepos(String user, final DataCallBack dataCallBack){
        Call<List<Repo>> listCall = apiService.listRepos(user);
        try {
            Response<List<Repo>> execute = listCall.execute();
            int code = execute.code();   //同步网络请求
            Log.e(TAG, "listRepos: "+code );
        } catch (IOException e) {
            e.printStackTrace();
        }
        Call<List<Repo>> listCall1 = apiService.listRepos(user);
        listCall1.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                Log.e(TAG, "onResponse: code =  "+response.code()+"    message =  "+response.message()+"   body = "+response.body());
                if (response.code() == 200) {
                    List<Repo> repos = response.body();
                    dataCallBack.callBackData(repos);
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                t.printStackTrace();
                dataCallBack.callError(t);
            }
        });
    }

}
