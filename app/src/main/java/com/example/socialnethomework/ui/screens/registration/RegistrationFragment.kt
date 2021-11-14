package com.example.socialnethomework.ui.screens.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.socialnethomework.R
import com.example.socialnethomework.databinding.FragmentRegistrationBinding
import com.example.socialnethomework.viewmodel.RegistrationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding

    private val viewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_registration, container, false
        )

        viewModel.userState.observe(viewLifecycleOwner, {
            binding.edRegEmail.setText(it.email)
            binding.edRegPassword.setText(it.password)
            binding.edName.setText(it.name)
            binding.edSurname.setText(it.password)
        })

        initListener()

       return binding.root
    }

    private fun initListener() {
        binding.btRegistration.setOnClickListener {
            if (binding.edName.text.isNullOrEmpty()) {
                binding.edName.error = "please fill in the name field"
            }
            if (binding.edSurname.text.isNullOrEmpty()) {
                binding.edSurname.error = "please fill in the surname field"
            }
            if (binding.edRegEmail.text.isNullOrEmpty()) {
                binding.edRegEmail.error = "please fill in the e-mail field"
            }
            if (binding.edRegPassword.text.isNullOrEmpty()) {
                binding.edRegPassword.error = "please fill in the password field"
            }
            else {
                viewModel.insertParam(
                    binding.edName.text.toString(),
                    binding.edSurname.text.toString(),
                    binding.edRegEmail.text.toString(),
                    binding.edRegPassword.text.toString()
                )
                view?.let { Navigation.findNavController(it).navigate(R.id.loginFragment) }
                Toast.makeText(context, "Registered", Toast.LENGTH_SHORT).show()
            }
        }
    }

}