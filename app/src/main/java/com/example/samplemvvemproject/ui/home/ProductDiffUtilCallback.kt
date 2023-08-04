package com.example.samplemvvemproject.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.example.samplemvvemproject.ui.home.model.Product

class ProductDiffUtilCallback(private val oldList: ArrayList<Product>, private val newList: ArrayList<Product>) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].id == newList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return when {
                oldList[oldItemPosition] == newList[newItemPosition] -> true
                else -> false
            }
        }

        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            return super.getChangePayload(oldItemPosition, newItemPosition)
        }

    }