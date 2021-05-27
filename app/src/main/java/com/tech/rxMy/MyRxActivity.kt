package com.tech.rxMy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fragment.R
import com.tech.rx.UserO
import io.reactivex.rxjava3.core.*
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers


class MyRxActivity : AppCompatActivity() {
    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_rx)

        //Observable  Creation Type
        // 1. Using Create
        var observable1 = Observable.create<String> { it ->
            it.onNext("Kamal")
            it.onNext("Deep")
            it.onNext("Kakkar")
            it.onComplete()
        }

        observable1.subscribe(object : Observer<String> {
            override fun onSubscribe(d: Disposable?) {
                //     TODO("Not yet implemented")
            }

            override fun onNext(t: String?) {
                Log.e("TAG Create", t)
            }

            override fun onError(e: Throwable?) {
                //   TODO("Not yet implemented")
            }

            override fun onComplete() {
                Log.e("TAG ", "Create Complete")

            }

        })


        // 2. way Just Operator
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



        // 2. May be
        Single.just("kamal")
            .subscribe(object : SingleObserver<String>{
                override fun onSubscribe(d: Disposable?) {

                }

                override fun onSuccess(t: String?) {
                    Log.e("TAG Single", "onSuccess: "+t)
                }

                override fun onError(e: Throwable?) {

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

        // rx map opeartor

        //
       // Map returns an object of type T


        Observable.just("kamal","deep","kumar")
            .map { it.length }
            .filter { len -> len < 4 }
            .subscribe {
                Log.e("TAG", "Rx map opeator: "+it)
            }

        // Kotlin map
        var list = listOf<String>("Kamal","Deep","Kakkar")
        var mapData=list.map {
           it -> it.length
        }
        Log.e("TAG", "Kotlin map opeator: "+mapData)


        // flat map
        // FlatMap returns an Observable.
        Observable.just("ABC","DEF","GH")
            .flatMap { Observable.fromArray(it.split("")) }
            .subscribe { Log.e("TAG", "Rx flat map: "+it) }

        // Kotlin Map
        var listData = listOf<String>("11","3","4")
        Log.e("TAG", "Kotlin flat map : "+listData.flatMap { it.toList() } )
        
       // secand example of kotlin map and flat map

        var newList = listOf(listOf(1,2,3) , listOf(2,4,5))
        Log.e("TAG", "kotlin map  : "+newList.map { it.toList() })
        Log.e("TAG", "kotlin flat map  : "+newList.flatMap { it.toList() })


        // filter

        // Rx Java filter
        Observable.just("kamal","Deep","Kumar","Kakkar")
            .map { it.length }
            .filter { len -> len == 4 }
            .subscribe {
                Log.e("TAG", "Rx filter map opeator: "+it)
            }

        //Kotlin filter

        listOf<String>("Kamal","Deep","kumar","Kakkar")
        .map { it.length }
            .filter {
                len -> len ==4
            }.forEach{
                Log.e("TAG", "kotlin filter map opeator "+it )
            }



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