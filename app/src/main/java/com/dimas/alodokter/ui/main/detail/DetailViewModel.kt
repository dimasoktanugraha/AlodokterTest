package com.dimas.alodokter.ui.main.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dimas.alodokter.core.data.ImageRepository
import com.dimas.alodokter.core.model.FoodHome

class DetailViewModel(private val imageRepository: ImageRepository): ViewModel() {

    fun getListDetail(index: Int) : LiveData<List<String>> = imageRepository.getListDetail(index)
}