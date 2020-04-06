package com.example.databindingkotlin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerview.layoutManager = linearLayoutManager

        val userAdapter = MyAdapter(prepareData())
        recyclerview.adapter = userAdapter

    }

    private fun prepareData():ArrayList<User>{

        var user1 = User("Ujjwal","Ujjwal@gmail.com","123")
        var user2 = User("Bharat","Bharat@gmail.com","456")
        var user3 = User("Aman","Aman@gmail.com","789")
        var user4 = User("Deepak","Deepak@gmail.com","098")
        var user5 = User("Anupam","Anupam@gmail.com","876")
        var user6 = User("Vipul","Vipul@gmail.com","654")
        var user7 = User("Vikas","Vikas@gmail.com","342")
        var user8 = User("Rahul","Rahul@gmail.com","975")
        var user9 = User("Divyansh","Divyansh@gmail.com","458")


        return arrayListOf<User>(user1,user2,user3,user4,user5,user6,user7,user8,user9,user1,user2,user3,user4,user5,user6,user7,user8,user9)
    }
}
