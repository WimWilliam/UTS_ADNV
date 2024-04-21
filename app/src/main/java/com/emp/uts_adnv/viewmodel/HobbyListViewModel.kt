package com.emp.uts_adnv.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.emp.uts_adnv.model.Hobys_name
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HobbyListViewModel(application: Application):AndroidViewModel(application) {

    val hobbysLD = MutableLiveData<ArrayList<Hobys_name>>()
    val hobbysLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()


    val TAG ="volleyTag"
    private  var queue:RequestQueue?= null

    fun  refresh(){
        loadingLD.value = true
        hobbysLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "https://my-json-server.typicode.com/WimWilliam/RHobby/Hobby"

        val stringRequest = StringRequest(
            Request.Method.GET, url,{
                val sType =object  : TypeToken<ArrayList<Hobys_name>>(){}.type
                val result = Gson().fromJson<ArrayList<Hobys_name>>(it,sType)
                hobbysLD.value=result
                loadingLD.value = false

                Log.d("SHWvoley", result.toString())
                Log.d("ShwVol",hobbysLD.value.toString())
            },
            {
                Log.d("showvoley", it.toString())
                hobbysLoadErrorLD.value = true
                loadingLD.value = false
            }
        )
        stringRequest.tag =TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

}