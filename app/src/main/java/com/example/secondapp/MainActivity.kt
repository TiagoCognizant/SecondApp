package com.example.secondapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var data = arrayOf(
        "india","english","android","computers",
        "india","english","android","computers",
        "india","english","android","computers",
        "india","english","android","computers",
        "india","english","android","computers",
        "india","english","android","computers",
        "india","english","android","computers",
        "india","english","android","computers",
        "india","english","android","computers",
        "india","english","android","computers",
        "india","english","android","computers",
        "india","english","android","computers",
        "india","english","android","computers",
        "india","english","android","computers",
        "india","english","android","computers",
        "india","english","android","computers",)
    lateinit var recyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview = findViewById(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)

        var dataAdaper = DataAdaper(data)
        recyclerview.adapter = dataAdaper
    }




}