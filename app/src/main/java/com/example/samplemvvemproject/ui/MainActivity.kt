package com.example.samplemvvemproject.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.samplemvvemproject.R
import com.example.samplemvvemproject.base.BaseActivity
import com.example.samplemvvemproject.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate){

    private val navController by lazy {
        Navigation.findNavController(this, R.id.nav_host_fragment)
    }

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

}

}