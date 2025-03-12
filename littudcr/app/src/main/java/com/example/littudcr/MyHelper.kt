package com.example.littudcr

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context:Context) :SQLiteOpenHelper(context,"TUHOCDB",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE TUHOC(_id Integer PRIMARY KEY AUTOINCREMENT,user TEXT ,email TEXT)")
        // them data vao csdl
        db?.execSQL("INSERT INTO TUHOC (user,email) VALUES ('hongquan1','1@gmail.com')")
        db?.execSQL("INSERT INTO TUHOC (user,email) VALUES ('hongquan2','2@gmail.com')")
        db?.execSQL("INSERT INTO TUHOC (user,email) VALUES ('hongquan3','3@gmail.com')")
        db?.execSQL("INSERT INTO TUHOC (user,email) VALUES ('hongquan4','4@gmail.com')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }


}