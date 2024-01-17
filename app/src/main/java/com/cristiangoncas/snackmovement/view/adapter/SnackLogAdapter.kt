package com.cristiangoncas.snackmovement.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cristiangoncas.snackmovement.R
import com.cristiangoncas.snackmovement.databinding.ViewholderSnackLogBinding
import com.cristiangoncas.snackmovement.model.models.SnackLog

class SnackLogAdapter : RecyclerView.Adapter<SnackLogAdapter.SnackLogViewHolder>() {

    private var items: ArrayList<SnackLog> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnackLogViewHolder {
        return SnackLogViewHolder(ViewholderSnackLogBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: SnackLogViewHolder, position: Int) {
        if (position < items.size) {
            val challenge = items[position]
            holder.bind(challenge)
        }
    }

    fun updateList(snackLogs: ArrayList<SnackLog>) {
        val diffCallback = SnackLogsDiffCallback(this.items, snackLogs)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.items.clear()
        this.items.addAll(snackLogs)

        diffResult.dispatchUpdatesTo(this)
    }

    inner class SnackLogViewHolder(private val binding: ViewholderSnackLogBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movement: SnackLog) {
            binding.name.text = movement.snackName
            binding.icon.setImageResource(R.mipmap.ic_launcher)
        }
    }

    inner class SnackLogsDiffCallback(
        private val mOldList: ArrayList<SnackLog>,
        private val mNewList: ArrayList<SnackLog>,
    ) : DiffUtil.Callback() {

        override fun getOldListSize() = mOldList.size

        override fun getNewListSize() = mNewList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            // Add a unique ID property on Challenge and expose a getId() method
            return mOldList[oldItemPosition].id == mNewList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldChallenge = mOldList[oldItemPosition]
            val newChallenge = mNewList[newItemPosition]

            return oldChallenge.id == newChallenge.id && oldChallenge.snackName == newChallenge.snackName
        }
    }
}
