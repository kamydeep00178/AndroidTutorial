package com.tech.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fragment.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OneFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var TAG : String="OneFragment"

    override fun onAttach(context: Context) {
        super.onAttach(context)

        Log.e(TAG, "onAttach: ")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e(TAG, "onCreate: ", )

       // setRetainInstance(true);

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.e(TAG, "onCreateView: ", )
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OneFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            OneFragment().apply {
               /* arguments = Bundle().apply {

                }*/
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.e(TAG, "onActivityCreated: ", )
        
    }

    override fun onStart() {
        super.onStart()
        Log.e(TAG, "onStart: ", )
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG, "onResume: ", )
    }

    override fun onPause() {
        super.onPause()
        Log.e(TAG, "onPause: ", )
    }

    override fun onStop() {
        super.onStop()
        Log.e(TAG, "onStop: ", )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e(TAG, "onDestroyView: ", )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(TAG, "onDestroy: ", )
    }

    override fun onDetach() {
        super.onDetach()
        Log.e(TAG, "onDetach: ", )
    }

}