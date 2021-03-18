package com.julie.jffi_issue

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.julie.jffi_issue.databinding.ActivityMainBinding
import com.julie.jffi_issue.pas.generateToken

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.call.setOnClickListener {
            generateToken()
        }
    }
}