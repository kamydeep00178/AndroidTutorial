package com.tech.demoFragmentWithRecyclerView.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fragment.R
import com.fragment.databinding.OrderLayoutBinding
import com.tech.demoFragmentWithRecyclerView.model.OrderModel

class MyAdaptor(var list : ArrayList<OrderModel>,var context: Context, private val clickListener: (OrderModel) -> Unit):
    RecyclerView.Adapter<MyAdaptor.MyViewHolder>() {


    class MyViewHolder(var orderBinding : OrderLayoutBinding) :
        RecyclerView.ViewHolder(orderBinding.root)
    {
            fun bind(orderModel : OrderModel,clickListener: (OrderModel) -> Unit)
            {
                orderBinding.orderModel=orderModel
                orderBinding.parnet.setOnClickListener {
                   clickListener(orderModel)
                }

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var layoutInfalter= LayoutInflater.from(context)
        val itemRowBimding : OrderLayoutBinding=
            DataBindingUtil.inflate(layoutInfalter, R.layout.order_layout,parent,false)

        return MyViewHolder(itemRowBimding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var data = list.get(position)
        holder.bind(data,clickListener)
    }

    override fun getItemCount(): Int = list.size
}