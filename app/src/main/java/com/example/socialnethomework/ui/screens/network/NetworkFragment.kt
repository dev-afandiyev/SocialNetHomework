package com.example.socialnethomework.ui.screens.network

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.socialnethomework.R
import com.example.socialnethomework.databinding.FragmentNetworkBinding
import com.example.socialnethomework.util.NetworkUtils

class NetworkFragment : Fragment() {

    private lateinit var binding: FragmentNetworkBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_network, container, false
        )

        val utils = NetworkUtils()
        utils.getNetworkLiveData(requireContext()).observe(viewLifecycleOwner) { connected ->
            if (connected) {
                    binding.connectionLayout.visibility = View.GONE
                    binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.buttonView.setOnClickListener {
                    Toast.makeText(context, "You do not have an internet connection", Toast.LENGTH_SHORT).show();
                }
            }
        }

        return binding.root
    }

}