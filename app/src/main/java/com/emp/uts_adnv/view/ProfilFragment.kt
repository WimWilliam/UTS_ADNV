package com.emp.uts_adnv.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import com.emp.uts_adnv.R
import com.emp.uts_adnv.util.loadImage
import com.emp.uts_adnv.viewmodel.LoginViewModel
import com.emp.uts_adnv.viewmodel.SharedViewModel
import com.google.android.material.textfield.TextInputEditText


class ProfilFragment : Fragment() {

    private lateinit var profileviewModel: LoginViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        profileviewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        profileviewModel.fetch2(viewModel.username.toString())

        profileviewModel.userLD.observe(viewLifecycleOwner) { user ->
            val txtNama=view.findViewById<TextInputEditText>(R.id.txtName)
            val txtEmail=view.findViewById<TextInputEditText>(R.id.txtEmail)
            val txtPhoneNum=view.findViewById<TextInputEditText>(R.id.txtPhone)
            var imageView = view.findViewById<ImageView>(R.id.imageViewMenu)
            var progressBar = view.findViewById<ProgressBar>(R.id.progressBar)

            txtNama.setText(user[0].username)
            txtEmail.setText(user[0].email)
            txtPhoneNum.setText(user[0].nohp)
            imageView.loadImage(user[0].foto, progressBar)
        }

    }


}