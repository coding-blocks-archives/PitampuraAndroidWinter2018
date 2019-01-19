package com.codingblocks.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private var variableThatCanBeModified: String = "Hello"
    var variableWithTypeInferencing = "Hello"

    var nullUser: User? = null

    val user: User = User("Harshit", 24)

    //The val will be initialized when it's used for the first time
    val li: LayoutInflater by lazy {
        LayoutInflater.from(this)
    }

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nullUser = User("Harshit", 24)

        btnIncrement.setOnClickListener {
            count++
            tvCount.text = "Count is ${count}"
        }

        btnDecrement.setOnClickListener {
            count--
            tvCount.text = "Count is ${count}"
        }

        thread {
            //Do your work here
            runOnUiThread {
                //Run this on UI thread
            }
        }
    }

    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun singleLineAdd(a: Int, b: Int): Int = a + b

    fun singleLineAddWithTypeInferencing(a: Int, b: Int) = a + b

    fun main() {
        variableThatCanBeModified = "World"
        nullUser?.name
        print("The user's name is ${if (user.name == "Harshit") user.name else "Test"} and his/her age is ${user.age}")
    }

}
