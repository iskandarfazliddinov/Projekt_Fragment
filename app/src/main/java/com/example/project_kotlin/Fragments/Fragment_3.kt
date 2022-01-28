package com.example.project_kotlin.Fragments

import android.annotation.SuppressLint
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project_kotlin.DataBase.MyAdapter
import com.example.project_kotlin.DataBase.MyDbMenger
import com.example.project_kotlin.DataBase.MyDbNameClass
import com.example.project_kotlin.R
import kotlinx.android.synthetic.main.fragment_3.*
import kotlinx.android.synthetic.main.fragment_4.*
import java.time.temporal.TemporalAdjusters.next

@SuppressLint("ResourceType")
class Fragment_3:BaseAdapterFragment(R.layout.fragment_3) {

    val myDbMenger = context?.let { MyDbMenger(it) }

    val listWorker = ArrayList<DataClassWorkers>()


    override fun init() {
        next()

    }

    override fun onResume() {
        super.onResume()
        myDbMenger?.openDb()
        AllAdapterItems()
    }
    fun AllAdapterItems(){
        myDbMenger?.let { adapterWorkers.updataAdapter(it.readData()) }
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbMenger?.closeDb()
    }
    fun next(){
        reyclerView?.layoutManager = LinearLayoutManager(context)

        adapterWorkers = AdapterWorkers(listWorker)
        reyclerView?.adapter = adapterWorkers
        adapterWorkers.notifyDataSetChanged()
    }
}