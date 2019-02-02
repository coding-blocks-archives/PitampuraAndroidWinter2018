package com.codingblocks.alertdialogs

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_custom.*
import kotlinx.android.synthetic.main.alert_custom.view.*

class MainActivity : AppCompatActivity() {

    private val itemsArray = arrayOf("Option 1", "Option 2", "Option 3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simpleAlert: AlertDialog = AlertDialog.Builder(this)
            .setMessage("I'm a simple Alert Dialog")
            .setTitle("Simple Alert Dialog")
//            .setItems(arrayOf("Option 1", "Option 2", "Option 3")) { dialog, which ->
//
//            }
            .setCancelable(false)
            .setNegativeButton("No") { dialog, which ->
                Toast.makeText(this, "Negative button was clicked", LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setPositiveButton("Yes") { dialog, which ->
                Toast.makeText(this, "Positive button was clicked", LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .create()


        val listAlert: AlertDialog = AlertDialog.Builder(this)
//            .setMessage("I'm a list Alert Dialog")
            .setTitle("List Alert Dialog")
            .setItems(itemsArray) { dialog, which ->
                Toast.makeText(this, "The item ${itemsArray[which]} was clicked", LENGTH_SHORT).show()
                dialog.dismiss()
            }

            .setCancelable(false)
            .setNegativeButton("No") { dialog, which ->
                Toast.makeText(this, "Negative button was clicked", LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setPositiveButton("Yes") { dialog, which ->
                Toast.makeText(this, "Positive button was clicked", LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .create()


        val inflatedView = LayoutInflater.from(this).inflate(R.layout.alert_custom, null, false)

        val customAlert: AlertDialog = AlertDialog.Builder(this)
            .setView(inflatedView)
            .setTitle("Create a new Note")
            .setNegativeButton("No") { dialog, which ->
                Toast.makeText(this, "Negative button was clicked", LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setPositiveButton("Yes") { dialog, which ->
                Toast.makeText(
                    this,
                    "You entered ${inflatedView.etTitle.text} and ${inflatedView.etDesc.text}",
                    LENGTH_SHORT
                ).show()
                //Save this to the DB
                dialog.dismiss()
            }
            .create()

        btnSimpleDialog.setOnClickListener {
            //Show a simple alertDialog here
            simpleAlert.show()
        }

        btnListDialog.setOnClickListener {
            listAlert.show()
        }

        btnCustomDialog.setOnClickListener {
            //Show a custom alertDialog here
            customAlert.show()
        }

    }
}
