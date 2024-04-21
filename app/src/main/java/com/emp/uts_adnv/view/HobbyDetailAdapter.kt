package com.emp.uts_adnv.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emp.uts_adnv.R
import com.emp.uts_adnv.model.DetailHobby
import com.emp.uts_adnv.model.Hobys_name
import com.emp.uts_adnv.util.loadImage

class HobbyDetailAdapter (val listBaca:ArrayList<DetailHobby>):
    RecyclerView.Adapter<HobbyDetailAdapter.HobbyDetailHolder>()
{
    class HobbyDetailHolder(var view: View): RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):HobbyDetailHolder{
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.isihobby,parent,false)

        return  HobbyDetailHolder(view)
    }
    override fun getItemCount():Int{
        return  listBaca.size
    }

    override fun onBindViewHolder(holder: HobbyDetailHolder, position: Int) {
        val txtJudulHobby = holder.view.findViewById<TextView>(R.id.txtNamaHobby)
        val txtPenulisHobby = holder.view.findViewById<TextView>(R.id.txtPenulis)
        val isiCeritaHobby = holder.view.findViewById<TextView>(R.id.txtisiBerita)
        val photo = holder.view.findViewById<TextView>(R.id.imageViewDetailHobby)
        val progresBar = holder.view.findViewById<ProgressBar>(R.id.progressBarListHoby)

        txtJudulHobby.setText(listBaca[position].nama)
        txtPenulisHobby.setText(listBaca[position].penulis)
        isiCeritaHobby.setText(listBaca[position].isiHobby)
//        photo.loadImage(listBaca[position]. photo.toString(),progresBar)




    }
    fun updateHobbyList(nDetailHobbyList: ArrayList<DetailHobby>) {
        listBaca.clear()
        listBaca.addAll(nDetailHobbyList)
        notifyDataSetChanged()
    }



}