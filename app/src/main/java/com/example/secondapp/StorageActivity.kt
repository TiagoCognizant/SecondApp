package com.example.secondapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.secondapp.databinding.ActivityStorageBinding

class StorageActivity : AppCompatActivity() {

    lateinit var binding : ActivityStorageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStorageBinding.inflate(layoutInflater)
        var view =binding.root
        setContentView(view)
    }

    override fun onPause() {
        super.onPause()
        storeData()
    }

    private fun storeData() {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        super.onResume()
        restoreData()
    }

    private fun restoreData() {
        TODO("Not yet implemented")
    }

}