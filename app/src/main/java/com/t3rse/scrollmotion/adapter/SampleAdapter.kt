package com.t3rse.scrollmotion.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.t3rse.scrollmotion.R
import com.t3rse.scrollmotion.databinding.SampleItemViewBinding
import com.t3rse.scrollmotion.model.SampleModel
import com.t3rse.scrollmotion.model.SampleModelViewModel
import timber.log.Timber


class SampleAdapter (private val sampleData: List<SampleModel>) : RecyclerView.Adapter<SampleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate(
                layoutInflater, R.layout.sample_item_view, parent, false) as SampleItemViewBinding
        return ViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return sampleData.size
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Timber.d("Binding: " + sampleData.get(position).sampleName)
        with(holder.binding!!){
            sample = SampleModelViewModel(sampleData.get(position))
            executePendingBindings()
        }

    }

    class ViewHolder(itemLayoutView: View): RecyclerView.ViewHolder(itemLayoutView){
        var binding = DataBindingUtil.getBinding<SampleItemViewBinding>(itemLayoutView)
    }


}
