package com.tech.backgroundwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.fragment.R
import kotlinx.android.synthetic.main.activity_coroutine.*
import kotlinx.android.synthetic.main.activity_coroutine.view.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.*

class CoroutineActivity : AppCompatActivity() {

    val parentJob = Job()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine)

        coroutineLaunch.setOnClickListener({
            CoroutineScope(Dispatchers.Main).launch {
                Toast.makeText(this@CoroutineActivity,"Simple Coroutine Launch",Toast.LENGTH_LONG).show()
            }
        })
        coroutineAsync.setOnClickListener({
            CoroutineScope(Dispatchers.Main).launch {
                var first = async(Dispatchers.Default){  firstCoroutine()}
                var second = async(Dispatchers.Default){secondCoroutine()}
                var total = first.await() + second.await()
                Log.e("TAG", "Async: "+total +" Name "+Thread.currentThread().name)
                Toast.makeText(this@CoroutineActivity,"Total = $total",Toast.LENGTH_SHORT).show()
            }
        })
        exceptionHandling.setOnClickListener({

            // Exception
            val coroutineExceptionHandler: CoroutineExceptionHandler =
                CoroutineExceptionHandler { coroutineContext, throwable ->
                    GlobalScope.launch {
                        //Toast.makeText(this@CoroutineActivity,"Error $throwable",Toast.LENGTH_SHORT).show()
                        println("Caught $throwable")
                        Log.e("TAG", "Caught: $throwable")
                    }

                }

            var corScope = CoroutineScope(Dispatchers.Main + coroutineExceptionHandler).launch {
                var first = async {  firstCoroutine() }
                var thread = async {errorCoroutine()}
                Log.e("TAG", "After Error Occure: ", )
                var second = async {secondCoroutine()}
                var total = first.await() + second.await() + thread.await()
                Log.e("TAG", "Async: " + total + " Name " + Thread.currentThread().name)
                Toast.makeText(this@CoroutineActivity, "Total = $total", Toast.LENGTH_SHORT).show()
            }
        })

        exceptionHandlingSuperVise.setOnClickListener({



            lifecycleScope.launch {
                try {
                    var corScope = supervisorScope {
                        var first = async {  firstCoroutine() }
                        var thread = async {errorCoroutine()}
                        Log.e("TAG", "After Error Occure: ", )
                        var second = async {secondCoroutine()}
                         var total = first.await() + second.await() + thread.await()
                           Log.e("TAG", "Async: " + total + " Name " + Thread.currentThread().name)
                        /* Toast.makeText(this@CoroutineActivity, "Total = $total", Toast.LENGTH_SHORT)
                            .show()*/
                    }
                } catch (e: Exception) {
                    Log.e("TAG", "Err: " + e.toString())
                }
            }

        })
        viewModelScope.setOnClickListener({
            var myViewModel: MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
            myViewModel.getData()
            myViewModel.data.observe(this, {
                Log.e("TAG", "View Model Scope: $it" )
                Toast.makeText(this,"View Model Scope: $it",Toast.LENGTH_SHORT).show()
                })
        })
        liveDataScope.setOnClickListener({
            var myViewModel: MyViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
            myViewModel.myData.observe(this,{
                Log.e("TAG", "Live Model Scope: $it" )
                Toast.makeText(this,"Live Data Scope: $it",Toast.LENGTH_SHORT).show()
            })
        })

        myjob.setOnClickListener({

            var corScope = CoroutineScope(Dispatchers.Main + parentJob).launch {
                var first =   firstCoroutine()
                Log.e("TAG", "in Between ", )
                parentJob.cancel()
                Log.e("TAG", " After cancel: iscancel ${parentJob.isCancelled} \n" +
                        " iscomplete ${parentJob.isCompleted} \n  isActivie ${parentJob.isActive}" )
                var second = secondCoroutine()
                var total = first + second
                Log.e("TAG", "Async: " + total + " Name " + Thread.currentThread().name)
                Toast.makeText(this@CoroutineActivity, "Total = $total", Toast.LENGTH_SHORT).show()
            }
        })


    }
    private suspend  fun firstCoroutine() :Int
    {
        delay(10000)
        Log.e("TAG", "firstCoroutine: "+Thread.currentThread().name)
        Log.e("TAG", "first Job Info : iscancel ${parentJob.isCancelled} \n" +
                " iscomplete ${parentJob.isCompleted} \n  isActivie ${parentJob.isActive}" )
        return 10
    }
    suspend fun secondCoroutine() : Int
    {
       // delay(10000)
        Log.e("TAG", "Second Job Info: iscancel ${parentJob.isCancelled} \n" +
                " iscomplete ${parentJob.isCompleted} \n  isActivie ${parentJob.isActive}" )
        Log.e("TAG", "secondCoroutine: "+Thread.currentThread().name)
        return 30
    }
    suspend fun errorCoroutine() : Int
    {
        var div =0
       /* try {*/
             div = 5/0
            Log.e("TAG", "errorCoroutine: "+Thread.currentThread().name)
      /*  }
        catch (e  : Exception)
        {
            Log.e("TAG", "errorCoroutine: "+Thread.currentThread().name+"\n E "+e.toString())

        }*/

        return div
    }
}