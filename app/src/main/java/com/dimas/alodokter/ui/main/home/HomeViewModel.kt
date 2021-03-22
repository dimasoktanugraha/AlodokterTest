package com.dimas.alodokter.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dimas.alodokter.core.data.ImageRepository
import com.dimas.alodokter.core.model.FoodHome

class HomeViewModel(private val imageRepository: ImageRepository): ViewModel() {

    fun getListImage() : LiveData<List<FoodHome>> = imageRepository.getListImage()

}