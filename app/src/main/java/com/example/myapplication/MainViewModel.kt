package com.example.myapplication

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {



    fun getPlayer(): Char {
        return 'O' // TODO alternate players
    }

    fun select(index: Int) = true // should only allow picking same index once

}