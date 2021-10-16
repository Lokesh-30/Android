package com.example.recyclerviewextwo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewextwo.databinding.ContactsBinding

class ContactAdapter(val contactList: MutableList<String>):
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private lateinit var binding: ContactsBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        binding = ContactsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contactList[position]
        holder.bindTo(contact)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    class ContactViewHolder(var binding:ContactsBinding): RecyclerView.ViewHolder(binding.root){
        fun bindTo(name: String){
            binding.TVContacts.text = name
        }
    }
}
