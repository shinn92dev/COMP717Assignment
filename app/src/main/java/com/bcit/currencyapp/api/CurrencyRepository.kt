package com.bcit.currencyapp.api
import android.util.Log
import io.ktor.client.call.*
import io.ktor.client.request.*

class CurrencyRepository {
    private val client = HttpClientInstance.client
    private val baseUrl = "https://latest.currency-api.pages.dev"

    suspend fun getCurrencyData(currency: String): CurrencyData? {
        Log.d("URL", "$baseUrl/v1/currencies/$currency.json")
        return try {
            client.get("$baseUrl/v1/currencies/$currency.json").body()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
