package com.br.sales.ui.fragment

import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.br.sales.databinding.FragmentHomeBinding
import com.br.sales.ui.adapter.OrderAdapter
import com.br.sales.ui.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val homeViewModel by viewModel<HomeViewModel>()

    override fun getViewBinding(inflater: LayoutInflater) = FragmentHomeBinding.inflate(inflater)

    override fun initialize() {
        binding.fabNewOrder.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.toNewOrder())
        }

        homeViewModel.getAllOrder()

        homeViewModel.listOrder.observe(this) {
            binding.rvListOrder.layoutManager = LinearLayoutManager(context)
            binding.rvListOrder.adapter = OrderAdapter(it) { order ->
                findNavController().navigate(HomeFragmentDirections.toOrderDetail(order))
            }

            binding.rvListOrder.visibility = View.VISIBLE
            binding.ivEmpty.visibility = View.GONE
            binding.tvMsgEmpty.visibility = View.GONE
        }
    }
}