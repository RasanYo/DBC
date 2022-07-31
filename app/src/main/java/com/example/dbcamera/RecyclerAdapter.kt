package com.example.dbcamera

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.io.FileOutputStream

class RecyclerAdapter(
    private val labels: MutableList<Label>,
    private val folderName: String = "My DB",
    private val folderPath: String = "/storage/emulated/0/Pictures/"
): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var itemTitle: TextView = itemView.findViewById(R.id.tvLabelTitle)
        var itemCheck: CheckBox = itemView.findViewById(R.id.cbSelected)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.label, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val currentLabel = labels[position]
        holder.itemTitle.text = currentLabel.getName()
        holder.itemCheck.isChecked = currentLabel.isChecked
    }

    override fun getItemCount(): Int {
        return labels.size
    }

    fun addLabel(label: Label) {
        labels.add(label)
        notifyItemInserted(labels.size - 1)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun deleteCheckedLabels() {
        labels.removeAll {
            it.isChecked
        }
        notifyDataSetChanged()
    }


    fun createFolders() {
        val mainDir = File("$folderPath/$folderName")
        if (!mainDir.exists()) mainDir.mkdirs()

        labels.forEach {
            val labelDir = File("$mainDir/${it.getName()}")
            if(!labelDir.exists()) labelDir.mkdirs()
        }
    }
}