package com.example.mod8tpdice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiceViewModel : ViewModel() {
    var valueDice = MutableLiveData(1)
    fun launchDice(sides : Int){
        valueDice.value = (1..sides).random()
    }
}