package com.example.project_kotlin.DataBase

import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_kotlin.R

class MyAdapter(listMain:ArrayList<String>):RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var listArr = listMain



    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        val tv_1: TextView = itemView.findViewById(R.id.text_malumot)


        fun setData(title: String){
            tv_1.text = title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.reyclerview_1,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.setData(listArr[position])

    }

    override fun getItemCount(): Int {
        return listArr.size
    }
    fun updataAdapter(listItem:ArrayList<String>){
        listArr.clear()
        listArr.addAll(listItem)
        notifyDataSetChanged()
    }
}