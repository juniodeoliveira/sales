package com.br.sales.ui.fragment

import android.view.LayoutInflater
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.sales.R
import com.br.sales.databinding.FragmentOrderDetailBinding
import com.br.sales.ui.adapter.ProductsAdapter
import com.br.sales.ui.viewmodel.OrderDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrderDetailFragment : BaseFragment<FragmentOrderDetailBinding>() {
    private val orderDetailViewModel by viewModel<OrderDetailViewModel>()
    private val args: OrderDetailFragmentArgs by navArgs()

    override fun getViewBinding(inflater: LayoutInflater) =
        FragmentOrderDetailBinding.inflate(inflater)

    override fun initialize() {
        orderDetailViewModel.initialize(args.order)

        orderDetailViewModel.clientName.observe(this) {
            binding.tvClientName.text = it
        }

        orderDetailViewModel.listProduct.observe(this) {
            binding.rvListProduct.adapter = ProductsAdapter(it)
            binding.rvListProduct.layoutManager = LinearLayoutManager(context)
        }

        orderDetailViewModel.qtdTotalItems.observe(this) {
            binding.tvQtdTotalItems.text = getString(R.string.msg_qtd_total_items, it)
        }

        orderDetailViewModel.totalValueOrder.observe(this) {
            binding.tvTotalValueOrder.text = getString(R.string.msg_value_total_order, it)
        }
    }
}