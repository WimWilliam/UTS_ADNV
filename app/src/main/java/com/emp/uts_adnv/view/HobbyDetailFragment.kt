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
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.emp.uts_adnv.R
import com.emp.uts_adnv.databinding.FragmentHobbyDetailBinding
import com.emp.uts_adnv.viewmodel.DetailHobbyViewModel
import com.emp.uts_adnv.viewmodel.HobbyListViewModel
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailHobbyViewModel::class.java)
        viewModel.refresh(it)

        val recView = view.findViewById<RecyclerView>(R.id.recView)
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = hobbyDetailAdapter

        val refreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        val txtEror = view.findViewById<TextView>(R.id.txtError)
        val proggresBar = view.findViewById<ProgressBar>(R.id.progressBar2)

        refreshLayout.setOnRefreshListener {
            recView.visibility = View.GONE
            txtEror.visibility = View.GONE
            proggresBar.visibility = View.VISIBLE
            viewModel.refresh(it)
            refreshLayout.isRefreshing = false
        }
        observeViewModel()


    }
    fun observeViewModel(){

        viewModel.detailLD.observe(viewLifecycleOwner, Observer {
            hobbyDetailAdapter.updateHobbyDetail(it)
        })


    }

}