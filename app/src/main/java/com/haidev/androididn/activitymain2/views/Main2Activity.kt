package com.haidev.androididn.activitymain2.views

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.haidev.androididn.R
import com.haidev.androididn.activitymain.models.MainModel
import com.haidev.androididn.activitymain2.adapters.ItemMain2Adapter
import com.haidev.androididn.activitymain3.Main3Activity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    private val list = ArrayList<MainModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main2)

        rvList2.setHasFixedSize(true)
        list.addAll(getListMain())
        showRecyclerList()

        close.setOnClickListener {
            finish()
        }
    }

    private fun showRecyclerList() {
        rvList2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listHeroAdapter = ItemMain2Adapter(list)
        rvList2.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ItemMain2Adapter.OnItemClickCallback {
            override fun onItemClicked(data: MainModel) {
                showSelectedHero(data)
            }
        })
    }

    private fun showSelectedHero(hero: MainModel) {
        val intent = Intent(this, Main3Activity::class.java)
        intent.putExtra(Main3Activity.EXTRA_MAIN, hero)
        startActivity(intent)
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
