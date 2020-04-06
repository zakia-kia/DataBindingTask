package com.zakia.idn.databindingtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.zakia.idn.databindingtask.data.MainViewModel
import com.zakia.idn.databindingtask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        binding.mainBinding = mainViewModel
        binding.lifecycleOwner = this
        binding.imageFood = getDrawable(R.drawable.image)

    }
}
