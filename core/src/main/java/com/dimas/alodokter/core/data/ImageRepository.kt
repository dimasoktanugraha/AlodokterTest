package com.dimas.alodokter.core.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dimas.alodokter.core.model.FoodHome

class ImageRepository(private val dataImage: DataImage) {

    fun getListImage() : LiveData<List<FoodHome>> {
        val listFood = MutableLiveData<List<FoodHome>>()
        listFood.value = dataImage.getListImage()
        return listFood
    }

    fun getListDetail(index: Int) : LiveData<List<String>>{
        val listDetail = MutableLiveData<List<String>>()
        listDetail.value = dataImage.getListDetail(index)
        return listDetail
    }
}