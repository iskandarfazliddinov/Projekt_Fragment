package com.example.project_kotlin.Fragments

import android.annotation.SuppressLint
import android.content.Intent
import com.example.project_kotlin.MainActivity
import com.example.project_kotlin.R
import kotlinx.android.synthetic.main.fragment_1.*


@SuppressLint("ResourceType")
class RegisterFragment : BaseAdapterFragment(R.layout.fragment_1) {


    override fun init() {


        saved_button_frag1.setOnClickListener {

            val intent = Intent(view?.context,MainActivity::class.java)
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