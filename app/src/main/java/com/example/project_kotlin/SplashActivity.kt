package com.example.project_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.project_kotlin.Fragments.RegisterFragment
import com.example.project_kotlin.Fragments.initial

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            initial(RegisterFragment())
        },3000)
    }
}