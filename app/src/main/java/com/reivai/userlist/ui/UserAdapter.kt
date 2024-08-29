package com.reivai.userlist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reivai.userlist.databinding.ItemUserBinding
import com.reivai.userlist.model.User
import java.text.SimpleDateFormat
import java.util.Locale

class UserAdapter(private val onClick: (User) -> Unit) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var users = listOf<User>()

    fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user, onClick)
    }

    override fun getItemCount(): Int = users.size

    class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(users: User, onClick: (User) -> Unit) {
            binding.name.text = users.name

            val dateFormat = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
            val dateOfBirth = dateFormat.format(SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault()).parse(users.createdAt))
            val birth = dateOfBirth.replace("-", " ")
            binding.birth.text = birth

            Glide.with(binding.avatar.context)
                .load(users.avatar)
                .into(binding.avatar)

            binding.root.setOnClickListener {
                onClick(users)
            }
        }

    }
}