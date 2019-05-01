package com.example.indroorway.models

import java.util.ArrayList

class CountriesPojo {
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
}

