package com.example.samplemvvemproject.ui.home

import androidx.lifecycle.*
import com.example.samplemvvemproject.ui.home.model.ProductResponse
import com.example.samplemvvemproject.Backend.StateApi
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepo: HomeRepo)  : ViewModel() {

   private val _products:MutableLiveData<StateApi<ProductResponse>> = MutableLiveData()
   val  products : LiveData<StateApi<ProductResponse>> = _products

    fun fetchProducts(){
        if(_products.value == null){
            viewModelScope.launch {
                homeRepo.getProducts().collect { values ->
                    _products.value = values
                }
            }
        }
    }
    
}