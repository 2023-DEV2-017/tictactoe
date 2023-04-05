package com.example.myapplication

import com.google.common.truth.Truth
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    //X always goes first.
    @Test
    fun `always begin playing with X`(){
        val viewModel = MainViewModel()
        Truth.assertThat(viewModel.getPlayer()).isEqualTo('X')
    }

    //Players cannot play on a played position.
    @Test
    fun `block changing value once picked`(){

    }

    //Players alternate placing X’s and O’s on the board until either:
    @Test
    fun `alternate players`(){

    }

    //One player has three in a row, horizontally, vertically or diagonally
    //If a player is able to draw three X’s or three O’s in a row, that player wins.
    @Test
    fun `check winning combinations`(){

    }

    //All nine squares are filled.
    //If all nine squares are filled and neither player has three in a row, the game is a draw.
    @Test
    fun `game over when all fields set`(){

    }

}