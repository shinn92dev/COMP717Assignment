package com.bcit.currencyapp.api

import com.google.gson.annotations.SerializedName

data class CurrencyData(
    @SerializedName("eur") val eur: Map<String, Any>? = null,
    @SerializedName("cad") val cad: Map<String, Any>? = null,
    @SerializedName("usd") val usd: Map<String, Any>? = null,
    @SerializedName("krw") val krw: Map<String, Any>? = null,
    @SerializedName("jpy") val jpy: Map<String, Any>? = null,
)