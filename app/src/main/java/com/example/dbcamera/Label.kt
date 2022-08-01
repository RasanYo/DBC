package com.example.dbcamera

import android.util.Log
import java.lang.StringBuilder

class Label(_name: String) {

    private val name = _name
    var isChecked: Boolean = false
    private val subLabels: MutableList<Label> = mutableListOf()

    fun addSublabel(label: Label) {
        subLabels.add(label)
        Log.i("Added to '$name'", label.getName())
    }

    fun getSubLabels(): List<Label> {
        return subLabels
    }

    fun getName(): String {
        return name
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder(" $name: \n")
        subLabels.forEach {
            stringBuilder.append("   - ${it.toString()}")
        }
        return stringBuilder.toString()
    }

}