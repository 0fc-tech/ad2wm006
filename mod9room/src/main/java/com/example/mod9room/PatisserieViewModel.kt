package com.example.mod9room

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.mod9room.bo.Patisserie
import com.example.mod9room.dao.PatisserieDao
import kotlinx.coroutines.launch

//Ici en cas concret on aurait un Repo (permet d'avoir plusieurs srcs de données)
class PatisserieViewModel(val patisserieDao: PatisserieDao) : ViewModel() {
    val patisserie = MutableLiveData<Patisserie>()
    //Lors de la création du View Model, je lance la récupération
    // de ma patisserie depuis la Dao BDD
    init {
        fetchPatisserie()
    }

    fun fetchPatisserie(){
        //Permet d'éxécuter les requêtes SQL de la base de données
        // dans un autre thread. Ici C'est la coroutine viewModel
        viewModelScope.launch{
            patisserie.value = patisserieDao.getPatisserie(1L)
        }
    }
    companion object{
        val Factory : ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                return PatisserieViewModel(
                    PatisserieDB.getInstance(checkNotNull( extras[APPLICATION_KEY]))
                        .patisserieDao()
                ) as T
            }
        }
    }

}