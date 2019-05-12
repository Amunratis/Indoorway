package com.example.indroorway.models


import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



data class Translations(
        val it: String,
        val br: String,
        val de: String,
        val es: String,
        val fa: String,
        val fr: String,
        val hr: String,
        val ja: String,
        val nl: String,
        val pt: String
):  Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(it)
        parcel.writeString(br)
        parcel.writeString(de)
        parcel.writeString(es)
        parcel.writeString(fa)
        parcel.writeString(fr)
        parcel.writeString(hr)
        parcel.writeString(ja)
        parcel.writeString(nl)
        parcel.writeString(pt)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Translations> {
        override fun createFromParcel(parcel: Parcel): Translations {
            return Translations(parcel)
        }

        override fun newArray(size: Int): Array<Translations?> {
            return arrayOfNulls(size)
        }
    }
}