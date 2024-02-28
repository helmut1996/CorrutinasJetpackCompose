package com.example.corrutinasapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {
 var resultState by mutableStateOf("")
     private set

    var loading by mutableStateOf(false)
        private set

    fun fetchData(){
        viewModelScope.launch {
            try {
                loading = true
                llamarApi()
            }catch (e:Exception){
                println("Error ${e.message}")
            } finally {
                loading = false
            }
        }

    }

    private suspend fun llamarApi(){
        val result = withContext(Dispatchers.IO){
            delay(5000)
            "Respuesta de la API!!!!"
        }
        resultState = result
    }

    fun bloqueoApp(){
        Thread.sleep(5000)
        resultState = "Respuesta de la API"
    }
}