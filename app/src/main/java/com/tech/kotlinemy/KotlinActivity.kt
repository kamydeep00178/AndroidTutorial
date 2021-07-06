package com.tech.kotlinemy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fragment.R
import kotlinx.android.synthetic.main.activity_kotlin.*

class KotlinActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)



        highOrder.setOnClickListener{
         var highOrder = HighOrder()
            highOrder.main1()
        }
        //inline https://blog.mindorks.com/understanding-inline-noinline-and-crossinline-in-kotlin

        extens.setOnClickListener{
            var name  ="kamal kakkar"
            Log.e("TAG", "Extension fun 1 ----> : ${name.firstCharacter}" )
            name = name.capitalizeWords()
            Log.e("TAG", "Extension fun 2 ----> : $name" )
            var data : Int = 4

            Log.e("TAG", "Extension fun 2 ----> : ${data.myPlus}" )


        }
        letScope.setOnClickListener {

            // object ref : it
            // return value : lambda result
            // 1. first use case
        //let function is often used to provide null safety calls. Use safe call operator(?.)
        // with ‘let’ for null safety. It executes the block only with the non-null value.
            var a : Int ? =null
            try {
                Log.e("TAG", "onCreate: "+a)
            }
            catch (e : Exception)
            {
                Log.e("TAG", "onCreate: Exc"+e.toString() )
            }

            // if we want it is only go in block if value is assign
            a?.let {
                Log.e("TAG", " Not onCreate: "+a)
            }
            a =  2
            a?.let {
                Log.e("TAG", "  first use case of let: "+a)
            }
        // 2. use case
        //Simply put, a transformation function takes a source of one type and returns a target of another type.
        val stringBuilder = StringBuffer()
        val numberOfCharacters = stringBuilder.let {
            it.append("This is a transformation function.")
            it.append("It takes a StringBuilder instance " +
                    "and returns the number of characters in the generated String")
            it.length
        }
         Log.e("TAG", "2nd use case of let : "+numberOfCharacters)

         //3 use case
         // use with elvis operator
            var message: String? = "hello there!"
            var charactersInMessage = message?.let {
                "value was not null: $it"
            } ?: "value was null"
            Log.e("TAG", "3 rd use case: with data "+charactersInMessage )
             message = null
             charactersInMessage = message?.let {
                "value was not null: $it"
            } ?: "value was null"
            Log.e("TAG", "3 rd use case: without data "+charactersInMessage )

           // if  last statement in let is non assignment , it return  last value anf if not
            // it return unit
            // it can rename , so its readable
            //4. it can use with chain operator
            val numbers = mutableListOf("One","Two","Three","Four","Five")
            numbers.map { it.length }.filter { it > 3 }.let {
                Log.e("TAG", "4th use case onCreate: "+it)
            }
        }
        applyScope.setOnClickListener {
         //   Context object   :    this
        //    Return value     :    context object
          //As the name implies – “Apply these to the object”.
        //  1. 1st use case
            //maybe we don’t want the extra verbosity of an it
            // It can be used to operate on members of the receiver object mostly to initialize members.
           var data= MyScopeClass()?.apply {
                name = "kamal"
                age = "10"
            }
            Log.e("TAG", "apply use case: "+data.age+data.name)
           //2 use case
          //Or, we can use it to easily create builder-style objects:
            val student = MyScopeBuilderClassUsingApply()
                .name("kamal")
                .age("30")
                .rollNo("100")
            Log.e("TAG", "2nd use case : apply "+student.name+student.age+student.rollNo)

        }
        withScope.setOnClickListener {
            //Context object  :   this
            //Return value    :   lambda result
            //Recommended use of ‘with’ for calling functions on context objects
            // without providing the lambda result.
            //It’s like run in that it has an implicit this, but it’s not an extension method:
            //We can use with to restrict an object to a scope.
            // For null check we add ? with each variable this diff from run
            var data :MyScopeClass ? = null
            with(data)
            {
                this?.name = "kamal"
                this?.age="10"
                Log.e("TAG", "in with: "+this?.name)
            }
            Log.e("TAG" ,"outer With SCope: "+ data?.name )

            data =MyScopeClass()
            with(data)
            {
                this?.name = "kamal"
                this?.age="10"
                Log.e("TAG", "in with: "+name)
                return@with "this is $name + $age"
            }
            Log.e("TAG" ,"outer With SCope: "+ data?.name )

        }
        runScope.setOnClickListener {
            //Context object   :    this
            //Return value     :    lambda result
            //Used when the object lambda contains both initialization and the computation of the return value.
         // Using run we can perform null safety calls as well as other computations.
         //run is related to let in the same way that apply is related to also:
        //The “run” operator is similar to the “let” operator in terms
        // of accepting a return value that is different from the object on which the scope function is being applied to. Hence,
        // a “run” operator can be used to initialize an object and return the result of it.
            var data :MyScopeClass ? = null
            data?.run{
                name = "kamal"
                age="10"
                Log.e("TAG", "in with: "+name)
            }
            Log.e("TAG" ,"outer run SCope: "+ data?.name )

            data =MyScopeClass()
         val myData= data?.run{
                name = "kamal"
                age="10"
                 "this is $name + $age"
            }
            Log.e("TAG" ,"outer run SCope: "+ myData )

            val stringBuilder = StringBuffer()
            val numberOfCharacters = stringBuilder.run {
                append("This is a transformation function.")
                append("It takes a StringBuilder instance " +
                        "and returns the number of characters in the generated String")
                length
            }
            Log.e("TAG", "2nd use case of run : "+numberOfCharacters)

        }
        alsoScope.setOnClickListener {
            //Context object   :    it
            //Return value     :    context object
            //It is used where we have to perform additional operations when we have initialized the object members.
            val list = mutableListOf<Int>(1, 2, 3)

            // later if we want to perform
            // multiple operations on this list
            list.also {
                it.add(4)
                it.remove(2)
                // more operations if needed
            }
            Log.e("TAG", "onCreate: "+list)

           //It’ll return the object it was invoked on, which makes it handy when we want to generate some side logic on a call chain:
           //val headers = restClient
            //  .getResponse()
            //  .also { logger.info(it.toString()) }
            //  .getHeaders()

           // And we can use also to initialize objects:
            var data = MyScopeClass().also {
                it.name= "kamal"
            }
            Log.e("TAG", "onCreate: "+ data.name)
        }


        outerFunction("kamal")
    }
    fun outerFunction(nice: String) {
        val hello = "Hello, world"

        fun innerFunction(awesome: String) {
            Log.e("TAG", "innerFunction: "+awesome)

            // we can access arguments of outer function
            Log.e("TAG", "innerFunction: "+nice)


            // and we can also access variables declared in outer functions
            Log.e("TAG", "innerFunction: "+hello)

        }

        // invoking inner function
        innerFunction("This is awesome")
    }
}