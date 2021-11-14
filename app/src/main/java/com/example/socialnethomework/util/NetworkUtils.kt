package com.example.socialnethomework.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class NetworkUtils : ConnectivityManager.NetworkCallback() {

    private val networkLiveData = MutableLiveData<Boolean>()

    fun getNetworkLiveData(context: Context): LiveData<Boolean> {
        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            manager.registerDefaultNetworkCallback(this)
        } else {
            val builder = NetworkRequest.Builder()
            manager.registerNetworkCallback(builder.build(), this)
        }

        var isConnected = false

        for (allNetwork in manager.allNetworks) {
            val capabilities = manager.getNetworkCapabilities(allNetwork)
            if (capabilities != null) {
                if (capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) {
                    isConnected = true
                    break
                }
            }
        }
        networkLiveData.postValue(isConnected)
        return networkLiveData
    }

    override fun onAvailable(@NonNull network: Network) {
        networkLiveData.postValue(true)
    }

    override fun onLost(@NonNull network: Network) {
        networkLiveData.postValue(false)
    }

}