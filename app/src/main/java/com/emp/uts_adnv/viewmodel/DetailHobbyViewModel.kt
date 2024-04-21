package com.emp.uts_adnv.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.emp.uts_adnv.model.DetailHobby
import com.google.gson.Gson

class DetailHobbyViewModel (application: Application):AndroidViewModel(application){

    val detailLD = MutableLiveData<ArrayList<DetailHobby>>()



    val TAG ="wTAG"
    private var queue:RequestQueue? = null

    fun refresh(namaHobby:String){
        queue=Volley.newRequestQueue(getApplication())
        val url = "https://my-json-server.typicode.com/WimWilliam/RHobby/BacaHobby?nama=$namaHobby"


        val stringRequest = StringRequest(Request.Method.GET,url,{
                val result=Gson().fromJson<ArrayList<DetailHobby>>(it, DetailHobby::class.java)
                Log.d( "showvoley",result.toString())
                detailLD.value = result


                Log.d("showvoley",result.toString())

            },
            {
                Log.d("showvoley", it.toString())
            }
        )
        stringRequest.tag =TAG
        queue?.add(stringRequest)
    }




}