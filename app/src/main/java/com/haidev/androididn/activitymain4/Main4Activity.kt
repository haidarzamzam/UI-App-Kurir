package com.haidev.androididn.activitymain4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.haidev.androididn.R
import kotlinx.android.synthetic.main.activity_main4.*

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        btnClose.setOnClickListener {
            finish()
        }
    }
}
