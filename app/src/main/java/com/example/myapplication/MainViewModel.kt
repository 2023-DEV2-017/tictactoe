package com.example.myapplication

import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var player1: Char? = null
    private var player2: Char? = null
    private var activePlayer: Char = X
    private var winner: Char = EMPTY

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

    // TODO implement reset option

    fun select(index: Int) : Boolean {
        val changed = uiState.value?.positions?.toMutableList()
        // block changing and already set field
        if (positionIsBlocked(changed, index))
            return false
        // check for game over
        if (gameIsOver())
            return false
        // update active player
        activePlayer = getPlayer() ?: X
        // update character
        changed?.set(index, activePlayer)
        uiState.postValue(uiState.value?.copy(
            positions = changed.orEmpty(),
            player = activePlayer,
        ))
        // check winner
        winner = checkWinner(changed.orEmpty())
        if( gameIsOver() ){
            // show winner
            uiState.postValue(uiState.value?.copy(
                positions = changed.orEmpty(),
                player = activePlayer,
                winner = winner)
            )
        }
        // logging
        Log.d(TAG, "${changed?.subList(0,3)}")
        Log.d(TAG, "${changed?.subList(3,6)}")
        Log.d(TAG, "${changed?.subList(6,9)}")
        Log.d(TAG, "winner is $winner")
        return true
    }

    @VisibleForTesting
    fun positionIsBlocked(changed: List<Char>?, index: Int) = changed?.get(index) != EMPTY

    fun checkWinner(p: List<Char>): Char {
        return when {
            // horizontal
            p[0] == p[1] && p[1] == p[2] -> p[0]
            p[3] == p[4] && p[3] == p[5] -> p[3]
            p[6] == p[7] && p[6] == p[8] -> p[6]
            // vertical
            p[0] == p[3] && p[0] == p[6] -> p[0]
            p[1] == p[4] && p[1] == p[7] -> p[1]
            p[2] == p[5] && p[2] == p[8] -> p[2]
            // diagonal
            p[0] == p[4] && p[0] == p[8] -> p[0]
            p[2] == p[4] && p[2] == p[6] -> p[2]
            !p.any { it == EMPTY } -> GAME_OVER // when all is set
            else -> EMPTY // no winner, still playing
        }
    }

    @VisibleForTesting
    fun gameIsOver() = winner != EMPTY // when all is set or winner found

    companion object {
        const val TAG = "tictactoe"
    }

}

const val EMPTY = ' '
const val X = 'X'
const val O = 'O'
const val GAME_OVER = 'Y'

data class UiState(
    val positions: List<Char> = listOf(
        EMPTY, EMPTY, EMPTY,
        EMPTY, EMPTY, EMPTY,
        EMPTY, EMPTY, EMPTY,
    ),
    val player: Char = EMPTY,
    val winner: Char = EMPTY,
)