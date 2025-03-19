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
        db?.execSQL("INSERT INTO Category (name) VALUES ('Layout')")
        db?.execSQL("INSERT INTO Category (name) VALUES ('Input Fields')")
        db?.execSQL("INSERT INTO Category (name) VALUES ('Navigation')")
        db?.execSQL("INSERT INTO Category (name) VALUES ('Lists')")
        db?.execSQL("INSERT INTO Category (name) VALUES ('Dialogs & Popups')")
        db?.execSQL("INSERT INTO Category (name) VALUES ('Progress Indicators')")

        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (1, 'Text', 'Hiển thị văn bản')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (1, 'Button', 'Nút bấm có thể tương tác')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (1, 'Icon', 'Hiển thị biểu tượng')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (1, 'Card', 'Thẻ chứa nội dung')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (1, 'Snackbar', 'Hiển thị thông báo tạm thời')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (1, 'Divider', 'Đường kẻ phân cách')")

        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (2, 'Column', 'Sắp xếp các thành phần theo chiều dọc')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (2, 'Row', 'Sắp xếp các thành phần theo chiều ngang')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (2, 'Box', 'Chồng các thành phần lên nhau')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (2, 'LazyColumn', 'Danh sách cuộn theo chiều dọc')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (2, 'LazyRow', 'Danh sách cuộn theo chiều ngang')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (2, 'Surface', 'Container với nền có thể tùy chỉnh')")

        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (3, 'TextField', 'Ô nhập văn bản')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (3, 'OutlinedTextField', 'Ô nhập văn bản có viền')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (3, 'Checkbox', 'Hộp kiểm chọn/bỏ chọn')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (3, 'Switch', 'Công tắc bật/tắt')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (3, 'RadioButton', 'Lựa chọn một trong nhiều tùy chọn')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (3, 'Slider', 'Thanh trượt để chọn giá trị')")

        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (4, 'BottomNavigation', 'Thanh điều hướng ở dưới')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (4, 'NavigationBar', 'Thanh điều hướng trên')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (4, 'Drawer', 'Menu điều hướng dạng ngăn kéo')")

        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (5, 'LazyColumn', 'Danh sách cuộn theo chiều dọc')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (5, 'LazyRow', 'Danh sách cuộn theo chiều ngang')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (5, 'LazyGrid', 'Danh sách dạng lưới')")

        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (6, 'AlertDialog', 'Hộp thoại cảnh báo')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (6, 'Popup', 'Cửa sổ nhỏ hiển thị nội dung tạm thời')")

        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (7, 'LinearProgressIndicator', 'Thanh tiến trình ngang')")
        db?.execSQL("INSERT INTO Attribute (category_id, title, description) VALUES (7, 'CircularProgressIndicator', 'Thanh tiến trình hình tròn')")

    }
}
