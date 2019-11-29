package com.lazy.jetpackdemo.bean

import android.os.Parcel
import android.os.Parcelable
import com.lazy.jetpackdemo.base.BaseDean

data class Text(val name:String):BaseDean(), Parcelable {

    constructor(parcel: Parcel):this(parcel.readString()){
        id=parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Text> {
        override fun createFromParcel(parcel: Parcel): Text {
            return Text(parcel)
        }

        override fun newArray(size: Int): Array<Text?> {
            return arrayOfNulls(size)
        }
    }

}