package com.codingblocks.kotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row.view.*

class KtAdapter(private val userList: ArrayList<AdapterUser>) : RecyclerView.Adapter<KtAdapter.KtHolder>() {

    inner class KtHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(container: ViewGroup, viewType: Int): KtAdapter.KtHolder {
        val layoutInflater = LayoutInflater.from(container.context)
        val view = layoutInflater.inflate(R.layout.item_row, container, false)
        return KtHolder(view)
    }

    override fun getItemCount() = userList.size

    override fun onBindViewHolder(holder: KtAdapter.KtHolder, position: Int) {
        val currentUser = userList[position]
        with(holder.itemView) {
            tvAddress.text = currentUser.address
            tvCourse.text = currentUser.course
            tvDescription.text = currentUser.description
            tvName.text = currentUser.name
        }
    }
}