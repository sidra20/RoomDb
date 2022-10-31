package com.sidrakotlin.roomdatabase.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sidrakotlin.roomdatabase.R
import com.sidrakotlin.roomdatabase.adapters.UserAdapter
import com.sidrakotlin.roomdatabase.database.MyDb
import com.sidrakotlin.roomdatabase.models.User

class UserActivity:AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var email:EditText
    private lateinit var submit:Button
    private lateinit var userRv:RecyclerView
    private lateinit var db:MyDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_users)

        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        submit = findViewById(R.id.submit)
        userRv = findViewById(R.id.userRv)


        userRv.layoutManager = LinearLayoutManager(this);
        submit.setOnClickListener {
            addData()
        }

        loadData()
        //init()

    }



    private fun addData()
    {
        var userName:String = name.text.toString()
        var userEmail:String = email.text.toString()
        if(userName.isEmpty() || userEmail.isEmpty())
        {
            Toast.makeText(this, "Field is required!", Toast.LENGTH_SHORT).show()

        }
        else{


            var user = User(0,userName,userEmail)
            db = MyDb.getDb(this)
            db.userDao().insertData(user)
            Toast.makeText(this, "Data is added!", Toast.LENGTH_SHORT).show()


        }
        loadData()
    }

    private fun loadData()
    {
        var userList: List<User>? = db.userDao().getAllUsers()
        if(userList==null)
        {
            Toast.makeText(this, "Empty!",Toast.LENGTH_SHORT).show()
            return
        }
        val userAdapter:UserAdapter=UserAdapter(userList!!,this)
        userRv.adapter=userAdapter


    }
}