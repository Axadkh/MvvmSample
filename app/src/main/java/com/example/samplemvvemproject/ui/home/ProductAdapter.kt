package com.example.samplemvvemproject.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.Nullable
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.samplemvvemproject.base.BaseAdapter
import com.example.samplemvvemproject.databinding.ProductItemBinding
import com.example.samplemvvemproject.ui.home.model.Product
import com.example.samplemvvemproject.utils.ImageLoader


class ProductAdapter() : BaseAdapter<Product,ProductItemBinding>() {

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): ProductItemBinding {
        return ProductItemBinding.inflate(inflater, parent, false)
    }

    override fun createViewHolder(binding: ProductItemBinding): BaseViewHolder<ProductItemBinding> {
        return ViewHolder(binding)
    }


    inner class ViewHolder( val itembinding: ProductItemBinding) :
        BaseViewHolder<ProductItemBinding>(itembinding) {

        override fun bindItem(item: Product) {
            with(itembinding){
                tvProductTitle.text = item.title
                item.thumbnail?.let { ImageLoader.loadImage(it,ivProduct) }
            }
        }

    }

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        // Provide custom logic to check if items are the same
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        // Provide custom logic to check if item contents are the same
        return oldItem == newItem
    }


}