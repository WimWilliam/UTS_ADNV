package com.emp.uts_adnv.viewmodel

import android.accounts.Account
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.emp.uts_adnv.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProfilViewModel(application: Application):
AndroidViewModel(application)

{
    val profilLD = MutableLiveData<User>()
    val profileLoadErorLD=MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "wTag"
    private  var queue:RequestQueue?=null

    fun fetch(){
        loadingLD.value = true
        profileLoadErorLD.value = false
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://my-json-server.typicode.com/WimWilliam/RHobby/user"

        val stringRequest = StringRequest(
            Request.Method.GET,url,
            {
                val sType = object : TypeToken<User>() { }.type
                val result = Gson().fromJson<User>(it, sType)
                profilLD.value = result
                loadingLD.value = false

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                profileLoadErorLD.value = false
                loadingLD.value = false
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }


}