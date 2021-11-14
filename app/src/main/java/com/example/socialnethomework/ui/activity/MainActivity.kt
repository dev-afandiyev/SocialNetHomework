package com.example.socialnethomework.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.example.socialnethomework.R
import com.example.socialnethomework.util.NetworkUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val utils = NetworkUtils()
        utils.getNetworkLiveData(this).observe(this) { connection ->
            if (connection) {
                this.let { it1 -> Navigation.findNavController(it1, R.id.fragmentContainerView2).popBackStack(R.id.networkFragment, true) }
                this.let { Navigation.findNavController(it, R.id.fragmentContainerView2).navigate(R.id.loginFragment) }
            } else {
                this.let { Navigation.findNavController(it, R.id.fragmentContainerView2).navigate(R.id.networkFragment) }
            }
        }
    }

}