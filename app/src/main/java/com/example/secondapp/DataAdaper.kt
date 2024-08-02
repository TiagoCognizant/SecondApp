package com.example.secondapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

//dataadapter putting the data into the row card
class DataAdaper(var data: Array<String>) : RecyclerView.Adapter<DataAdaper.DataViewHolder>() {
var TAG = DataAdaper::class.java.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        Log.i(TAG,"george bought a row card-- gave it to armando")
        var rowPlank = LayoutInflater.from(parent.context).inflate(R.layout.row_card,parent,false)
        return DataViewHolder(rowPlank)    }

    override fun getItemCount(): Int {
        Log.i(TAG,"catarin is counting --"+ data.size)
        return  data.size

    }


    override fun onBindViewHolder(armandoholder: DataViewHolder, position: Int) {
        Log.i(TAG,"da silva is writing --"+ data[position])

        armandoholder.tvRowItem.setText(data[position])
    }

    class  DataViewHolder(rowPlank: View) :ViewHolder(rowPlank){
        init {
            Log.i("DataAdapter","armando is trying to find the textview on the row - george")
        }
        var tvRowItem = itemView.findViewById<TextView>(R.id.tv_row_card)

    }
}