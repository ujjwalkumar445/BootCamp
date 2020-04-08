package com.example.viewmodelactivitykotlin

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ViewModel
    private var myRandomColor : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)

        viewModel.getcolor()!!.observe(this, Observer<Int> { integer ->
            findViewById<View>(R.id.layout_view).setBackgroundColor(
                Color.parseColor(
                    "#$integer"
                )
            )
        })

        findViewById<View>(R.id.change_color).setOnClickListener {
            val random = Random()
            myRandomColor = random.nextInt(900000) + 100000
            viewModel.setcolor(myRandomColor)
        }
    }

}
