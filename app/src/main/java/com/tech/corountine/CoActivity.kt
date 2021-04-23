package com.tech.corountine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.fragment.R
import kotlinx.android.synthetic.main.activity_co.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlin.math.log

class CoActivity : AppCompatActivity() {





    private val parentJob = Job()
    // 1
    private val coroutineExceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            //2
            coroutineScope.launch(Dispatchers.Main) {
                //3
              //  errorMessage.visibility = View.VISIBLE
               // errorMessage.text = getString(R.string.error_message)
             //   Log.e("TAG", ": "+ex)
            }

            GlobalScope.launch { println("Caught $throwable") }
        }
    private val coroutineScope = CoroutineScope(Dispatchers.Main + parentJob +
            coroutineExceptionHandler)



    private var count =0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_co)




        asyncCo.setOnClickListener({

            CoroutineScope(Dispatchers.IO).launch {
                var result1 = async { getStock1() }
                var result2 = async { getStock2() }
                var total = result1.await() + result2.await()
                Log.e("TAG", "onCreate: $total"+Thread.currentThread().name)
            }


        })

       CoroutineScope(Dispatchers.Main).launch {
            txt.text=UserDataManager2().getTotalUserCount().toString()
           // txt.text = UserDataManager1().getTotalUserCount().toString()

        }


        btnCo.setOnClickListener({
            coroutineScope.launch {
                Log.e("TAG", "onCreate: "+Thread.currentThread().name )
                first()
                Log.e("TAG", "onCreate1: "+Thread.currentThread().name )
                second()
            }


        })


//        CoroutineScope(Dispatchers.Main).launch{
//            Log.e("TAG-----", "Start......")
//            val stock1= async(IO) {  getStock1()}
//            val stock2 = async(IO) {  getStock2()}
//            val total = stock1.await()+stock2.await()
//            Log.e("TAG---", "Total is $total")
//            Toast.makeText(applicationContext,"Total is $total",Toast.LENGTH_LONG).show()
//        }

        btn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadData()
            }
        }
        btn1.setOnClickListener {
            txt1.text=count++.toString()

        }

    }

    private suspend fun getStock1():Int{
          delay(10000)

            Log.e("TAG", "Stock 1 returned" +Thread.currentThread().name)
        return 55000
    }
    private suspend fun getStock2():Int{
        delay(8000)
        Log.e("TAG", "Stock 2 returned" )
        return 35000
    }

    private suspend fun downloadData() {
            for (i in 1..200000) {
                withContext(Dispatchers.Main)
                {
                    txt.text="downloadData: $i in ${Thread.currentThread().name}"

                }
                Log.e("TAG", "downloadData: $i in ${Thread.currentThread().name}")
            }

        }
    @Throws(Exception::class)
    private suspend fun first(){
        withContext(Dispatchers.Main)
        {
            Toast.makeText(applicationContext,"first",Toast.LENGTH_SHORT).show()
            Log.e("TAG", "onCreate1FF: "+Thread.currentThread().name )
          //  val a = 10/0
         throw Exception()
           // parentJob.cancel()
        }
    }
    private suspend fun second(){
        withContext(Dispatchers.Main)
        {
            Toast.makeText(applicationContext,"second",Toast.LENGTH_SHORT).show()
            Log.e("TAG", "onCreate1SS: "+Thread.currentThread().name )

        }
    }

}