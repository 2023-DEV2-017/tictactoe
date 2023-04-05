package com.example.myapplication

import com.google.common.truth.Truth
import com.google.common.truth.Truth.*
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(JUnitParamsRunner::class)
class ExampleUnitTest {

    //X always goes first.
    @Test
    fun `always begin playing with X`(){
        val viewModel = MainViewModel()
        assertThat(viewModel.getPlayer()).isEqualTo('X')
        assertThat(viewModel.getPlayer()).isEqualTo('O')
    }

    //Players cannot play on a played position.
    @Test
    @Parameters(method = "paramsCheckBlocked")
    fun `block changing value once picked`(data: List<Char>, position: Int, expected: Boolean){
        val viewModel = MainViewModel()
        assertThat(viewModel.positionIsBlocked(data, position)).isEqualTo(expected)
    }

    //Players alternate placing X’s and O’s on the board until either:
    @Test
    fun `alternate players`(){
        val viewModel = MainViewModel()
        assertThat(viewModel.getPlayer()).isEqualTo('X')
        assertThat(viewModel.getPlayer()).isEqualTo('O')
    }

    //One player has three in a row, horizontally, vertically or diagonally
    //If a player is able to draw three X’s or three O’s in a row, that player wins.
    @Test
    @Parameters(method = "checkWinningParams")
    fun `check winning combinations`(input: List<Char>, expected: Char){
        val viewModel = MainViewModel()
        assertThat(viewModel.checkWinner(input)).isEqualTo(expected)
    }

    //All nine squares are filled.
    //If all nine squares are filled and neither player has three in a row, the game is a draw.
    @Test
    fun `game over when all fields set`(){
        val viewModel = MainViewModel()
        assertThat(viewModel.checkWinner(listOf(
            'X', 'O', 'O',
            'O', ' ', 'O',
            'O', 'O', 'X',
        ))).isEqualTo(EMPTY)
        assertThat(viewModel.checkWinner(listOf(
            'X', 'X', 'O',
            'O', 'X', 'X',
            'X', 'O', '0',
        ))).isEqualTo(GAME_OVER)
    }

    private fun paramsCheckBlocked() = listOf(
        arrayOf(listOf(
            'X', 'O', 'O',
            'O', 'X', 'O',
            'O', 'O', 'X',
        ), 0, true),
        arrayOf(listOf(
            'X', 'X', 'O',
            ' ', ' ', ' ',
            ' ', ' ', ' ',
        ), 2, true),
        arrayOf(listOf(
            ' ', ' ', ' ',
            'O', 'X', ' ',
            'O', 'O', ' ',
        ), 1, false),
    )

    private fun checkWinningParams() = listOf(
        arrayOf(listOf(
            'X', 'O', 'O',
            'O', 'X', 'O',
            'O', 'O', 'X',
        ), 'X'),
        arrayOf(listOf(
            'X', 'X', 'X',
            'O', 'X', 'O',
            'X', 'O', 'O',
        ), 'X'),
        arrayOf(listOf(
            'X', 'O', 'O',
            'X', 'X', 'X',
            'O', 'X', 'O',
        ), 'X'),
        arrayOf(listOf(
            'X', 'X', 'O',
            'O', 'X', 'X',
            'O', 'X', 'O',
        ), 'X'),
        arrayOf(listOf(
            'O', 'O', 'O',
            'O', 'X', 'O',
            'O', 'O', 'X',
        ), 'O'),
        arrayOf(listOf(
            'X', 'O', 'X',
            'O', 'O', 'X',
            'X', 'O', 'O',
        ), 'O'),
        arrayOf(listOf(
            'O', 'X', 'O',
            'X', 'O', 'X',
            'O', 'X', 'O',
        ), 'O'),
        arrayOf(listOf(
            'X', 'X', 'O',
            'O', 'O', 'X',
            'O', 'O', 'O',
        ), 'O'),
    )

}