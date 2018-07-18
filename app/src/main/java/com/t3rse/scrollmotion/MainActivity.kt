package com.t3rse.scrollmotion

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.t3rse.scrollmotion.adapter.SampleAdapter
import com.t3rse.scrollmotion.service.SampleService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val sampleService = SampleService()
    val sampleData = sampleService.getSampleData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureRecyclerData()
        attachScrollingMotion()
    }

    fun configureRecyclerData(){
        rvData.adapter = SampleAdapter(sampleData)
        rvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    fun attachScrollingMotion(){
        rvData.addOnScrollListener(object: RecyclerView.OnScrollListener(){

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val offset = rvData.computeVerticalScrollOffset()
                val extent = rvData.computeVerticalScrollExtent()
                val range = rvData.computeVerticalScrollRange()


                val percentage = ((100.0f * offset / (range - extent).toFloat())
                                        * 0.2f) // the 0.2f to tweak relationship of scrolling

                motionContainer.progress = percentage

                Log.d("SCROLLING", "Scrolled x: ${dx} y: ${dy} | ScrollY: ${percentage}")

            }

        })
    }
}
