package com.example.samplemvvemproject.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


abstract class BaseAdapter<T, VB : ViewBinding> :
    RecyclerView.Adapter<BaseAdapter<T, VB>.BaseViewHolder<VB>>() {

    protected val items: MutableList<T> = mutableListOf()
    private var onItemClickCallback: ((T) -> Unit)? = null
    private var onLongItemClickCallback: ((T) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = createBinding(inflater, parent, viewType)
        return createViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    protected abstract fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): VB

    protected abstract fun createViewHolder(binding: VB): BaseViewHolder<VB>

    fun setItems(newItems: List<T>) {
        val diffCallback = createDiffCallback(items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }

    fun clearItems() {
        val diffCallback = createDiffCallback(items, emptyList())
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items.clear()
        diffResult.dispatchUpdatesTo(this)
    }

    private fun createDiffCallback(oldList: List<T>, newList: List<T>): DiffUtil.Callback {
        return object : DiffUtil.Callback() {
            override fun getOldListSize(): Int = oldList.size

            override fun getNewListSize(): Int = newList.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldItem = oldList[oldItemPosition]
                val newItem = newList[newItemPosition]
                return areItemsTheSame(oldItem, newItem)
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                val oldItem = oldList[oldItemPosition]
                val newItem = newList[newItemPosition]
                return areContentsTheSame(oldItem, newItem)
            }
        }
    }

    protected open fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    protected open fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    fun setOnItemClickListener(callback: (T) -> Unit) {
        onItemClickCallback = callback
    }

    fun setOnItemLongClickListener(callback: (T) -> Unit) {
        onLongItemClickCallback = callback
    }

    abstract inner class BaseViewHolder<VB : ViewBinding>(val binding: VB) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickCallback?.invoke(items[position])
                }
            }

            itemView.setOnLongClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onLongItemClickCallback?.invoke(items[position])
                }
                true
            }
        }

        fun bind(item: T) {
            bindItem(item)
        }

        protected abstract fun bindItem(item: T)
    }
}
