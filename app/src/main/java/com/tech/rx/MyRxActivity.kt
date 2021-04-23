package com.tech.rx

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fragment.R
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MyRxActivity : AppCompatActivity() {
    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_rx)


      // 1. way Just Operator
      Observable.just("Kamal", "Kakkar")
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable?) {
                    Log.e("TAG", "onSubscribe: ")
                }

                override fun onNext(t: String?) {
                    Log.e("TAG", t)

                }

                override fun onError(e: Throwable?) {
                    Log.e("TAG", "Error: ")

                }

                override fun onComplete() {
                    Log.e("TAG", "Complete: ")

                }

            })
        // 2 Way
        var obsverable = Observable.just("Kamal", "Kakkar")

             obsverable
            .subscribeOn(Schedulers.io())
         //  .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<String> {
                override fun onSubscribe(d: Disposable?) {
                    Log.e("TAG", "onSubscribe: ")
                }

                override fun onNext(t: String?) {
                    Log.e("TAG", t)

                }

                override fun onError(e: Throwable?) {
                    Log.e("TAG", "Error: ")

                }

                override fun onComplete() {
                    Log.e("TAG", "Complete: ")

                }

            })
        // Map Operator in RxJava
        //1.map
        //2.FlatMap
        //3.SwitchMap
        //4.ConcatMap


            getUserObsverable()
                .subscribeOn(Schedulers.io())
               // .observeOn(AndroidSchedulers.mainThread())
                .map {user->
                    user.email = user.name + "@gamil.com"
                    user.name = user.name.toUpperCase()
                    user
                }
                .subscribe(object : Observer<UserO> {
                    override fun onSubscribe(d: Disposable?) {
                        Log.e("TAG", "onSubscribe: ")                    }

                    override fun onNext(t: UserO?) {
                        Log.e("TAG", t.toString())
                    }

                    override fun onError(e: Throwable?) {
                        Log.e("TAG", "Error: ")
                    }

                    override fun onComplete() {
                        Log.e("TAG", "Complete: ")
                    }

                })
        }


    }

    fun getUserObsverable() : Observable<UserO>
    {
       val list = mutableListOf<UserO>()
        var avc = UserO("kamal", "99",)
        list.add(avc)
        avc = UserO("Ok", "100")
        list.add(avc)
        avc = UserO("Sunakshi", "101")
        list.add(avc)
        avc = UserO("Ishan", "102")
        list.add(avc)
        avc = UserO("Deep", "103")
        list.add(avc)
        return Observable.create(object : ObservableOnSubscribe<UserO> {
            override fun subscribe(emitter: ObservableEmitter<UserO>?) {
                //TODO("Not yet implemented")
                for (item in list) {
                    if (!emitter?.isDisposed!!) {
                        emitter.onNext(item)
                    }

                }
                if (!emitter?.isDisposed()!!) {
                    emitter?.onComplete();
                }
            }

        }).subscribeOn(Schedulers.io())

}