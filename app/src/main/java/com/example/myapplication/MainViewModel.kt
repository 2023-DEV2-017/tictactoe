package com.example.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val uiState: MutableLiveData<UiState> = MutableLiveData(UiState())

    fun getPlayer(): Char {
        return 'O' // TODO alternate players
    }

    fun select(index: Int) : Boolean {
        Log.d(TAG, "${uiState.value?.positions}")
        // TODO should only allow picking same index once
        return true
    }

    fun checkWinner(positions: List<Char>) {
        TODO("Not yet implemented")
    }

    companion object {
        const val TAG = "tictactoe"
    }

}

data class UiState(
    val positions: List<Char> = listOf(
        ' ', ' ', ' ',
        ' ', ' ', ' ',
        ' ', ' ', ' ',
    )
)