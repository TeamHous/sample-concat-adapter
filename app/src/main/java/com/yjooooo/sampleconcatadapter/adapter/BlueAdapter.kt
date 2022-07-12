package com.yjooooo.sampleconcatadapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.sampleconcatadapter.BR
import com.yjooooo.sampleconcatadapter.Color
import com.yjooooo.sampleconcatadapter.databinding.ItemBlueBinding

class BlueAdapter: ListAdapter<Color, BlueAdapter.BlueViewHolder>(redDiffUtil) {
    class BlueViewHolder(private val binding: ItemBlueBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(blueColor: Color) {
            binding.setVariable(BR.blueStr, blueColor.colorName)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlueViewHolder {
        return BlueViewHolder(
            ItemBlueBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BlueViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val redDiffUtil = object : DiffUtil.ItemCallback<Color>() {
            override fun areItemsTheSame(oldItem: Color, newItem: Color): Boolean =
                oldItem.colorName == newItem.colorName

            override fun areContentsTheSame(oldItem: Color, newItem: Color): Boolean =
                oldItem == newItem

        }
    }
}
