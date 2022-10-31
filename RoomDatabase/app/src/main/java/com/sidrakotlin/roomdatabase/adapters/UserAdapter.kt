package com.sidrakotlin.roomdatabase.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sidrakotlin.roomdatabase.R
import com.sidrakotlin.roomdatabase.models.User

class UserAdapter(private val userList:List<User>, private val context: Context) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view:View = LayoutInflater.from(context).inflate(R.layout.user_item,parent,false)
        val holderObj = MyViewHolder(view)
        return holderObj
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val users = userList[position]
        holder.name.text= users.name
        holder.email.text = users.email

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var name:TextView = itemView.findViewById(R.id.userName)
        var email:TextView = itemView.findViewById(R.id.userEmail)
        var delete:ImageView = itemView.findViewById(R.id.deleteUser)
        var edit:ImageView = itemView.findViewById(R.id.editUser)
    }
}