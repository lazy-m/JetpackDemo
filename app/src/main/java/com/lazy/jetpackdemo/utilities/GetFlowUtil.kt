package com.lazy.jetpackdemo.utilities

import android.content.Context
import android.content.pm.PackageManager
import android.net.TrafficStats
import android.text.TextUtils
import android.util.Log
import com.lazy.jetpackdemo.base.FlowInfo

    fun appFlowInfo(pakageName:String, context:Context):FlowInfo{
        //获取到配置权限信息的应用程序
        val pms =context.packageManager
        val packinfos =pms.getInstalledPackages(PackageManager.GET_PERMISSIONS)
        //存放具有Internet权限信息的应用
        val  flowInfo = FlowInfo()
        for (i in packinfos.indices){
            val  appName  =packinfos[i].packageName
            if (!TextUtils.isEmpty(appName)) {
                if (appName.equals(pakageName)){
                    //用于封装具有Internet权限的应用程序信息
                    flowInfo.Appname =packinfos[i].applicationInfo.loadLabel(pms).toString()
                    //获取到应用的uid（user id）
                    val  uid = packinfos[i].applicationInfo.uid
                    //TrafficStats对象通过应用的uid来获取应用的下载、上传流量信息
                    //发送的 上传的流量byte
                    flowInfo.UpKb = TrafficStats.getUidRxBytes(uid).toInt()
                    //下载的流量 byte
                    flowInfo.DownKb =TrafficStats.getUidTxBytes(uid).toInt()
                    Log.e("flowInfo","${TrafficStats.getUidTxBytes(uid)/1024}KB")
                }
            }
        }
        return flowInfo
    }
