package com.cristiangoncas.snackmovement.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cristiangoncas.snackmovement.R
import com.cristiangoncas.snackmovement.databinding.ViewholderMovementItemBinding
import com.cristiangoncas.snackmovement.model.models.Movement

class MovementsAdapter(
    private val onMovementSelectedListener: (Movement) -> Unit,
) :
    RecyclerView.Adapter<MovementsAdapter.MovementItemViewHolder>() {

    private var items: ArrayList<Movement> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovementItemViewHolder {
        return MovementItemViewHolder(
            ViewholderMovementItemBinding.inflate(
                LayoutInflater.from(
                    parent.context,
                ),
            ),
            onMovementSelectedListener,
        )
    }

    override fun onBindViewHolder(holder: MovementItemViewHolder, position: Int) {
        if (position < items.size) {
            holder.bind(items[position])
        }
    }

    override fun getItemCount() = items.size

    fun updateList(movements: List<Movement>) {
        val diffCallback = ChallengeItemDiffCallback(this.items, movements as ArrayList<Movement>)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.items.clear()
        this.items.addAll(movements)

        diffResult.dispatchUpdatesTo(this)
    }

    inner class MovementItemViewHolder(
        private val binding: ViewholderMovementItemBinding,
        private val onMovementSelectedListener: (Movement) -> Unit,
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movement: Movement) {
            binding.root.setOnClickListener {
                onMovementSelectedListener(movement)
            }
            binding.label.text = movement.name
            binding.image.setImageResource(R.mipmap.ic_launcher)
        }
    }

    inner class ChallengeItemDiffCallback(
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

            return oldChallenge.id == newChallenge.id &&
                oldChallenge.name == newChallenge.name &&
                oldChallenge.difficulty == newChallenge.difficulty
        }
    }

    interface OnMovementSelectedListener {
        fun onMovementSelected(movement: Movement)
    }
}
