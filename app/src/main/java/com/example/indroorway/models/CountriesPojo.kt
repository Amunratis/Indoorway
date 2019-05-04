package com.example.indroorway.models

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

class CountriesPojo() : Parcelable {
    // Getter Methods

    // Setter Methods

    var name: String? = null
    internal var topLevelDomain = ArrayList<Any>()
    var alpha2Code: String? = null
    var alpha3Code: String? = null
    internal var callingCodes = ArrayList<Any>()
    var capital: String? = null
    internal var altSpellings = ArrayList<Any>()
    var region: String? = null
    var subregion: String? = null
    var population: Float = 0.toFloat()
    internal var latlng = ArrayList<Any>()
    var demonym: String? = null
    var area: Float = 0.toFloat()
    var gini: Float = 0.toFloat()
    internal var timezones = ArrayList<Any>()
    internal var borders = ArrayList<Any>()
    var nativeName: String? = null
    var numericCode: String? = null
    internal var currencies = ArrayList<Any>()
    internal var languages = ArrayList<Any>()
    lateinit var translations: Translations
    var flag: String? = null
    internal var regionalBlocs = ArrayList<Any>()
    var cioc: String? = null

    constructor(parcel: Parcel) : this() {
        name = parcel.readString()
        alpha2Code = parcel.readString()
        alpha3Code = parcel.readString()
        capital = parcel.readString()
        region = parcel.readString()
        subregion = parcel.readString()
        population = parcel.readFloat()
        demonym = parcel.readString()
        area = parcel.readFloat()
        gini = parcel.readFloat()
        nativeName = parcel.readString()
        numericCode = parcel.readString()
        flag = parcel.readString()
        cioc = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(alpha2Code)
        parcel.writeString(alpha3Code)
        parcel.writeString(capital)
        parcel.writeString(region)
        parcel.writeString(subregion)
        parcel.writeFloat(population)
        parcel.writeString(demonym)
        parcel.writeFloat(area)
        parcel.writeFloat(gini)
        parcel.writeString(nativeName)
        parcel.writeString(numericCode)
        parcel.writeString(flag)
        parcel.writeString(cioc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CountriesPojo> {
        override fun createFromParcel(parcel: Parcel): CountriesPojo {
            return CountriesPojo(parcel)
        }

        override fun newArray(size: Int): Array<CountriesPojo?> {
            return arrayOfNulls(size)
        }
    }
}

