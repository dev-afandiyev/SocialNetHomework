package com.example.socialnethomework.ui.screens.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.socialnethomework.R
import com.example.socialnethomework.databinding.FragmentLoginBinding
import com.example.socialnethomework.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )

        initListener()

        return binding.root
    }

    private fun initListener() {
        binding.btLogin.setOnClickListener {
            if (binding.edEmail.text.isNullOrEmpty()) {
                binding.edEmail.error = "please fill in the email field"
            }
            if (binding.edPassword.text.isNullOrEmpty()){
                binding.edPassword.error = "please fill in the password field"
            }
            if (viewModel.getByLogin(binding.edEmail.text.toString(), binding.edPassword.text.toString()) != null){
                view?.let { Navigation.findNavController(it).navigate(R.id.profileFragment2) }
            }
        }
        binding.btRegistration.setOnClickListener {
            view?.let { Navigation.findNavController(it).navigate(R.id.registrationFragment2) }
        }
    }


}