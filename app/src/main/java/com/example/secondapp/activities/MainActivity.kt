package com.example.secondapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.secondapp.R

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