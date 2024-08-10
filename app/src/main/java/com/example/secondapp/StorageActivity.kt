package com.example.secondapp

import android.R
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.CallLog
import android.widget.SimpleCursorAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.secondapp.databinding.ActivityStorageBinding

private const val fileName = "filenamecognizant"

private const val NAME = "name"

private const val PASSWORD = "pwd"

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
        // Create a file
        val preferences = getSharedPreferences( fileName, MODE_PRIVATE )

        // Open the file
        val editor = preferences.edit()

        // Write to the file
        editor.putString( NAME, binding.etName.text.toString() )
        editor.putString( PASSWORD, binding.etPassword.text.toString() )

        // Save the file
        editor.apply()

    }

    override fun onResume() {
        super.onResume()
        restoreData()

        val cursor: Cursor? = getContentResolver().query(
            CallLog.Calls.CONTENT_URI,
            null, null, null, CallLog.Calls.DATE + " DESC"
        )
        // val uriSms = Uri.parse("content://sms/inbox")
        //val dataCursor: Cursor? = getContentResolver().query(uriSms, null, null, null, null)
        val colName = CallLog.Calls.NUMBER

        val fromColNames = arrayOf(colName)
        val toTexviewIds = intArrayOf(android.R.id.text1)
        var cursorAdaper = SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
            cursor,fromColNames,toTexviewIds)
        binding.listView.adapter = cursorAdaper
    }

    private fun restoreData() {
        // If file exists it will open that file, else create it
        val preferences = getSharedPreferences( fileName, MODE_PRIVATE )

        // Get values
        val name = preferences.getString( NAME, "" )
        val password = preferences.getString( PASSWORD,"" )

        // Show on TextView
        binding.etName.setText(name)
        binding.etPassword.setText(password)
    }

}