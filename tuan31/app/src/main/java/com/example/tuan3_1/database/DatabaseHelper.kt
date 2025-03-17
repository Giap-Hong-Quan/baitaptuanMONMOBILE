package com.example.tuan3_1.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "tuan03_01", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("PRAGMA foreign_keys=ON;") // Bật khóa ngoại

        db?.execSQL("""
            CREATE TABLE Category (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL
            )
        """)

        db?.execSQL("""
            CREATE TABLE Attribute (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                category_id INTEGER,
                title TEXT NOT NULL,
                description TEXT NOT NULL,
                FOREIGN KEY(category_id) REFERENCES Category(id) ON DELETE CASCADE
            )
        """)

        // Kiểm tra và thêm dữ liệu mẫu nếu cần
        insertSampleData(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("PRAGMA foreign_keys=ON;")

        // Chỉ cập nhật bảng nếu có thay đổi
        if (oldVersion < newVersion) {
            db?.execSQL("DROP TABLE IF EXISTS Attribute")
            db?.execSQL("DROP TABLE IF EXISTS Category")
            onCreate(db)
        }
    }

    private fun insertSampleData(db: SQLiteDatabase?) {
        db?.execSQL("INSERT INTO Category (name) VALUES ('UI Components')")
        db?.execSQL("INSERT INTO Category (name) VALUES ('Navigation')")
        db?.execSQL("INSERT INTO Category (name) VALUES ('hongquan')")

        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (1, 'Button', 'A clickable button')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (1, 'Button2', 'A clickable button')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (1, 'TextView', 'A text label')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (2, 'BottomNavigation', 'Bottom navigation bar')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (3, 'giap', 'oke baby')")
    }
}
