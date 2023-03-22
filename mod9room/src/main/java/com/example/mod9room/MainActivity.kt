package com.example.mod9room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.mod9room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewModel by viewModels<PatisserieViewModel>{PatisserieViewModel.Factory}
    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Interpréter le XML
        //Transforme en DataBinding
        //Affiche la vue
        //Affecter à l'activité cette vue
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        //J'affiche à l'écran activityMainBinding.root
        activityMainBinding.vm = viewModel
        //J'enregistre mon binding comme observer des liveData (ici patisserie qui est utilisé
        // sur tout mon dataBinding)
        activityMainBinding.lifecycleOwner =this
    }
}