package com.example.dbcamera

import junit.framework.TestCase
import org.junit.Test

class RecyclerAdapterTest : TestCase() {




    @Test
    fun addingSublabelToSublabelWorks(){
        val labels = LabelTest.initTestLabels(2)
        val dummyLabel = Label("SUB_LABEL")
        dummyLabel.isChecked = true
        labels[0].addLabel(dummyLabel)
        labels[0].isChecked = true
        labels[1].isChecked = true


        val adapter = RecyclerAdapter(labels)
        adapter.addSubLabel(Label("SUB_SUB_LABEL"))

        println(adapter.labelsToString())
    }
}