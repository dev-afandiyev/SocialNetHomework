package com.example.socialnethomework.ui.screens.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.socialnethomework.R
import com.example.socialnethomework.databinding.FragmentProfileBinding
import com.example.socialnethomework.ui.screens.profile.adapter.ProfileAdapter
import com.example.socialnethomework.util.ApiState
import com.example.socialnethomework.viewmodel.ProfileViewModel
 import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private val viewModel: ProfileViewModel by viewModels()
    private lateinit var profileAdapter: ProfileAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_profile, container, false
        )

        viewModel.getAllItem()?.observe(viewLifecycleOwner, {
            if (it != null) {
                binding.tvName.text = it.name
                binding.tvSurname.text = it.surname
            }
        })

        initAdapter()

        viewModel.getNews()
        lifecycleScope.launchWhenStarted {
            viewModel._newsStateFlow.collect {
                when(it) {
                    is ApiState.Loading -> { }
                    is ApiState.Success -> {
                        profileAdapter.loadServices(it.data)
                    }
                    is ApiState.Failure -> { }
                    is ApiState.Empty -> { }
                }
            }
        }

        return binding.root
    }

    private fun initAdapter(){
        profileAdapter = ProfileAdapter()
        binding.rvNews.layoutManager = LinearLayoutManager(this.context)
        binding.rvNews.adapter = profileAdapter
    }

}

