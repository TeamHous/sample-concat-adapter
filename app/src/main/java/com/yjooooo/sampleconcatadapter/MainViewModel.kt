package com.yjooooo.sampleconcatadapter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val reds: List<Color> = listOf(Color("red 1"), Color("red 2"), Color("red 3"))
    private val blues: List<Color> = listOf(Color("blue 1"), Color("blue 2"), Color("blue 3"))
    private val yellows: List<Color> =
        listOf(Color("yellow 1"), Color("yellow 2"), Color("yellow 3"))

    private val _redList = MutableLiveData<List<Color>>()
    val redList: LiveData<List<Color>> = _redList

    private val _blueList = MutableLiveData<List<Color>>()
    val blueList: LiveData<List<Color>> = _blueList

    private val _yellowList = MutableLiveData<List<Color>>()
    val yellowList: LiveData<List<Color>> = _yellowList

    fun initRedList() {
        _redList.value = reds
    }

    fun initBlueList() {
        _blueList.value = blues
    }

    fun initYellowList() {
        _yellowList.value = yellows
    }
}
