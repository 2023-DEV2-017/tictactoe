package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val uiState: MutableLiveData<UiState> = MutableLiveData(UiState())

    fun getPlayer(): Char {
        return 'O' // TODO alternate players
    }

    fun select(index: Int) = true // TODO should only allow picking same index once

    fun checkWinner(positions: List<Char>) {
        TODO("Not yet implemented")
    }

}

data class UiState(
    val positions: List<Char> = listOf(
        ' ', ' ', ' ',
        ' ', ' ', ' ',
        ' ', ' ', ' ',
    )
)