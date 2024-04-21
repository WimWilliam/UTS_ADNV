package com.emp.uts_adnv.view

import android.os.Bundle
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
import com.emp.uts_adnv.databinding.FragmentHobbyListBinding
import com.emp.uts_adnv.viewmodel.HobbyListViewModel


class HobbyListFragment : Fragment() {

    private  lateinit var  viewModel: HobbyListViewModel
    private  val hobbyListAdapter = HobbyListAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hobby_list, container, false)
    }

    fun observeViewModel(){

        viewModel.hobbysLD.observe(viewLifecycleOwner, Observer {
            hobbyListAdapter.updateHobbyList(it)
        })
        viewModel.hobbysLoadErrorLD.observe(viewLifecycleOwner,Observer{
            val txtError = view?.findViewById<TextView>(R.id.txtError)
            if(it == true){
                txtError?.visibility = View.VISIBLE
            }else{
                txtError?.visibility = View.GONE
            }

        })
        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            val recView = view?.findViewById<RecyclerView>(R.id.recView)
            val progressLoad = view?.findViewById<ProgressBar>(R.id.progressBar2)
            if(it == true) {
                recView?.visibility = View.GONE
                progressLoad?.visibility = View.VISIBLE
            } else {
                recView?.visibility = View.VISIBLE
                progressLoad?.visibility = View.GONE
            }
        })

    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            viewModel = ViewModelProvider(this).get(HobbyListViewModel::class.java)
            viewModel.refresh()

            val recView = view.findViewById<RecyclerView>(R.id.recView)
            recView.layoutManager = LinearLayoutManager(context)
            recView.adapter = hobbyListAdapter

            val refreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
            val txtEror = view.findViewById<TextView>(R.id.txtError)
            val proggresBar = view.findViewById<ProgressBar>(R.id.progressBar2)

            refreshLayout.setOnRefreshListener {
                recView.visibility = View.GONE
                txtEror.visibility = View.GONE
                proggresBar.visibility = View.VISIBLE
                viewModel.refresh()
                refreshLayout.isRefreshing = false
            }
        observeViewModel()


    }


}