package com.example.myapplication

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {



    fun getPlayer(): Char {
        return 'O' // TODO alternate players
    }

}