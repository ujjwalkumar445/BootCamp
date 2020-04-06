package com.example.databindingkotlin1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingkotlin1.databinding.ItemLayoutBinding


class MyAdapter(private val item:List<User>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater= LayoutInflater.from(parent.context)
        val  binding:ItemLayoutBinding= DataBindingUtil.inflate(inflater, R.layout.item_layout, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.user=item.get(position)
        holder.binding.executePendingBindings()
    }
    class ViewHolder(var binding: ItemLayoutBinding):RecyclerView.ViewHolder(binding.root) {

    }
}