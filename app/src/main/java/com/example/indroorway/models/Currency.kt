package com.example.indroorway.models

import android.os.Parcel
import android.os.Parcelable

data class Currency(
        val code: String,

        val name: String,
        val symbol: String
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(code)
        writeString(name)
        writeString(symbol)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Currency> = object : Parcelable.Creator<Currency> {
            override fun createFromParcel(source: Parcel): Currency = Currency(source)
            override fun newArray(size: Int): Array<Currency?> = arrayOfNulls(size)
        }
    }
}