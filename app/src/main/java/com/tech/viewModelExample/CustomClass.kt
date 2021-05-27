package com.tech.viewModelExample

import android.os.Parcel
import android.os.Parcelable

class CustomClass() : Parcelable {


    var data : String? = "Abcd";

    constructor(parcel: Parcel) : this() {
        data = parcel.readString()
    }



    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(data)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CustomClass> {
        override fun createFromParcel(parcel: Parcel): CustomClass {
            return CustomClass(parcel)
        }

        override fun newArray(size: Int): Array<CustomClass?> {
            return arrayOfNulls(size)
        }
    }
}