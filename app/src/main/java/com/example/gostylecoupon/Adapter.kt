package com.example.gostylecoupon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.cardview.widget.CardView
import com.example.gostylecoupon.User
import com.example.gostylecoupon.R

class UsersRecyclerAdapter(private val listUsers: List) : RecyclerView.Adapter() {
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        // inflating recycler item view
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user_recycler, parent, false)
        return UserViewHolder(itemView)
    }
    fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.textViewName.text = listUsers[position].name
        holder.textViewEmail.text = listUsers[position].email
        holder.textViewPassword.text = listUsers[position].password
    }
    fun getItemCount(): Int {
        return listUsers.size
    }
    /**
     * ViewHolder class
     */
    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewName: CardView
        var textViewEmail: CardView
        var textViewPassword: CardView
        init {
            textViewName = view.findViewById(R.id.textViewName) as CardView
            textViewEmail = view.findViewById(R.id.textViewEmail) as CardView
            textViewPassword = view.findViewById(R.id.textViewPassword) as CardView
        }
    }
}