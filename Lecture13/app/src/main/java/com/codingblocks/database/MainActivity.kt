package com.codingblocks.database

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = StudentDatabase(this, "my_app.db", null, 6)

        val students = database.getStudents()
        Log.e("TAG", "Number of entries in the database are ${students.size + 1}")
        Log.e("TAG", students[0].toString())

        val studentWithRoll = database.getStudentById(420)

        Log.e("TAG", "Student with ID 12 is : ${studentWithRoll?.toString()}")

        btnSubmit.setOnClickListener {

            val student = Student(
                etName.text.toString(),
                etRoll.text.toString(),
                etBranch.text.toString(),
                System.currentTimeMillis()
            )

//            val studentStrin = "" + student.name + " " + student.rollNo
//
//            val studentString = "${student.name} ${student.rollNo}"

            val long = database.insert(student)

            Log.e("TAG", "inserted data at row $long")

//            database.writableDatabase.execSQL(
//                """
//                INSERT INTO student VALUES(
//                ${student.rollNo},
//                ${student.name},
//                ${student.admissionDate},
//                ${student.branch},
//                "Delhi"
//                );
//            """.trimIndent()
//            )

            //Save this student to the database
        }

    }
}
