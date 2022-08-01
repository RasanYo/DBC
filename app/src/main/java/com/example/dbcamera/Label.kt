package com.example.dbcamera

class Label(_name: String) {

    private val name = _name
    var isChecked: Boolean = false
    private val subLabels: MutableList<Label> = mutableListOf()

    fun addLabel(label: Label) {
        subLabels.add(label)
    }

    fun getSubLabels(): List<Label> {
        return subLabels
    }

    fun getName(): String {
        return name
    }

}