package com.demo.dokong.kotlincoroutinestest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.demo.dokong.kotlincoroutinestest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainBinding = DataBindingUtil.inflate<ActivityMainBinding>(
            layoutInflater,
            com.demo.dokong.kotlincoroutinestest.R.layout.activity_main,
            null,
            false
        )
        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        setContentView(mainBinding.root)
        mainBinding.vm = mainViewModel
    }
}
