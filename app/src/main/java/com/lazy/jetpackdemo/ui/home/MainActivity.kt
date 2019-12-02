package com.lazy.jetpackdemo.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.lazy.jetpackdemo.R
import com.lazy.jetpackdemo.bean.Text
import com.lazy.jetpackdemo.ui.beauty.BeautyActivity
import com.lazy.jetpackdemo.ui.home.adapter.HomeListAdapter
import com.lazy.jetpackdemo.ui.pagingShow.SongListActivity
import com.lazy.jetpackdemo.ui.pagingShow.viewmode.SongViewMode
import com.lazy.jetpackdemo.utilities.Injection
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    private var isLine: Boolean = false
    private val viewMode:SongViewMode by viewModels ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter =HomeListAdapter()
        viewMode.allhome.observe(this, Observer {
            adapter.submitList(it)
        })
        rv_home.adapter =adapter
        bt_variety.setOnClickListener {
            rv_home.layoutManager = if (isLine) GridLayoutManager(this,2) else LinearLayoutManager(this)
            isLine = !isLine
        }
        for (i in 1..6){
            var text =Text("好看${i}")
        }
    }
}
