//package com.lison.retrofitdemo.net;
//
//import android.util.Log;
//
//import java.util.concurrent.TimeUnit;
//
//import io.reactivex.Observable;
//import io.reactivex.ObservableSource;
//import io.reactivex.functions.Function;
//
//public class RetryWithDelay implements
//        Function<Observable<? extends Throwable>, Observable<?>> {
//
//    private final int maxRetries;
//    private final int retryDelayMillis;
//    private int retryCount;
//
//    public RetryWithDelay(int maxRetries, int retryDelayMillis) {
//        this.maxRetries = maxRetries;
//        this.retryDelayMillis = retryDelayMillis;
//    }
//
//
//    @Override
//    public Observable<?> apply(Observable<? extends Throwable> observable) throws Exception {
//        return observable
//                .flatMap(new Function<Throwable, ObservableSource<?>>() {
//                    @Override
//                    public ObservableSource<?> apply(Throwable throwable) throws Exception {
//                        if (++retryCount <= maxRetries) {
//                            // When this Observable calls onNext, the original Observable will be retried (i.e. re-subscribed).
//                            Log.d("RetryWithDelay",  "get error, it will try after " + retryDelayMillis
//                                    + " millisecond, retry count " + retryCount);
//                            return Observable.timer(retryDelayMillis,
//                                    TimeUnit.MILLISECONDS);
//                        }
//                        return Observable.error(throwable);
//                    }
//                });
//    }
//}