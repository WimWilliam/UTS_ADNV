package com.emp.uts_adnv.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.emp.uts_adnv.R
import com.emp.uts_adnv.databinding.FragmentHobbyDetailBinding
import com.emp.uts_adnv.viewmodel.DetailHobbyViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class HobbyDetailFragment : Fragment() {

    private lateinit var  detailHobbyViewModel: DetailHobbyViewModel
    private lateinit var  binding: FragmentHobbyDetailBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hobby_detail, container, false)
    }

//    fun observeViewModel() {
//        detailHobbyViewModel.detailLD.observe(viewLifecycleOwner, Observer {
//            var dHobby = it
//            binding.btnNext?.setOnClickListener {
//
//            }
//        })
//
//    }


}