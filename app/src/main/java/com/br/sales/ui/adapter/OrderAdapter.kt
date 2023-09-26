package com.br.sales.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.sales.R
import com.br.sales.data.Order
import com.br.sales.databinding.LayoutItemOrderBinding

class OrderAdapter(private val list: List<Order>, private val action: ((Order) -> Unit)) :
    RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    private lateinit var binding: LayoutItemOrderBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        binding = LayoutItemOrderBinding.inflate(LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], context, action)
    }

    class ViewHolder(private val binding: LayoutItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(order: Order, context: Context,  action: ((Order) -> Unit)) {
            binding.tvNumberOrder.text = context.getString(R.string.msg_order_number, order.uid)
            binding.tvNumberOrder.setOnClickListener {
                action.invoke(order)
            }
        }
    }
}