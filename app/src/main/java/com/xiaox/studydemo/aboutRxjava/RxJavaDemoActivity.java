package com.xiaox.studydemo.aboutRxjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.xiaox.studydemo.R;

import java.util.concurrent.TimeUnit;

import io.reactivex.Notification;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;


/**
 * @version V1.0
 * @Title: Loan
 * @Description:
 * @date 2019/7/31
 * @author:xiaox
 * @email:303378520@qq.com
 * @replace author:
 * @replace date:
 */
public class RxJavaDemoActivity extends AppCompatActivity implements View.OnClickListener {


    private String TAG = "xiaoxTag";
    private boolean flag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_demo);
        findViewById(R.id.btn_retryWhen).setOnClickListener(this);
        findViewById(R.id.btn_just).setOnClickListener(this);
        findViewById(R.id.btn_do).setOnClickListener(this);
        findViewById(R.id.btn_retry).setOnClickListener(this);
        findViewById(R.id.btn_concat).setOnClickListener(this);
        findViewById(R.id.btn_merge).setOnClickListener(this);
        findViewById(R.id.btn_combine).setOnClickListener(this);
        findViewById(R.id.btn_flatMap).setOnClickListener(this);
        findViewById(R.id.btn_changeFlag).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_retryWhen:
                retryWhen();
                break;
            case R.id.btn_just:
                just();
                break;
            case R.id.btn_do:
                doOperation();
                break;
            case R.id.btn_retry:
                retry();
                break;
            case R.id.btn_concat:
                rxConcat();
                break;
            case R.id.btn_merge:
                rxMerge();
                break;
            case R.id.btn_combine:
                combine();
                break;
            case R.id.btn_flatMap:
                //flatMap();
//                flatMap1();
                flatMap2();
                break;
            case R.id.btn_changeFlag:
                flag = true;
                break;
        }
    }

    @SuppressWarnings("all")
    private void flatMap2() {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                emitter.onNext(Observable.just(1));
            }
        })
                .flatMap(new Function<Object, ObservableSource<Test1>>() {
                    @Override
                    public ObservableSource<Test1> apply(Object o) throws Exception {
                        if (flag) {
                            return null;
                        } else {
                            final Test1 test1 = new Test1();
                            test1.name = "aaaaa";
                            Observable<Test1> commonObservable = Observable.create(new ObservableOnSubscribe<Test1>() {
                                @Override
                                public void subscribe(ObservableEmitter<Test1> emitter) throws Exception {
                                    emitter.onNext(test1);
                                }
                            });
                            return commonObservable;
                        }
                    }
                })
                .flatMap(new Function<Test1, ObservableSource<Test2>>() {
                    @Override
                    public ObservableSource<Test2> apply(final Test1 test1) throws Exception {
                        final Test2 test2 = new Test2();
                        test2.name = "bbbbb";
                        return Observable.create(new ObservableOnSubscribe<Test2>() {
                            @Override
                            public void subscribe(ObservableEmitter<Test2> emitter) throws Exception {
                                emitter.onNext(test2);
                            }
                        });
                    }
                })
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        Log.i(TAG, "result = " + o);
                        if (o instanceof Test1) {
                            Log.i(TAG, "Test1 = " + ((Test1) o).name);
                        } else if (o instanceof Test2) {
                            Log.i(TAG, "Test2 = " + ((Test2) o).name);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i(TAG, " throwable " + throwable);
                    }
                });
    }

    @SuppressWarnings("all")
    private void flatMap1() {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                emitter.onNext(Observable.just(1));
            }
        })
                .flatMap(new Function<Object, ObservableSource<Test1>>() {
                    @Override
                    public ObservableSource<Test1> apply(Object o) throws Exception {
                        if (flag) {
                            return null;
                        } else {
                            final Test1 test1 = new Test1();
                            test1.name = "aaaaa";
                            Observable<Test1> commonObservable = Observable.create(new ObservableOnSubscribe<Test1>() {
                                @Override
                                public void subscribe(ObservableEmitter<Test1> emitter) throws Exception {
                                    emitter.onNext(test1);
                                }
                            });
                            return commonObservable;
                        }
                    }
                })
                .flatMap(new Function<Test1, ObservableSource<Test2>>() {
                    @Override
                    public ObservableSource<Test2> apply(final Test1 test1) throws Exception {
                        final Test2 test2 = new Test2();
                        test2.name = "bbbbb";
                        return Observable.create(new ObservableOnSubscribe<Test2>() {
                            @Override
                            public void subscribe(ObservableEmitter<Test2> emitter) throws Exception {
                                emitter.onNext(test2);
                            }
                        });
                    }
                })
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        Log.i(TAG, "result = " + o);
                        if (o instanceof Test1) {
                            Log.i(TAG, "Test1 = " + ((Test1) o).name);
                        } else if (o instanceof Test2) {
                            Log.i(TAG, "Test2 = " + ((Test2) o).name);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i(TAG, " throwable " + throwable);
                    }
                });
    }

    @SuppressWarnings("all")
    private void flatMap() {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                Test2 test2 = new Test2();
                test2.name = "bbb";
                emitter.onNext(test2);
            }
        })
                .flatMap(new Function<Object, ObservableSource<Common>>() {
                    @Override
                    public ObservableSource<Common> apply(Object o) throws Exception {
                        if (flag) {
                            final Test1 test1 = new Test1();
                            test1.name = "aaaaa";
                            Observable<Common> commonObservable = Observable.create(new ObservableOnSubscribe<Common>() {
                                @Override
                                public void subscribe(ObservableEmitter<Common> emitter) throws Exception {
                                    emitter.onNext(test1);
                                }
                            });
                            return commonObservable;
                        } else {
                            final Test2 test2 = new Test2();
                            test2.name = "bbbbb";
                            return Observable.create(new ObservableOnSubscribe<Common>() {
                                @Override
                                public void subscribe(ObservableEmitter<Common> emitter) throws Exception {
                                    emitter.onNext(test2);
                                }
                            });
                        }
                    }
                })
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        if (o instanceof Test1) {
                            Log.i(TAG, "Test1 = " + ((Test1) o).name);
                        } else if (o instanceof Test2) {
                            Log.i(TAG, "Test2 = " + ((Test2) o).name);
                        }
                    }
                });
    }

    @SuppressLint("CheckResult")
    private void combine() {
        Observable.combineLatest(
                Observable.just(1, 2, 3), // 第1个发送数据事件的Observable
                Observable.just(6, 7, 8),
                Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS), // 第3个发送数据事件的Observable：从0开始发送、共发送3个数据、第1次事件延迟发送时间 = 1s、间隔时间 = 1s
                new Function3<Integer, Integer, Long, Long>() {
                    @Override
                    public Long apply(Integer integer, Integer integer2, Long aLong) throws Exception {
                        // i1 = 第1个Observable发送的最新（最后）1个数据
                        // i3 = 第2个Observable发送的每1个数据
                        Log.i(TAG, "合并的数据是： " + integer + "," + integer2 + "," + aLong);
                        // 合并的逻辑 = 相加
                        // 即第1个Observable发送的最后1个数据 与 第2个Observable发送的每1个数据进行相加
                        return integer + integer2 + aLong;
                    }
                })
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long s) throws Exception {
                        Log.i(TAG, "合并的结果是： " + s);
                    }
                });
        //合并的数据是： 3,8,0
        //合并的结果是： 11
        //合并的数据是： 3,8,1
        //合并的结果是： 12
        //合并的数据是： 3,8,2
        //合并的结果是： 13
    }

    /**
     * 组合多个被观察者一起发送数据，合并后 按时间线并行执行
     */
    private void rxMerge() {
        //区别concat（）操作符：同样是组合多个被观察者一起发送数据，但concat（）操作符合并后是按发送顺序串行执行
        Observable.merge(
                Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS), // 从0开始发送、共发送3个数据、第1次事件延迟发送时间 = 1s、间隔时间 = 1s
                Observable.intervalRange(2, 3, 1, 1, TimeUnit.SECONDS)) // 从2开始发送、共发送3个数据、第1次事件延迟发送时间 = 1s、间隔时间 = 1s
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long value) {
                        Log.d(TAG, "接收到了事件" + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }

    /**
     * 组合多个被观察者一起发送数据，合并后 按发送顺序串行执行
     */
    private void rxConcat() {
        //concat（） / concatArray（）
        //concat（）组合被观察者数量≤4个，而concatArray（）则可＞4个
        Observable.concatArrayDelayError(Observable.just(1, 2, 3),
                Observable.just(4, 5, 6),
                Observable.just(7, 8, 9),
                Observable.<Integer>empty(),
                Observable.just(13, 14, 15))
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer value) {
                        Log.d(TAG, "接收到了事件" + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }

    private void retry() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.i(TAG, "subscribe");
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onError(new Throwable("发生了错误"));
                emitter.onNext(4);
            }
        })
                //遇到错误时，发送1个新的Observable
                //onErrorResumeNext（）拦截的错误 = Throwable；若需拦截Exception请用onExceptionResumeNext（）
                //若onErrorResumeNext（）拦截的错误 = Exception，则会将错误传递给观察者的onError方法
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends Integer>>() {
                    @Override
                    public ObservableSource<? extends Integer> apply(Throwable throwable) throws Exception {
                        Log.i(TAG, "onErrorResumeNext");
                        if (throwable.getMessage().equals("发生了错误")) {
                            return Observable.just(666);
                        } else {
                            return Observable.just(999);
                        }
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.i(TAG, "onNext = " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete");
                    }
                });
    }

    private void doOperation() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onError(new Throwable("发生错误了"));
            }
        })
                // 1. 当Observable每发送1次数据事件就会调用1次
                .doOnEach(new Consumer<Notification<Integer>>() {
                    @Override
                    public void accept(Notification<Integer> integerNotification) throws Exception {
                        Log.d(TAG, "doOnEach: " + integerNotification.getValue());
                    }
                })
                // 2. 执行Next事件前调用
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "doOnNext: " + integer);
                    }
                })
                // 3. 执行Next事件后调用
                .doAfterNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "doAfterNext: " + integer);
                    }
                })
                // 4. Observable正常发送事件完毕后调用
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.e(TAG, "doOnComplete: ");
                    }
                })
                // 5. Observable发送错误事件时调用
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d(TAG, "doOnError: " + throwable.getMessage());
                    }
                })
                // 6. 观察者订阅时调用
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        Log.e(TAG, "doOnSubscribe: ");
                    }
                })
                // 7. Observable发送事件完毕后调用，无论正常发送完毕 / 异常终止
                .doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.e(TAG, "doAfterTerminate: ");
                    }
                })
                // 8. 最后执行
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.e(TAG, "doFinally: ");
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer value) {
                        Log.d(TAG, "接收到了事件" + value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }

    private void just() {
        Observable.just(1, 2, 3)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.i(TAG, "onNext = " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @SuppressLint("CheckResult")
    private void retryWhen() {
        Observable.create(
                new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                        Log.i(TAG, "subscribe");
                        emitter.onNext(1);
                        emitter.onNext(2);
                        emitter.onNext(3);
                        emitter.onError(new Exception("发生了错误"));
                        emitter.onNext(4);
                    }
                })
                // 遇到error事件才会回调
                .retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
                    @Override
                    public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Exception {
                        Log.i(TAG, "retryWhen");
                        // 参数Observable<Throwable>中的泛型 = 上游操作符抛出的异常，可通过该条件来判断异常的类型
                        // 返回Observable<?> = 新的被观察者 Observable（任意类型）
                        // 此处有两种情况：
                        // 1. 若 新的被观察者 Observable发送的事件 = Error事件，那么原始Observable则不重新发送事件：
                        // 2. 若 新的被观察者 Observable发送的事件 = Next事件 ，那么原始的Observable则重新发送事件：
                        return throwableObservable.flatMap(new Function<Throwable, ObservableSource<?>>() {
                            @Override
                            public ObservableSource<?> apply(@NonNull Throwable throwable) throws Exception {
                                Log.i(TAG, "retryWhen + flatMap");
                                // 1. 若返回的Observable发送的事件 = Error事件，则原始的Observable不重新发送事件
                                // 该异常错误信息可在观察者中的onError（）中获得
                                if (throwable.getMessage().equals("发生了错误")) {
                                    return Observable.error(new Throwable("retryWhen终止啦"));
                                }
                                return Observable.just(1);

                                // 2. 若返回的Observable发送的事件 = Next事件，则原始的Observable重新发送事件（若持续遇到错误，则持续重试）
                                // return Observable.just(1);
                            }
                        });
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.i(TAG, "onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.i(TAG, "onNext = " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete");
                    }
                });
    }
}
