package com.example.project_kotlin.Fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import com.example.project_kotlin.MainActivity2
import com.example.project_kotlin.R
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.fragment_1.*


@SuppressLint("ResourceType")
class Fragment_1 : BaseAdapterFragment(R.layout.fragment_1) {


    override fun init() {



        saved_button_frag1.setOnClickListener {

            val intent = Intent(view?.context,MainActivity2::class.java)
            startActivity(intent)
        }

        checkBox1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                checkBox2.isChecked=false

            }
        }
        checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                checkBox1.isChecked=false

            }
        }

    }

}