package com.codingblocks.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class StudentDatabase(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {


    /**
     * There is no default implementation for this method!
     */

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

        db?.execSQL("DROP TABLE student")
        db?.execSQL("DROP TABLE marks")
        onCreate(db)
//
//        if (oldVersion == 1 && newVersion == 2) {
//            //Do something
//        }
//        if (oldVersion == 2 && newVersion == 3) {
//            //Do something else
//        }
//        if (oldVersion == 3 && newVersion == 4) {
//
//        }
    }

    override fun onCreate(db: SQLiteDatabase?) {

        //Creating the student table
        db?.execSQL(
            """
           CREATE TABLE student(
           roll INTEGER PRIMARY KEY NOT NULL,
           name TEXT NOT NULL,
           admissionDate REAL NOT NULL,
           branch TEXT NOT NULL);
        """.trimIndent()
        )

        //Creating the marks table
        db?.execSQL(
            """
            CREATE TABLE marks(
            roll INTEGER PRIMARY KEY NOT NULL,
            marks REAL NOT NULL
            );
        """.trimIndent()
        )

        //Insert some mock data
        db?.execSQL(
            """
            INSERT INTO student VALUES (12,"Harshit",34534534543,"ECE");
        """.trimIndent()
        )

        db?.execSQL(
            """
            INSERT INTO marks VALUES (12, 420);
        """.trimIndent()
        )
    }

    fun getStudents(): ArrayList<Student> {

        val students = arrayListOf<Student>()
        //Do something that populates the students array

        val studentCursor = readableDatabase.query(
            "student",
            null,
            null,
            null,
            null,
            null,
            null,
            null
        )

        while (studentCursor.moveToNext()) {

            val roll = studentCursor.getInt(0)
            val name = studentCursor.getString(1)
            val admissionDate = studentCursor.getLong(2)
            val branch = studentCursor.getString(3)

            val currentStudent =
                Student(
                    rollNo = roll.toString(),
                    name = name,
                    admissionDate = admissionDate,
                    branch = branch
                )

            students.add(currentStudent)
        }

        studentCursor.close()

        return students
    }

    fun insert(student: Student): Long {
        //insert the student object in the database
        val contentValues = ContentValues()

        with(contentValues) {
            put("roll", student.rollNo)
            put("name", student.name)
            put("branch", student.branch)
            put("admissionDate", student.admissionDate)
//            put("address", "Delhi")
        }

        return writableDatabase.insert("student", null, contentValues)
    }

    fun getStudentById(roll: Int): Student? {

        val cursor = readableDatabase.query(
            "student",
            arrayOf("roll", "name", "admissionDate", "branch"),
            "roll = ?",
            arrayOf(roll.toString()),
            null,
            null,
            null
        )

        if (cursor.moveToNext()) {
            val number = cursor.getInt(0)
            val name = cursor.getString(1)
            val admissionDate = cursor.getLong(2)
            val branch = cursor.getString(3)

            cursor.close()

            return Student(
                rollNo = number.toString(),
                name = name,
                admissionDate = admissionDate,
                branch = branch
            )
        }

        return null
    }

}