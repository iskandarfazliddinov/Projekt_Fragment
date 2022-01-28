package com.example.project_kotlin.Fragments

import android.annotation.SuppressLint
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project_kotlin.Data.Data
import com.example.project_kotlin.DataBase.MyAdapter
import com.example.project_kotlin.DataBase.MyDbMenger
import com.example.project_kotlin.DataBase.MyDbNameClass
import com.example.project_kotlin.R
import kotlinx.android.synthetic.main.fragment_3.*
import kotlinx.android.synthetic.main.fragment_4.*
import java.time.temporal.TemporalAdjusters.next

@SuppressLint("ResourceType")
class Fragment_3:BaseAdapterFragment(R.layout.fragment_3) {

    val data = ArrayList<Data>()

    private lateinit var adapter: MyAdapter

    val myDbMenger = view?.let { MyDbMenger(it?.context) }


    override fun init() {
        getRecyclerView()

    }

    override fun onResume() {
        super.onResume()
        myDbMenger?.openDb()
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbMenger?.closeDb()
    }

    fun getRecyclerView(){

        val list = arrayOf("a","b","c","d","e","f")

        (0..list.size-1).forEach{ i ->
            data.add(Data(list[i]))
        }

        val recyclerView: RecyclerView? = view?.findViewById(R.id.reyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(view?.context)

        adapter = MyAdapter(data)
        recyclerView?.adapter = adapter


    }
}