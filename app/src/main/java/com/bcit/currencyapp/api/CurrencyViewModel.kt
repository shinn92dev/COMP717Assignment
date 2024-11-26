package com.bcit.currencyapp.api

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CurrencyViewModel : ViewModel() {
    private val repository = CurrencyRepository()

    private val _currencyData = MutableStateFlow<CurrencyData?>(null)
    val currencyData: StateFlow<CurrencyData?> = _currencyData

    fun fetchCurrencyData(currency: String) {
        viewModelScope.launch {
            val data = repository.getCurrencyData(currency)
            _currencyData.value = data

            if (data != null) {
                Log.d("com.bcit.currencyapp.api.CurrencyViewModel", "Fetched Data successfully")
            } else {
                Log.e("com.bcit.currencyapp.api.CurrencyViewModel", "Failed to fetch data")
            }
        }
    }
}
