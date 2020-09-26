package com.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*


class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lateinit var oneFrag : OneFragment;
        var allFragment : List<Fragment> ;
         var index : Int =0;
        var rIndex : Int =0;

        allFragment= getFragments();

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

            if (allFragment.size>index) {
                addFragment(allFragment.get(index), "Tag" + index);
                index++;
            }

        })
        replaceFragment.setOnClickListener(View.OnClickListener {

            if (allFragment.size>rIndex) {
                replaceFragment(allFragment.get(rIndex), "Tag" + index);
                rIndex++;
            }

        })




    }

    fun addFragment(fragment: Fragment, TAG: String)
    {
        supportFragmentManager.beginTransaction().add(R.id.fragment, fragment, TAG)
        .addToBackStack("TAG").commit()
    }

    fun replaceFragment(fragment: Fragment, TAG: String)
    {
        supportFragmentManager.beginTransaction().replace(R.id.fragment, fragment, TAG)
            .addToBackStack("TAG").commit()
    }


    fun  getFragments() : List<Fragment>
    {
        val list: MutableList<Fragment> = ArrayList()
        val frag1: Fragment = OneFragment.newInstance();
        val frag2: Fragment = SecondFragment.newInstance("This is fragment 2","This is fragment 2")
        val frag3: Fragment = ThirdFragment.newInstance("This is fragment3","This is fragment 3")
        val frag4: Fragment = OneFragment.newInstance();

        list.add(frag1)
        list.add(frag2)
        list.add(frag3)
        list.add(frag4)

        return list
    }


}