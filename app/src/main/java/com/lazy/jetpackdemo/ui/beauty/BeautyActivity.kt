package com.lazy.jetpackdemo.ui.beauty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.lazy.jetpackdemo.R
import com.lazy.jetpackdemo.ui.beauty.adapter.BeautyListAdapter
import com.lazy.jetpackdemo.ui.beauty.viewmode.BeautyViewMode
import kotlinx.android.synthetic.main.activity_beauty.*

class BeautyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beauty)
        val  vm by viewModels<BeautyViewMode>()
        val  adapter =BeautyListAdapter()

        vm.gankList.observe(this, Observer {
            adapter.submitList(it)
        })

        list_beauty.adapter=adapter
    }
}
