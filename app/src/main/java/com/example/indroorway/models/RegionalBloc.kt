package com.example.indroorway.models

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue


data class RegionalBloc(
        val acronym: String?,
        val name: String?,
        val otherAcronyms: @RawValue List<String>?,
        val otherNames: List<String>?
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.createStringArrayList(),
            source.createStringArrayList()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(acronym)
        writeString(name)
        writeStringList(otherAcronyms)
        writeStringList(otherNames)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<RegionalBloc> = object : Parcelable.Creator<RegionalBloc> {
            override fun createFromParcel(source: Parcel): RegionalBloc = RegionalBloc(source)
            override fun newArray(size: Int): Array<RegionalBloc?> = arrayOfNulls(size)
        }
    }
}
