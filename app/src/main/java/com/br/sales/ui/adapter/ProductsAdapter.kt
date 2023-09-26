package com.br.sales.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.br.sales.R
import com.br.sales.data.Product
import com.br.sales.databinding.LayoutItemProductBinding
import com.br.sales.ui.extension.formatToMoney

class ProductsAdapter(private val list: List<Product>) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    private lateinit var binding: LayoutItemProductBinding
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        binding = LayoutItemProductBinding.inflate(LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position], context)
    }

    class ViewHolder(private val binding: LayoutItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product, context: Context) {
            binding.tvNameProduct.text = context.getString(R.string.msg_product_name, product.name)
            binding.tvQuantityProduct.text = context.getString(R.string.msg_quantity_value, product.quantity)
            binding.tvUnitValue.text =  context.getString(R.string.msg_unit_value, product.unitValue.formatToMoney())
            binding.tvTotalValue.text = context.getString(R.string.msg_total_value, (product.unitValue * product.quantity).formatToMoney())
        }
    }
}