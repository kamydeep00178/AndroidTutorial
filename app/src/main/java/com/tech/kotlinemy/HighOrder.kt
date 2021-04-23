package com.tech.kotlinemy

class HighOrder {

    /** In Kotlin, a function which can accepts a function
     *     as parameter or can returns a function is called Higher-Order function
     *     There are two types of lambda expression which can be passed-
     *   1.  Lambda expression which return Unit
     *   2.  Lambda expression which return any of the value integer,string etc
     *
     *   There are two types of functions which can be passed-
     *
     *   3.function which return Unit
     *   4.function which return any of the value integer,string etc
     */



   // 1. lamda with Unit
    var lamda = { println("kamal deep kakkar")}

    fun highFun( lmbd: () -> Unit )
    {
            lmbd()
    }

   // 2. lambda with paramater and return

    var lambda = {a : Int ,b: Int -> a+b }

    fun highfunReturn( lmbd: (Int,Int) -> Int)
    {
        println("Return Sum"+ lmbd(2,4))
    }

    //3. Function which return unit

    fun printMe(s: String) : Unit
    {
        println(s)
    }

    fun higherFun(string: String,myfun:(String)-> Unit)
    {
        myfun(string)
    }

    // Return Integer
    fun add(a: Int, b: Int): Int{
        var sum = a + b
        return sum
    }
    fun higherfunc(addfunc:(Int,Int)-> Int){
        // invoke regular function using local name
        var result = addfunc(3,6)
        println("The sum of two numbers is: $result")
    }


    // 5. Returning a function from Higher-Order function
    fun mul(a: Int, b: Int): Int{
        return a*b
    }
    //higher-order function declaration
    fun higherfunc() : ((Int,Int)-> Int){
        return ::mul
    }

    fun main1()
    {
        highFun(lamda)
        highfunReturn(lambda)
        higherFun("kkkkkk fun",::printMe)
        higherfunc(::add)
        // invoke function and store the returned function into a variable
        val multiply = higherfunc()
        // invokes the mul() function by passing arguments
        val result = multiply(2,4)
        println("The multiplication of two numbers is: $result")

    }

}