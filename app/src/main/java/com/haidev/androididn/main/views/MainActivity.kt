package com.haidev.androididn.main.views

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.haidev.androididn.R
import com.haidev.androididn.main.adapters.ItemMainAdapter
import com.haidev.androididn.main.models.MainModel
import com.haidev.androididn.main2.views.Main2Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<MainModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        tabRiwayat.setOnClickListener {
            tabRiwayat.setBackgroundResource(R.drawable.bg_tab)
            tabHariIni.setBackgroundResource(0)
            tabHariBesok.setBackgroundResource(0)
        }

        tabHariIni.setOnClickListener {
            tabHariIni.setBackgroundResource(R.drawable.bg_tab)
            tabRiwayat.setBackgroundResource(0)
            tabHariBesok.setBackgroundResource(0)
        }

        tabHariBesok.setOnClickListener {
            tabHariBesok.setBackgroundResource(R.drawable.bg_tab)
            tabHariIni.setBackgroundResource(0)
            tabRiwayat.setBackgroundResource(0)
        }
        rvList.setHasFixedSize(true)
        list.addAll(getListMain())
        showRecyclerList()

        btnSend.setOnClickListener {
            val intent = Intent(this, Main2Activity::class.java)
            startActivity(intent)
        }
    }

    private fun showRecyclerList() {
        rvList.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ItemMainAdapter(list)
        rvList.adapter = listHeroAdapter
    }

    private fun getListMain(): ArrayList<MainModel> {
        val dataNum = resources.getStringArray(R.array.data_num)
        val dataName = resources.getStringArray(R.array.data_name)
        val dataReceipt = resources.getStringArray(R.array.data_receipt)
        val dataAddress = resources.getStringArray(R.array.data_address)
        val dataImage = resources.getStringArray(R.array.data_image)
        val listMain = ArrayList<MainModel>()
        for (position in dataName.indices) {
            val hero = MainModel(
                dataNum[position],
                dataName[position],
                dataReceipt[position],
                dataAddress[position],
                dataImage[position]
            )
            listMain.add(hero)
        }
        return listMain
    }

}
