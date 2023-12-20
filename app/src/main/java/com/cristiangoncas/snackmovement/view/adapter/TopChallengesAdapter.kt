package com.cristiangoncas.snackmovement.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cristiangoncas.snackmovement.R
import com.cristiangoncas.snackmovement.databinding.ViewholderTopMovementBinding
import com.cristiangoncas.snackmovement.model.models.Movement

class TopChallengesAdapter : RecyclerView.Adapter<TopChallengesAdapter.MovementsViewHolder>() {

    private var items: ArrayList<Movement> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovementsViewHolder {
        return MovementsViewHolder(ViewholderTopMovementBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MovementsViewHolder, position: Int) {
        if (position < items.size) {
            val challenge = items[position]
            holder.bind(challenge)
        }
    }

    fun updateList(movements: ArrayList<Movement>) {
        val diffCallback = ChallengesDiffCallback(this.items, movements)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.items.clear()
        this.items.addAll(movements)

        diffResult.dispatchUpdatesTo(this)
    }

    inner class MovementsViewHolder(private val binding: ViewholderTopMovementBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movement: Movement) {
            binding.name.text = movement.name
            binding.icon.setImageResource(R.mipmap.ic_launcher)
        }
    }

    inner class ChallengesDiffCallback(
        private val mOldList: ArrayList<Movement>,
        private val mNewList: ArrayList<Movement>,
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

            return oldChallenge.id == newChallenge.id && oldChallenge.name == newChallenge.name
        }
    }
}
