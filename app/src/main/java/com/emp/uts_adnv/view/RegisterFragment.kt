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
import com.google.android.material.textfield.TextInputEditText



class RegisterFragment : Fragment() {
    private  lateinit var  loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDaftar=view.findViewById<Button>(R.id.btnDaftar)
        val btnSudahPnyAkun=view.findViewById<Button>(R.id.btnSudahPunyaAkun)
        val txtName=view.findViewById<TextInputEditText>(R.id.txtRegName)
        val txtEmail=view.findViewById<TextInputEditText>(R.id.txtRegEmail)
        val txtPhoneNum=view.findViewById<TextInputEditText>(R.id.txtRegPhone)
        val txtPassword=view.findViewById<TextInputEditText>(R.id.txtRegPas)
        val txtRePass=view.findViewById<TextInputEditText>(R.id.txtReRegPas)

        btnDaftar.setOnClickListener{
            loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
            if (txtPassword.text.toString() == txtRePass.text.toString()){
                loginViewModel.fetch2(txtName.text.toString())

                loginViewModel.userLD.observe(viewLifecycleOwner) { user ->
                    if (user.isNotEmpty()) {
                        Toast.makeText(requireContext(), "Username sudah terpakai", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        val action=RegisterFragmentDirections.actionLoginFragment()
                        Navigation.findNavController(it).navigate(action)
                    }
                }
            }
            else{
                Toast.makeText(requireContext(), "Password berbeda", Toast.LENGTH_SHORT).show()
            }
        }

        btnSudahPnyAkun.setOnClickListener {
            val action=RegisterFragmentDirections.actionLoginFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }


}