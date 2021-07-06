package com.tech.activity

import android.content.Intent
import android.os.*
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fragment.R
import com.tech.dagger.di.componenet.AshComponent
import com.tech.dagger.di.componenet.DaggerAshComponent
import com.tech.dagger.di.module.PrabalMpModule
import com.tech.dagger.mypack.Ashmeet
import com.tech.dagger.mypack.PrabalMp
import com.tech.handler.MyHandlerThread
import com.tech.kotlinemy.HighOrder
import com.tech.kotlinemy.MyConstructor
import kotlinx.android.synthetic.main.activity_life_cycle.*
import javax.inject.Inject
import kotlin.properties.Delegates


class ActivityLifeCycle : AppCompatActivity() {



     var a =100

      var b : Int ? = 10

    var test by  Delegates.notNull<String>()



    @Inject lateinit var Ashmeet : Ashmeet

    lateinit var person : Person;


    val TAG = "ActivityLifeCycle"
    var TAG1="Kamal"

    private val handlerThread: MyHandlerThread = MyHandlerThread()
    private val runnable1 = ExampleRunnable1()
    private val token = Any()

    var oooo : String ? ="iiiiiiiiii"
    var tttt : String  ="qqqqqqqqq"


    companion object{
        var count =10
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: ")
    }

    fun doWork() {
        val msg = Message.obtain(handlerThread.getHandler())
        msg.what = 1
        msg.arg1 = 23
        msg.obj = "Obj String"
        //msg.setData();
        msg.sendToTarget()
        //handlerThread.getHandler().sendEmptyMessage(1);
     //   handlerThread.getHandler()!!.postAtTime(runnable1, token, SystemClock.uptimeMillis())
        handlerThread.getHandler()!!.post(runnable1)
        //handlerThread.getHandler().post(new ExampleRunnable1());
        //handlerThread.getHandler().postAtFrontOfQueue(new ExampleRunnable2());
    }

    fun removeMessages() {
        handlerThread.getHandler()!!.removeCallbacks(runnable1, token)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContentView(R.layout.activity_life_cycle)

        Log.e(TAG, "After before onCreate: ", )




        if(isFinishing)
        {
            Log.e(TAG, "Check  ", )

        }

        Log.e(TAG, "After finish onCreate: ", )

        handlerThread.start();

        checkExt("kamal.txt")

        var ashmeet : AshComponent = DaggerAshComponent.builder()
            .country("India")
            .kiloMeter("100")
            .build()
        ashmeet.inject(this)

        Ashmeet.provideInfo()


        var highOrder  = HighOrder()
        highOrder.main1()

      //  var messg : Message = Message.obtain()

        var handler : Handler = Handler()
        //handler.po

       // Looper.getMainLooper()
      //  Looper.prepare()// add Messge Queue auto





        val add = MyConstructor(5, 6)
         val res= add square 3
        Log.e("TAG", "Infix "+ res )
       // Log.e(TAG, "Sum: ${add.c}")

        Log.e(TAG, "onCreate: ")

        Log.e(
            TAG,
            "onCreate: " + savedInstanceState?.getString("key") + savedInstanceState?.getString("key1")
        )
        buttonSecond.setOnClickListener({
            doWork()
            Toast.makeText(this,"Kamal",Toast.LENGTH_SHORT).show()
            /* val intent: Intent = Intent(this, SecondActivity::class.java)
             startActivity(intent)*/
        })
        singleTop.setOnClickListener({
            val intent = Intent(this, SingleTOP::class.java)

            startActivity(intent)
        })

        singleInstace.setOnClickListener({
            val intent = Intent(this, SingleInstance::class.java)
            intent.putExtra("k","v")
            var bundle  = Bundle()
            bundle.putString("key","value")
            intent.putExtras(bundle)
            startActivity(intent)
        })





        // let example
         //1. use when rsult of the call chain
        val numbers = mutableListOf("one", "two", "three", "four", "five")

         numbers.map { it.length }.filter { it > 3 }.let {
            Log.e("Let", it.toString())

        }
        // without
        val withoutLEt =numbers.map { it.length }.filter { it > 3 }
        Log.e("Let", withoutLEt.toString())

        //1.2. null check and perform some action on it
        val nullableString : String?=null

        Log.e(TAG, "onCreate: without let " + nullableString)

        nullableString?.let {


            Log.e("Let 2nd", it.toString())
        }

        val person2 = Person("kamal", "deep").let {

            Log.e("TAG", " in side let using this : " + this)

            Log.e("TAG", " in side let using it: " + it)

            it.address="FDK"
            it.contactNumber="9988200178"
         //   it.displayInfo()
              "it is done by let"
        }

        Log.e("TAG", "let: " + person2)

        //2. Run
        // Use when we intialize the object and perform some operation on it
        val person = Person("kamal", "deep").run {
            address="FDK"
            contactNumber="9988200178"
       //     displayInfo()
            "kamal"

        }

        Log.e("TAG", "run: " + person)

        // in both we can get the same object and different object depond upon us if we modiify it

        //3. apply
        // use when intailize the object
        // why we not used run : because run returnthe diferent object but apply retrun same object
        val person1 = Person("kamal", "deep").apply {
            address="FDK"
            contactNumber="9988200178"
          //  displayInfo()
          return@apply
        }

        Log.e("TAG", "apply: " + person1)

        // 4. also
        // use when in chain without break the chain used for debug pupose
        val numbers1 = mutableListOf("one", "two", "three", "four", "five")
        numbers.map { it.length }.also {
            Log.e("TAG", "also: " + it)
        }.filter { it > 3 }.let {
            Log.e("Let", it.toString())

        }
        // apply and also dose not modify the  object but let and run modify the object

        val person5 = Person("kamal", "deep").also {
            Log.e("TAG", "also: " + it.name)
            it.name="kamal"

        }.run {
            name="FDK"
            contactNumber="9988200178"
            //  displayInfo()
            return@run "kamal"
        }
            Log.e("TAG", "also: " + person5)


    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ")
        handlerThread.quit();

    }


    override fun onRestart() {
        super.onRestart()
        Log.e(TAG, "onRestart: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e(TAG, "onSaveInstanceState: ")
        outState.putString("key", "Value")
        outState.putString("key1", "Value1")

    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(
            TAG,
            "onRestoreInstanceState: " + savedInstanceState.getString("key") + savedInstanceState.getString(
                "key1"
            )
        )

    }


    override fun onBackPressed() {
        super.onBackPressed()
        Log.e(TAG, "onBackPressed: ")
    }


     fun checkExt(str: String) : String {
         var ext = str.split(".")[1]
         Log.e(TAG, "checkExt: " + ext)
         return ext
     }

    fun longestInArray()
    {
        val arry= arrayOf("Bangalore", "kotlin", "java", "Instavans")
        var lar = arry[0].length
        var largestName = ""
        for(item in arry)
        {
            var cuurent = item.length
            if(lar < cuurent)
            {
                lar = cuurent
                largestName=item
            }
        }

    }

    fun  sumOfElements() {
        val num : IntArray = intArrayOf(1, 2, 3, 4, 5)
       // APIKEY
       // NAMECONST1
       // NAMECONST
      //  MyClass.age

        print("Sum:" + num.sum())


    }

    internal class ExampleRunnable1 : Runnable {
        override fun run() {
            for (i in 0..3) {
                Log.d("TAG", "Runnable1: $i"+"------"+Thread.currentThread().name)
                SystemClock.sleep(1000)
            }
        }
    }

    internal class ExampleRunnable2 : Runnable {
        override fun run() {
            for (i in 0..3) {
                Log.d("TAG", "Runnable2: $i")
                SystemClock.sleep(1000)
            }
        }
    }


}