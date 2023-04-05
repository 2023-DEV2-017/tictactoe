package com.example.myapplication

import android.util.Log
import androidx.annotation.VisibleForTesting
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
        // block changing and already set field
        if (positionIsBlocked(changed, index))
            return false
        // update active player
        activePlayer = getPlayer() ?: X
        // update character
        changed?.set(index, activePlayer)
        uiState.postValue(uiState.value?.copy(positions = changed.orEmpty()))
        // logging
        Log.d(TAG, "${changed?.subList(0,3)}")
        Log.d(TAG, "${changed?.subList(3,6)}")
        Log.d(TAG, "${changed?.subList(6,9)}")
        return true
    }

    @VisibleForTesting
    fun positionIsBlocked(changed: List<Char>?, index: Int) = changed?.get(index) != EMPTY

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