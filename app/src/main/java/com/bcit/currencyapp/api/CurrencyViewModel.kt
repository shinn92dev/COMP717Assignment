package com.bcit.currencyapp.api

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CurrencyViewModel : ViewModel() {
    private val repository = CurrencyRepository()

    private val _currencyData = MutableStateFlow<CurrencyData?>(null)
    val currencyData: StateFlow<CurrencyData?> = _currencyData

    fun fetchAllCurrencyData() {
        viewModelScope.launch {
            val currencies = listOf("eur", "cad", "usd", "krw", "jpy")
            val results = currencies.map { currency ->
                async {
                    val data = repository.getCurrencyData(currency)
                    Log.d("CurrencyViewModel", "$currency: $data")
                    data
                }
            }.awaitAll()

            _currencyData.value = CurrencyData(
                eur = results.getOrNull(0),
                cad = results.getOrNull(1),
                usd = results.getOrNull(2),
                krw = results.getOrNull(3),
                jpy = results.getOrNull(4)
            )
        }
    }

}