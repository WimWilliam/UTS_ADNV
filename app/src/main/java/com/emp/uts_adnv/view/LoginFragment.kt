package com.emp.uts_adnv.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.emp.uts_adnv.R
import com.emp.uts_adnv.viewmodel.LoginViewModel
import com.emp.uts_adnv.viewmodel.SharedViewModel
import com.google.android.material.textfield.TextInputEditText



class LoginFragment : Fragment() {

    private  lateinit var  loginViewModel: LoginViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val btnRegis = view.findViewById<Button>(R.id.btnRegister)
        var txtUser =view.findViewById<TextInputEditText>(R.id.txtUsername)
        var txtPassword = view.findViewById<TextInputEditText>(R.id.txtPassword)


        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        btnLogin.setOnClickListener{


            loginViewModel.fetch(txtUser.text.toString(),txtPassword.text.toString())
            loginViewModel.userLD.observe(viewLifecycleOwner) {user ->

                if (user.isNotEmpty()){

                    val viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
                    viewModel.username = user[0].username

                    val action = LoginFragmentDirections.actionHobbyListFragment()
                    Navigation.findNavController(it).navigate(action)



                }else{
                    Toast.makeText(requireContext(), "Username atau password salah", Toast.LENGTH_SHORT).show()
                }
            }
        }
        btnRegis.setOnClickListener{
            val action=LoginFragmentDirections.actionRegisterFragement()
            Navigation.findNavController(it).navigate(action)
        }




    }


}