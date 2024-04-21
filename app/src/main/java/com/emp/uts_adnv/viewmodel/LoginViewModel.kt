package com.emp.uts_adnv.viewmodel

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
import java.net.MalformedURLException

class LoginViewModel (application: Application): AndroidViewModel(application){
    val userLD= MutableLiveData<List<User>>()
    val TAG = "wTag"
    private var queue: RequestQueue? = null

    fun fetch(username:String, password:String) {

        queue= Volley.newRequestQueue(getApplication())
        val url="https://my-json-server.typicode.com/WimWilliam/RHobby/user?username=$username&password=$password"

        val stringRequest= StringRequest(
            Request.Method.GET, url,{

                val result= Gson().fromJson<ArrayList<User>>(it, object : TypeToken<ArrayList<User>>(){}.type)
                userLD.value=result

                Log.d("showvoley", result.toString())
                Log.d("showvoley", username)
                Log.d("showvoley", password)
            },
            {
                try {
                    throw it
                } catch (e: MalformedURLException){
                    Log.e("showvoley", "Invalid URL: $url", e)
                } catch (e: Exception){
                    Log.d("showvoley", e.toString())
                }
            }
        )

        stringRequest.tag=TAG
        queue?.add(stringRequest)
    }

    fun fetch2(username:String) {

        queue= Volley.newRequestQueue(getApplication())
        val url="https://my-json-server.typicode.com/WimWilliam/RHobby/user?username$username"


        val stringRequest= StringRequest(
            Request.Method.GET, url,{
                val result= Gson().fromJson<ArrayList<User>>(it, object : TypeToken<ArrayList<User>>(){}.type)
                userLD.value=result

                Log.d("showvoley", result.toString())
                Log.d("showvoley", username)
            },
            {
                try {
                    throw it
                } catch (e: MalformedURLException){
                    Log.e("showvoley", "Invalid URL: $url", e)
                } catch (e: Exception){
                    Log.d("showvoley", e.toString())
                }
            }
        )

        stringRequest.tag=TAG
        queue?.add(stringRequest)
    }
}