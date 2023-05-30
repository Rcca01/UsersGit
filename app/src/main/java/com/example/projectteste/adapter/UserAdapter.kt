package com.example.projectteste.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectteste.databinding.ItemUserBinding
import com.example.projectteste.models.User

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var userList = mutableListOf<User>()

    @SuppressLint("NotifyDataSetChanged")
    fun setUsers(players: List<User>) {
        this.userList = players.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemBinding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val userItem: User = userList[position]
        Glide.with(holder.itemView.context).load(userItem.avatar_url).into(holder.itemAvatar)
        holder.itemId.text = userItem.id.toString()
        holder.itemName.text = userItem.login
    }

    override fun getItemCount(): Int = userList.size

    class UserViewHolder(private val itemBinding: ItemUserBinding): RecyclerView.ViewHolder(itemBinding.root) {
        val itemAvatar:ImageView = itemBinding.imageView
        val itemId:TextView = itemBinding.tvIdUser
        val itemName:TextView = itemBinding.tvNameUser
    }
}