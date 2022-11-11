package com.kshitij.retrofit

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kshitij.retrofit.models.UsersResponse

class UsersAdapter(var list: ArrayList<UsersResponse>) :
    RecyclerView.Adapter<UsersAdapter.RecyclerViewHolder>() {


    class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvId: TextView = view.findViewById(R.id.tvId)
        var tvName: TextView = view.findViewById(R.id.tvName)
        var tvEmail: TextView = view.findViewById(R.id.tvEmail)
        var tvGender: TextView = view.findViewById(R.id.tvGender)
        var tvStatus: TextView = view.findViewById(R.id.tvStatus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.tvId.setText(list[position].id.toString())
        holder.tvName.setText(list[position].name)
        holder.tvEmail.setText(list[position].email)
        holder.tvGender.setText(list[position].gender)
        holder.tvStatus.setText(list[position].status)

    }

    override fun getItemCount(): Int {
        Log.d("UsersAdapter", "getItemCount: Adapter $list")
        return list.size
    }
}