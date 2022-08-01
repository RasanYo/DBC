package com.example.dbcamera

import android.util.Log
import junit.framework.TestCase
import org.junit.Test

class LabelTest : TestCase() {

    companion object{
        fun initTestLabels(size: Int): MutableList<Label> {
            val labels = mutableListOf<Label>()
            for (i in 0..size) {
                labels.add(Label("TEST_LABEL_$i"))
            }
            return labels
        }
    }



    @Test
    fun toStringTest() {
        val testLabels = initTestLabels(2)
        testLabels.forEach { label ->
            val subLabels = initTestLabels(2)
            subLabels.forEach{
                label.addLabel(it)
            }
        }
    }

}