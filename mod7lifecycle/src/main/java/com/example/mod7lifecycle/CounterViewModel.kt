package com.example.mod7lifecycle

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel(){
    //permet d'avertir l'UI que la donnée a changée
    var counter = MutableLiveData<Int>(0)

    fun increment() {
        //On incrémente la valeur du compteur et on l'affecte à la variable counter
        counter.value = counter.value?.inc()
    }
}