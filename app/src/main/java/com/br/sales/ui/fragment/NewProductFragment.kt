package com.br.sales.ui.fragment

import android.view.LayoutInflater
import androidx.navigation.fragment.findNavController
import com.br.sales.databinding.FragmentNewProductBinding
import com.br.sales.ui.viewmodel.SalesViewModel
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class NewProductFragment : BaseFragment<FragmentNewProductBinding>() {
    private val salesViewModel by activityViewModel<SalesViewModel>()

    override fun getViewBinding(inflater: LayoutInflater) =
        FragmentNewProductBinding.inflate(inflater)

    override fun initialize() {
        binding.btInclude.setOnClickListener {
            salesViewModel.addProduct(
                binding.etProductName.text.toString(),
                binding.etQuantity.text.toString(),
                binding.etValueUnit.text.toString()
            )
            findNavController().navigate(NewProductFragmentDirections.popUpToNewOrder())
        }
    }
}