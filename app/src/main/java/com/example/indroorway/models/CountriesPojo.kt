package com.example.indroorway.models
import android.os.Parcel
import android.os.Parcelable


data class CountriesPojo(
        val alpha2Code: String?,
        val alpha3Code: String?,
        val altSpellings: List<String>?,
        val area: Double,
        val borders: List<String>?,
        val callingCodes: List<String>?,
        val capital: String?,
        val cioc: String?,
        val currencies: List<Currency>?,
        val demonym: String?,
        val flag: String?,
        val gini: String?,
        val languages: List<Language>?,
        val latlng: List<Double>,
        val name: String?,
        val nativeName: String?,
        val numericCode: String?,
        val population: Int,
        val region: String?,
        val regionalBlocs: ArrayList<RegionalBloc>?,
        val subregion: String?,
        val timezones: List<String>?,
        val topLevelDomain: List<String>?,
        val translations: Translations?
) : Parcelable {

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.createStringArrayList(),
            source.readDouble(),
            source.createStringArrayList(),
            source.createStringArrayList(),
            source.readString(),
            source.readString(),
            source.createTypedArrayList(Currency.CREATOR),
            source.readString(),
            source.readString(),
            source.readString(),
            source.createTypedArrayList(Language.CREATOR),
            ArrayList<Double>().apply { source.readList(this, Double::class.java.classLoader) },
            source.readString(),
            source.readString(),
            source.readString(),
            source.readInt(),
            source.readString(),
            source.createTypedArrayList(RegionalBloc.CREATOR),
            source.readString(),
            source.createStringArrayList(),
            source.createStringArrayList(),
            source.readParcelable<Translations>(Translations::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(alpha2Code)
        writeString(alpha3Code)
        writeStringList(altSpellings)
        writeDouble(area)
        writeStringList(borders)
        writeStringList(callingCodes)
        writeString(capital)
        writeString(cioc)
        writeTypedList(currencies)
        writeString(demonym)
        writeString(flag)
        writeString(gini)
        writeTypedList(languages)
        writeList(latlng)
        writeString(name)
        writeString(nativeName)
        writeString(numericCode)
        writeInt(population)
        writeString(region)
        writeTypedList(regionalBlocs)
        writeString(subregion)
        writeStringList(timezones)
        writeStringList(topLevelDomain)
        writeParcelable(translations, 0)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CountriesPojo> = object : Parcelable.Creator<CountriesPojo> {
            override fun createFromParcel(source: Parcel): CountriesPojo = CountriesPojo(source)
            override fun newArray(size: Int): Array<CountriesPojo?> = arrayOfNulls(size)
        }
    }
}
