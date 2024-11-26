package com.bcit.currencyapp.api

import com.google.gson.annotations.SerializedName

data class CurrencyData(
    @SerializedName("eur") val eur: Map<String, Any>
)
