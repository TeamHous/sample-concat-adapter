package com.yjooooo.sampleconcatadapter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.sampleconcatadapter.BR
import com.yjooooo.sampleconcatadapter.Color
import com.yjooooo.sampleconcatadapter.databinding.ItemYellowBinding

class YellowAdapter : ListAdapter<Color, YellowAdapter.YellowViewHolder>(redDiffUtil) {
    class YellowViewHolder(private val binding: ItemYellowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(yellowColor: Color) {
            binding.setVariable(BR.yellowStr, yellowColor.colorName)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YellowViewHolder {
        return YellowViewHolder(
            ItemYellowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: YellowViewHolder, position: Int) {
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
