package com.example.viewmodelactivitykotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ViewModel : ViewModel() {
    private val ColorValue = MutableLiveData<Int>()

    fun setcolor(color : Int){
        ColorValue.value = color

    }

    fun getcolor(): LiveData<Int>? {
        return ColorValue
    }
}