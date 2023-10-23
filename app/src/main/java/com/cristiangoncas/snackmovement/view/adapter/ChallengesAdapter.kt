package com.cristiangoncas.snackmovement.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cristiangoncas.snackmovement.R
import com.cristiangoncas.snackmovement.databinding.ViewholderChallengeItemBinding
import com.cristiangoncas.snackmovement.model.ChallengeItem

class ChallengesAdapter : RecyclerView.Adapter<ChallengesAdapter.ChallengeItemViewHolder>() {

    private var items: ArrayList<ChallengeItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeItemViewHolder {
        return ChallengeItemViewHolder(
            ViewholderChallengeItemBinding.inflate(
                LayoutInflater.from(
                    parent.context,
                ),
            ),
        )
    }

    override fun onBindViewHolder(holder: ChallengeItemViewHolder, position: Int) {
        if (position < items.size) {
            holder.bind(items[position])
        }
    }

    override fun getItemCount() = items.size

    fun updateList(challenges: List<ChallengeItem>) {
        val diffCallback = ChallengeItemDiffCallback(this.items, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.items.clear()
        this.items.addAll(challenges)

        diffResult.dispatchUpdatesTo(this)
    }

    inner class ChallengeItemViewHolder(private val binding: ViewholderChallengeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(challenge: ChallengeItem) {
            binding.label.text = challenge.label
            binding.image.setImageResource(R.mipmap.ic_launcher)
        }
    }

    inner class ChallengeItemDiffCallback(
        private val mOldList: ArrayList<ChallengeItem>,
        private val mNewList: ArrayList<ChallengeItem>,
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

            return oldChallenge.id == newChallenge.id &&
                oldChallenge.label == newChallenge.label &&
                oldChallenge.difficulty == newChallenge.difficulty
        }
    }
}
