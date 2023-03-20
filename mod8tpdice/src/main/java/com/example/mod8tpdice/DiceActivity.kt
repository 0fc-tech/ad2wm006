package com.example.mod8tpdice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.mod8tpdice.databinding.ActivityDiceBinding

class DiceActivity : AppCompatActivity() {
    val viewModel by viewModels<DiceViewModel>()
    lateinit var adb : ActivityDiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adb = DataBindingUtil.setContentView(this, R.layout.activity_dice)
        adb.lifecycleOwner = this
        adb.vm = viewModel
        adb.button6.setOnClickListener { viewModel.launchDice(6) }
        adb.button8.setOnClickListener { viewModel.launchDice(8) }
        adb.button12.setOnClickListener { viewModel.launchDice(12) }
        adb.button20.setOnClickListener { viewModel.launchDice(20) }

    }
}