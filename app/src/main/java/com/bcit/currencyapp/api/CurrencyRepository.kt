package com.bcit.currencyapp.api
import android.util.Log
import io.ktor.client.call.*
import io.ktor.client.request.*

class CurrencyRepository {
    private val client = HttpClientInstance.client
    private val baseUrl = "https://latest.currency-api.pages.dev/v1/currencies"

    suspend fun getCurrencyData(currency: String): Map<String, Any>? {
        return try {
            val response: Map<String, Any> = client.get("$baseUrl/$currency.json").body()
            Log.d("CurrencyRepository", "Fetched data for $currency: $response")
            response
        } catch (e: Exception) {
            Log.e("CurrencyRepository", "Failed to fetch data for $currency", e)
            null
        }
    }
}