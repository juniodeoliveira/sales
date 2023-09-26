package com.br.sales.ui.fragment

import android.view.LayoutInflater
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.sales.R
import com.br.sales.databinding.FragmentNewOrderBinding
import com.br.sales.ui.adapter.ProductsAdapter
import com.br.sales.ui.viewmodel.SalesViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class NewOrderFragment : BaseFragment<FragmentNewOrderBinding>() {
    private val salesViewModel by activityViewModel<SalesViewModel>()

    override fun getViewBinding(inflater: LayoutInflater) =
        FragmentNewOrderBinding.inflate(inflater)

    override fun initialize() {
        binding.btAddItem.setOnClickListener {
            findNavController().navigate(NewOrderFragmentDirections.toNewProduct())
        }

        binding.btSaveOrder.setOnClickListener {
            salesViewModel.saveOrder(binding.etClientName.text.toString())
            findNavController().navigate(NewOrderFragmentDirections.popUpToHome())
        }

        binding.btCancelOrder.setOnClickListener {
            findNavController().navigate(NewOrderFragmentDirections.popUpToHome())
        }

        salesViewModel.listProduct.observe(this) {
            binding.rvListProduct.adapter = ProductsAdapter(it)
            binding.rvListProduct.layoutManager = LinearLayoutManager(context)
        }

        salesViewModel.qtdTotalItems.observe(this) {
            binding.tvQtdTotalItems.text = getString(R.string.msg_qtd_total_items, it)
        }

        salesViewModel.totalValueOrder.observe(this) {
            binding.tvTotalValueOrder.text = getString(R.string.msg_value_total_order, it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        salesViewModel.clearListProduct()
        binding.tvQtdTotalItems.text = ""
        binding.tvQtdTotalItems.text = ""
    }
}