package com.cristiangoncas.snackmovement.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.cristiangoncas.snackmovement.databinding.ViewholderGroupsBinding
import com.cristiangoncas.snackmovement.model.Group

class GroupsAdapter : RecyclerView.Adapter<GroupsAdapter.GroupsViewHolder>() {

    private var items: ArrayList<Group> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupsViewHolder {
        return GroupsViewHolder(ViewholderGroupsBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: GroupsViewHolder, position: Int) {
        if (position <= items.size) {
            val group = items[position]
            holder.bind(group)
        }
    }

    fun updateList(groups: ArrayList<Group>) {
        val diffCallback = GroupsDiffCallback(this.items, groups)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.items.clear()
        this.items.addAll(groups)

        diffResult.dispatchUpdatesTo(this)
    }

    inner class GroupsViewHolder(private val binding: ViewholderGroupsBinding) :
        ViewHolder(binding.root) {

        fun bind(group: Group) {
            binding.name.text = group.name
        }
    }

    inner class GroupsDiffCallback(
        private val mOldList: ArrayList<Group>,
        private val mNewList: ArrayList<Group>,
    ) : DiffUtil.Callback() {

        override fun getOldListSize() = mOldList.size

        override fun getNewListSize() = mNewList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            // add a unique ID property on Contact and expose a getId() method
            return mOldList[oldItemPosition].id == mNewList[newItemPosition].id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldContact = mOldList[oldItemPosition]
            val newContact = mNewList[newItemPosition]

            return oldContact.id == newContact.id && oldContact.name == newContact.name
        }
    }
}
