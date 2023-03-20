package com.example.mod7lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.mod7lifecycle.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    //private var counter = 0
    val viewModel : CounterViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    //private val textViewCounter by lazy {findViewById<TextView>(R.id.textViewCounter)}
    //private val fabCounter by lazy {findViewById<FloatingActionButton>(R.id.fabCounter)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        Log.i(TAG, "onCreate: ")
        binding.vm = viewModel
        //textViewCounter.text = viewModel.counter.toString()
        binding.lifecycleOwner = this
        binding.fabCounter.setOnClickListener {
            viewModel.increment()
            //binding.textViewCounter.text = viewModel.increment().toString()
        }
    }

    //override fun onSaveInstanceState(outState: Bundle) {
    //    super.onSaveInstanceState(outState)
    //    outState.putInt("counter",counter)
    //}
//
    //override fun onRestoreInstanceState(savedInstanceState: Bundle) {
    //    super.onRestoreInstanceState(savedInstanceState)
    //    counter = savedInstanceState.getInt("counter")
    //    textViewCounter.text = counter.toString()
    //}

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: ")
    }
}