package com.t3rse.scrollmotion.model

import android.databinding.ObservableField

data class SampleModel (val id: String, val sampleName: String)

class SampleModelViewModel{
    val SampleName = ObservableField<String>()

    constructor(){
        SampleName.set("Not assigned")
    }

    constructor(sampleModel: SampleModel){
        SampleName.set(sampleModel.sampleName)
    }

}
