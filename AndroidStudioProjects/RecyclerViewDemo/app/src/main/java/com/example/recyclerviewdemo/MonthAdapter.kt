package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.databinding.RowBinding

class MonthAdapter (val monthList: List<String>):
    RecyclerView.Adapter<MonthAdapter.MonthViewHolder>() {

    private lateinit var binding: RowBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthViewHolder {
//        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        binding = RowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  MonthViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MonthViewHolder, position: Int) {
        val monthName = monthList[position]
//        holder.monthNameTextView.text = monthName
        holder.bindTo(monthName)
    }

    override fun getItemCount(): Int {
        return monthList.size
    }

//      class MonthViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    class MonthViewHolder(var binding: RowBinding): RecyclerView.ViewHolder(binding.root){
//        val monthNameTextView = binding.TVRow
    fun bindTo(name:String){
        binding.TVRow.text = name
    }
    }
}