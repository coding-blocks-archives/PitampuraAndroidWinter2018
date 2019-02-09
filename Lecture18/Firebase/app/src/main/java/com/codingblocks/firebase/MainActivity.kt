package com.codingblocks.firebase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSubmit.setOnClickListener {

            val name = etName.text.toString()
            val surName = etSurname.text.toString()
            //Submit the input to firebase

//            FirebaseDatabase.getInstance().reference.setValue(name)

            val rootNode = FirebaseDatabase.getInstance().reference

            for (i in 1..100) {
                rootNode.push()
                        .setValue(Student().apply {
                            this.name = i.toString()
                            this.surName = (i + 1).toString()
                        })
                        .addOnFailureListener {
                            it.printStackTrace()
                        }
                        .addOnCompleteListener {

                        }
            }

//            FirebaseDatabase.getInstance().reference.child("name").setValue(name)
//
//            FirebaseDatabase.getInstance().reference.child("surName").setValue(surName)
        }

//        FirebaseDatabase.getInstance().reference.addValueEventListener(object : ValueEventListener {
//            override fun onCancelled(dbErr: DatabaseError) {
//
//                Log.e("TAG", "Failed to fetch the details : ${dbErr.message}")
//
//            }
//
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//
//                val children = dataSnapshot.children
//
//                for (ds: DataSnapshot in children) {
//
//                    val currentStudent: Student? = ds.getValue(Student::class.java)
//
//                    Log.e("TAG", "onDataChanged : Name : ${currentStudent?.name}")
//
//                }
//
//            }
//
//        })

        FirebaseDatabase.getInstance().reference.addChildEventListener(object : ChildEventListener {

            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onChildMoved(ds: DataSnapshot, previousKey: String?) {

            }

            override fun onChildChanged(ds: DataSnapshot, p1: String?) {
                val student = ds.getValue(Student::class.java)

                Log.e("TAG", "onChildChanged : Name : ${student?.name}")

                Log.e("TAG", "onChildChanged : key : $p1")
            }

            override fun onChildAdded(ds: DataSnapshot, previousKey: String?) {

                val student = ds.getValue(Student::class.java)
                Log.e("TAG", "onChildAdded : Name : ${student?.name}")
                Log.e("TAG", "onChildAdded : Name : $previousKey")

            }

            override fun onChildRemoved(ds: DataSnapshot) {
                val student = ds.getValue(Student::class.java)
            }

        })

    }
}
