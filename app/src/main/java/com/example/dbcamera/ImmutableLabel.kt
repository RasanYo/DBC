package com.example.dbcamera

import java.lang.StringBuilder

class ImmutableLabel(
    private val name: String,
    private val isChecked: Boolean,
    private val subLabels: List<ImmutableLabel>
    ) {

    fun labelSetCheck(check: Boolean): ImmutableLabel {
        return ImmutableLabel(name, check, subLabels)
    }

    fun getSubLabels(): List<ImmutableLabel> {
        return subLabels
    }

    fun addSubLabel(label: ImmutableLabel): ImmutableLabel {
        val temp = mutableListOf<ImmutableLabel>()
        temp.addAll(subLabels)
        temp.add(label)
        return ImmutableLabel(name, isChecked, temp.toList())
    }

    fun getName(): String {
        return name
    }

    fun getCheck(): Boolean {
        return isChecked
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder(" $name: \n")
        subLabels.forEach {
            stringBuilder.append("   - ${it.toString()}")
        }
        return stringBuilder.toString()
    }


}