package com.example.samplemvvemproject.ui.home

import android.os.Bundle
import android.view.View

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.samplemvvemproject.base.BaseFragment
import com.example.samplemvvemproject.databinding.FragmentHomeBinding
import com.example.samplemvvemproject.ui.home.model.Product
import com.example.samplemvvemproject.Backend.StateApi

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val viewModel: HomeViewModel by viewModels()

    private val productAdapter by lazy {
        ProductAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        fetchData()
        observeProducts()
    }

    private fun initUi() {
        val linearLayoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL,false)
        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = productAdapter
        }
        productAdapter.setOnItemClickListener {

        }
    }

    private fun fetchData() {
        viewModel.fetchProducts()

    }

    @SuppressLint("SuspiciousIndentation")
    private fun observeProducts() {
        viewModel.products.observe(viewLifecycleOwner, Observer { response ->

            when (response) {

                is StateApi.Success -> {
                    response.data?.let { it.products.let { it1 -> updateUi(it1) } }
                }
                is StateApi.Error -> {

                    when (response) {
                        is StateApi.Error.ConnectionError -> {

                        }

                        is StateApi.Error.TimeOut -> {

                        }

                        else -> {

                        }
                    }
                }
            }
        })
    }

    private fun updateUi(products: ArrayList<Product>) {
        productAdapter.setItems(products)
    }
}