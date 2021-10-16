package com.example.recyclerviewextwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewextwo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var contactList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contactListData()
        setUpRecyclerView()

    }
    fun setUpRecyclerView(){
        val contactAdapter = ContactAdapter(contactList)
        binding.RecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = contactAdapter
        }
    }

    private fun contactListData(){
         contactList = mutableListOf<String>("LOKI\n   9876543210","BOSS\n   9786543210","RAM\n   9587643210",
            "JAANU\n   9887654321","RAVI\n   9987654321","DIYA\n   9997654321","LAKSHMI\n   9087654321","KRISH\n   8997654321",
            "MOHANA\n   90087654321","LOKI\n   9876543210","BOSS\n   9786543210","RAM\n   9587643210",
             "JAANU\n   9887654321","RAVI\n   9987654321","DIYA\n   9997654321","LAKSHMI\n   9087654321","KRISH\n   8997654321",
             "MOHANA\n   90087654321")
    }
}