package com.emp.uts_adnv.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.emp.uts_adnv.R
import com.emp.uts_adnv.databinding.FragmentHobbyDetailBinding
import com.emp.uts_adnv.viewmodel.DetailHobbyViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit


class HobbyDetailFragment : Fragment() {

    private lateinit var  viewModel: DetailHobbyViewModel
    private  val hobbyDetailAdapter = HobbyDetailAdapter(arrayListOf())




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hobby_detail, container, false)
    }

    fun observeViewModel(){

        viewModel.detailLD.observe(viewLifecycleOwner, Observer {
            hobbyDetailAdapter.updateHobbyDetail(it)
        })


    }

}