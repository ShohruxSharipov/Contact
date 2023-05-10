package com.example.myapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.contact.databinding.ContactItemBinding
import com.example.myapplication.DB.Entity.ContactEn
import com.example.myapplication.User.User

class Adapter(var list: List<ContactEn>):RecyclerView.Adapter<Adapter.MyHolder>() {
    class MyHolder(var binding: ContactItemBinding):RecyclerView.ViewHolder(binding.root){
        var name = binding.userName
        var number = binding.userNumber
    }





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(ContactItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var u1 = list[position]
        holder.name.text = u1.name
        holder.number.text = u1.number
    }
}