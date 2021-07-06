package com.tech.fragment

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.fragment.R
import com.tech.singleton.MySInglton
import kotlinx.android.synthetic.main.activity_main.*


class FragmentActivity : AppCompatActivity() , OneFragment.TextClickedListener{

    var TAG : String="Activity"


    var ft: FragmentTransaction = supportFragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e(TAG, "onCreate: ")
        getSupportActionBar()?.setTitle("Hello world App");


        Log.e("TAG", "onCreate: "+ MySInglton.getData())


        lateinit var oneFrag : OneFragment;
        var allFragment : List<Fragment> ;
         var index : Int =0;
        var rIndex : Int =0;

        allFragment= getFragments();
       /* var ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(R.id.fragment, OneFragment(), "Tag")
        ft.commit()
*/
        one.setOnClickListener(View.OnClickListener {
            var ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment, OneFragment(), "Tag")
            ft.commit()

        })


        second.setOnClickListener(View.OnClickListener {

            var ft: FragmentTransaction = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragment, SecondFragment())
            ft.commit()


        })
        addFragment.setOnClickListener(View.OnClickListener {

            if (allFragment.size > index) {
                addFragment(allFragment.get(index), "Tag" + index);
                index++;
            }

        })
        replaceFragment.setOnClickListener(View.OnClickListener {

            if (allFragment.size > rIndex) {
                replaceFragment(allFragment.get(rIndex), "Tag" + index);
                rIndex++;
            }

        })







    }
    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: ")

    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: ")
//        var ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment, SecondFragment())
        ft.commit()

    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ")
    }
    
    

    fun addFragment(fragment: Fragment, TAG: String)
    {
        supportFragmentManager.beginTransaction().add(R.id.fragment, fragment, TAG)
        .addToBackStack("TAG").commitAllowingStateLoss()
    }

    fun replaceFragment(fragment: Fragment, TAG: String)
    {
        supportFragmentManager.beginTransaction().replace(R.id.fragment, fragment, TAG)
            .addToBackStack("TAG").commitAllowingStateLoss()
    }


    fun  getFragments() : List<Fragment>
    {
        val list: MutableList<Fragment> = ArrayList()
        val frag1: Fragment = OneFragment.newInstance();
        val frag2: Fragment = SecondFragment.newInstance("This is fragment 2", "This is fragment 2")
        val frag3: Fragment = ThirdFragment.newInstance("This is fragment3", "This is fragment 3")
      //  val frag4: Fragment = OneFragment.newInstance();

        list.add(frag1)
        list.add(frag2)
        list.add(frag3)
        //list.add(frag4)

        return list
    }




    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)


    }

    override fun sendText(text: String) {
//        val callingFragment = getSupportFragmentManager().findFragmentById(R.id.fragment_b) as FragmentB
//        //calling the updateText method of the FragmentB
//        callingFragment.updateText(text)
    }


}