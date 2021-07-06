package com.tech.demoFragmentWithRecyclerView

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fragment.R
import com.fragment.databinding.OrderFragmentBinding
import com.tech.demoFragmentWithRecyclerView.adapter.MyAdaptor
import com.tech.demoFragmentWithRecyclerView.model.OrderModel

class OrderFragment : Fragment() {

    var list = ArrayList<OrderModel>()
    lateinit var binding : OrderFragmentBinding
    var adapter= MyAdaptor(list, requireContext(), {selectedItem: OrderModel ->
        listItemClick(
            selectedItem
        )}
    )
    companion object {
        fun newInstance() = OrderFragment()
    }

    private lateinit var viewModel: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.order_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
        getData()

        binding.recyclerView.context
        val layoutMangaer= StaggeredGridLayoutManager(1, LinearLayoutManager.VERTICAL)
        binding.recyclerView.layoutManager=layoutMangaer
        binding.recyclerView.adapter=adapter
    }

    fun listItemClick(orderModel : OrderModel)
    {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container,OrderDetailFragment.newInstance())
            .addToBackStack("TAG")
            .commit()
    }

    fun getData()
    {
        var order = OrderModel(0,"kkkk0")
        list.add(order)
        var order1 = OrderModel(1,"kk1")
        list.add(order1)
        var order2 = OrderModel(2,"kk mam2")
        list.add(order2)
        var order3 = OrderModel(3,"qqq 3")
        list.add(order3)
        var order4 = OrderModel(4,"ww 4")
        list.add(order4)
        var order5 = OrderModel(5,"eeee 5")
        list.add(order5)
        var order6 = OrderModel(6," rrr ff 6")
        list.add(order6)
        var order7 = OrderModel(7,"tt ff 7")
        list.add(order7)
        var order8 = OrderModel(8,"y hhy 8")
        list.add(order8)
        var order9 = OrderModel(9,"uu jjj 9")
        list.add(order9)
        var order10 = OrderModel(10,"iii kkk 10")
        list.add(order10)
        var order11 = OrderModel(11,"11111111")
        list.add(order11)
        var order12 = OrderModel(12,"11122")
        list.add(order12)
        var order13 = OrderModel(13,"11133")
        list.add(order13)
        var order14 = OrderModel(14,"111444")
        list.add(order14)
        var order15 = OrderModel(15,"111555")
        list.add(order15)
        var order16 = OrderModel(16,"111666")
        list.add(order16)
        var order17 = OrderModel(17,"111777")
        list.add(order17)
        var order18 = OrderModel(18,"11188")
        list.add(order18)
        var order19 = OrderModel(19,"111999")
        list.add(order19)
        var order20 = OrderModel(20,"2000")
        list.add(order20)
    }
}