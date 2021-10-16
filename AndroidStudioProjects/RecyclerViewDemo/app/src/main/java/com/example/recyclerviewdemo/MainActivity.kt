package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: MutableList<String>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

//        recyclerView = findViewById(R.id.Recycler_view)
        val monthAdapter = MonthAdapter(dataList)
        binding.RecyclerView.adapter = monthAdapter
        binding.RecyclerView.layoutManager = LinearLayoutManager(this)

    }

    private fun initData(){
         dataList = mutableListOf<String>("Jan","Feb","Mar","April",
            "May","June","july","Aug", "Sep","Oct","Nov","Dec","Jan","Feb","Mar","April",
             "May","June","july","Aug", "Sep","Oct","Nov","Dec")
    }
}