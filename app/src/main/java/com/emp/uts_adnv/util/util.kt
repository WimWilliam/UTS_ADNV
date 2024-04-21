package com.emp.uts_adnv.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.emp.uts_adnv.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

fun ImageView.loadImage(url: String?, progrBar: ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .error(R.drawable.baseline_error_24)
        .into(this, object: Callback {
            override fun onSuccess() {
                progrBar.visibility= View.GONE
            }

            override fun onError(e: Exception?) {
            }
        })

}