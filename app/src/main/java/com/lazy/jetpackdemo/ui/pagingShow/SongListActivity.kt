package com.lazy.jetpackdemo.ui.pagingShow

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.lazy.jetpackdemo.R
import com.lazy.jetpackdemo.base.FlowInfo
import com.lazy.jetpackdemo.databinding.ActivitySongListBinding
import com.lazy.jetpackdemo.ui.pagingShow.adapter.SongListAdapter
import com.lazy.jetpackdemo.ui.pagingShow.viewmode.SongViewMode
import com.lazy.jetpackdemo.utilities.appFlowInfo

class SongListActivity : AppCompatActivity() {
   private  val vu by viewModels<SongViewMode>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  bin: ActivitySongListBinding = DataBindingUtil.setContentView(this,R.layout.activity_song_list)
        val  adapter =SongListAdapter()
        vu.allSong.observe(this, Observer { adapter.submitList(it) })
        bin.cheeseList.adapter = adapter
        appFlowInfo(packageName,this)
        val flo = FlowInfo()
    }

    @SuppressLint("WrongConstant")
    fun  getUid(){
      val  ai= packageManager.getApplicationInfo(packageName,PackageManager.GET_ACTIVITIES)
        ai.uid

    }
}
