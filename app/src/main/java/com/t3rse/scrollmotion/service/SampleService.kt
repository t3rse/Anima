package com.t3rse.scrollmotion.service

import com.t3rse.scrollmotion.model.SampleModel

class SampleService {

    fun getSampleData(): List<SampleModel>{
        val list = ArrayList<SampleModel>()
        (0..500).map {
            list.add(
                    SampleModel(it.toString(), "Test ${it}")
            )
        }

        return list
    }

}
