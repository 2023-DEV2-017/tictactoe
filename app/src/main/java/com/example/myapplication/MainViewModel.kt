package com.example.myapplication

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var player1: Char? = null
    private var player2: Char? = null
    private var activePlayer: Char = X

    val uiState: MutableLiveData<UiState> = MutableLiveData(UiState())

    fun getPlayer() = when {
        player1 == null -> {
            player1 = X // first player always X
            player1
        }
        player2 == null -> {
            player2 = O // second player always O
            player2
        }
        activePlayer == player1 -> player2 // alternate players
        else -> player1
    }

    fun select(index: Int) : Boolean {
        val changed = uiState.value?.positions?.toMutableList()
        Log.d(TAG, "${changed?.subList(0,3)}")
        Log.d(TAG, "${changed?.subList(3,6)}")
        Log.d(TAG, "${changed?.subList(6,9)}")
        // update active player
        activePlayer = getPlayer() ?: X
        // update character
        changed?.set(index, activePlayer)
        uiState.postValue(uiState.value?.copy(positions = changed.orEmpty()))
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

const val EMPTY = ' '
const val X = 'X'
const val O = 'O'

data class UiState(
    val positions: List<Char> = listOf(
        EMPTY, EMPTY, EMPTY,
        EMPTY, EMPTY, EMPTY,
        EMPTY, EMPTY, EMPTY,
    )
)