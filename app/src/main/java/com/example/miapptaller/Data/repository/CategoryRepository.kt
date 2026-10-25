package com.example.miapptaller.Data.repository

import com.example.miapptaller.Data.dao.CategoryDao
import com.example.miapptaller.Data.model.Category

class CategoryRepository(private val categoryDao: CategoryDao) {
    suspend fun getCategories(): List<Category>{
        return categoryDao.getCategories()
    }
    suspend fun insertCategories(categories: List<Category>){
        categoryDao.insertCategories(categories)
    }
    suspend fun countCategories(): Int{
        return categoryDao.countCategories()
    }
}