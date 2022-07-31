package com.example.dbcamera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var rvLabels : RecyclerView
    lateinit var etLabelName : EditText
    lateinit var btnAddLabel: Button
    lateinit var btnFinishLabels: Button

    lateinit var labelAdapter: RecyclerAdapter



    var labels: MutableList<Label> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvLabels = findViewById(R.id.rvLabels)
        etLabelName = findViewById(R.id.etLabelName)
        btnAddLabel = findViewById(R.id.btnAddLabel)
        btnFinishLabels = findViewById(R.id.btnFinishLabels)

        rvLabels.layoutManager = LinearLayoutManager(this)
        labelAdapter = RecyclerAdapter(labels)
        rvLabels.adapter = labelAdapter

        btnAddLabel.setOnClickListener {
            val labelName = etLabelName.text.toString()
            etLabelName.setText("")
            if (labelName.isNotEmpty()) {
                val label = Label(labelName)
                labelAdapter.addLabel(label)
                Log.i("New Label", labelName)
            }
        }


        btnFinishLabels.setOnClickListener {
            /**
            val intent = Intent(this, MainActivity(labels)::class.java)
            startActivity(intent)
            **/
            labelAdapter.createFolders()
        }


    }
}