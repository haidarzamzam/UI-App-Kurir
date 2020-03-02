package com.haidev.androididn.main3

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.haidev.androididn.R
import com.haidev.androididn.main4.Main4Activity
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.layout_bottomsheet.view.*

class Main3Activity : AppCompatActivity() {

    companion object {
        const val EXTRA_MAIN = "extra_main"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main3)


        close.setOnClickListener {
            finish()
        }

        Glide.with(this)
            .load("https://media.suara.com/pictures/480x260/2019/07/27/10492-ilustrasi-box-paket-amazon-pixabayjosemiguels.jpg")
            .apply(RequestOptions.bitmapTransform(RoundedCorners(12)))
            .into(ivGambar)

        btnDone.setOnClickListener {
            val view = layoutInflater.inflate(R.layout.layout_bottomsheet, null)
            val dialog = BottomSheetDialog(this)
            view.close.setOnClickListener {
                dialog.dismiss()
            }
            view.btnDone.setOnClickListener {
                val intent = Intent(this, Main4Activity::class.java)
                startActivity(intent)
                dialog.dismiss()
            }
            dialog.setContentView(view)
            dialog.show()
        }
    }
}
