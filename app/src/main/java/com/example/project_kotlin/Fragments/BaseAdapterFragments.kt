package com.example.project_kotlin.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.project_kotlin.R

@SuppressLint("ResourceType")
abstract class BaseAdapterFragment(@IdRes layout_id:Int): Fragment(layout_id) {

    val parent_layout_id = R.id.conterner_view

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    abstract fun init()

    fun addFragment(fragment: BaseAdapterFragment,id:Int = parent_layout_id){
        activity?.supportFragmentManager?.commit {
            addToBackStack(fragment.hashCode().toString())
            replace(id,fragment,"my_fragment")
        }
    }

}
fun AppCompatActivity.initial(fragment: BaseAdapterFragment){
    supportFragmentManager.beginTransaction().add(R.id.conterner_view,fragment).commit()
}
fun AppCompatActivity.initial_2(fragment: BaseAdapterFragment){
    supportFragmentManager.beginTransaction().add(R.id.conterner_view_2,fragment).commit()
}