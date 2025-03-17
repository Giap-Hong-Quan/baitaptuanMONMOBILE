package com.example.tuan3_1.repository

import com.example.tuan3_1.database.DatabaseHelper
import com.example.tuan3_1.entity.Attribute
import com.example.tuan3_1.entity.Category

class CategoryRepository(private val dbHelper: DatabaseHelper) {

    fun getCategories(): List<Category> {
        val db = dbHelper.readableDatabase
        val categoryList = mutableListOf<Category>()

        val categoryCursor = db.rawQuery("SELECT * FROM Category", null)
        while (categoryCursor.moveToNext()) {
            val categoryId = categoryCursor.getInt(0)
            val categoryName = categoryCursor.getString(1)

            val attributeList = mutableListOf<Attribute>()
            val attributeCursor = db.rawQuery("SELECT * FROM Attribute WHERE category_id = ?", arrayOf(categoryId.toString()))
            while (attributeCursor.moveToNext()) {
                attributeList.add(Attribute(
                    id = attributeCursor.getInt(0),
                    categoryId = attributeCursor.getInt(1),
                    title = attributeCursor.getString(2),
                    description = attributeCursor.getString(3)
                ))
            }
            attributeCursor.close()

            categoryList.add(Category(id = categoryId, name = categoryName, attributes = attributeList))
        }
        categoryCursor.close()
        db.close()

        return categoryList
    }
}
