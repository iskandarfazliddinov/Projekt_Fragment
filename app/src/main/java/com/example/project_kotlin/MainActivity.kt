package com.example.project_kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.translationMatrix
import com.example.project_kotlin.DataBase.MyDbMenger
import com.example.project_kotlin.Fragments.Fragment_3
import com.example.project_kotlin.Fragments.Fragment_4
import com.example.project_kotlin.Fragments.initial_2
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {

    val myDbMenger = MyDbMenger(this)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        saved_button.setOnClickListener {
            val malumot_turi = edit_data1.text.toString()
            val malumot_haqida = edit_data2.text.toString()

            myDbMenger.insertDb(malumot_turi,malumot_haqida)
            if(malumot_turi !=null && malumot_haqida!=null){
                initial_2(Fragment_3())
            }

        }
        navigation_view.setOnItemSelectedListener {
            when(it.itemId){
                R.id.add_icon->{
                    startActivity(Intent(this,MainActivity::class.java))
                    translationMatrix(0f,0f)
                }
                R.id.this_day->{
                    initial_2(Fragment_3())
                }
                R.id.obshe->{
                    initial_2(Fragment_4())
                }
            }
            true
        }


    }
    override fun onResume() {
        super.onResume()
        myDbMenger.openDb()

    }

    override fun onDestroy() {
        super.onDestroy()
        myDbMenger.closeDb()
    }


}