package com.emp.uts_adnv.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.emp.uts_adnv.R
import com.emp.uts_adnv.model.Hobys_name
import com.emp.uts_adnv.util.loadImage

class HobbyListAdapter (val hobbyList:ArrayList<Hobys_name>):
        RecyclerView.Adapter<HobbyListAdapter.HobbyViewHolder>(){


    class HobbyViewHolder(var view:View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.hoby_list_item,parent,false)

        return  HobbyViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("size",hobbyList.toString())
        return  hobbyList.size
    }

    override fun onBindViewHolder(holder: HobbyViewHolder, position: Int) {
        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
        val imageView = holder.view.findViewById<ImageView>(R.id.imageView)
        val txtNama = holder.view.findViewById<TextView>(R.id.txtNamaHobby)
        val txtDesc = holder.view.findViewById<TextView>(R.id.txtDesc)
        val progresBar = holder.view.findViewById<ProgressBar>(R.id.progressBarListHoby)

        txtNama.setText(hobbyList[position].nama)
        txtDesc.setText(hobbyList[position].deskripsi)
        imageView.loadImage(hobbyList[position].logo.toString(), progresBar )


        btnDetail.setOnClickListener {

            val action=HobbyListFragmentDirections.actionDetailHobbyFragment()
            Navigation.findNavController(it).navigate(action)

        }
    }
    fun updateHobbyList(nHobbyList: ArrayList<Hobys_name>) {
        hobbyList.clear()
        hobbyList.addAll(nHobbyList)
        notifyDataSetChanged()
    }

}