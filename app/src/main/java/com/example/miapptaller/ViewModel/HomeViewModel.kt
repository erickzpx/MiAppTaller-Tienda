package com.example.miapptaller.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miapptaller.Data.repository.CategoryRepository
import com.example.miapptaller.Data.model.Category
import com.example.miapptaller.ui.theme.ultra_l_blue
import com.example.miapptaller.ui.theme.ultra_l_green
import com.example.miapptaller.ui.theme.ultra_l_purple
import com.example.miapptaller.ui.theme.ultra_l_red
import com.example.miapptaller.ui.theme.ultra_l_yellow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.miapptaller.R

class HomeViewModel (private val categoryRepository: CategoryRepository): ViewModel(){
    private val _categories= MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories
    init {
        viewModelScope.launch {
            insertInitialCategories()
            loadCategories()
        }
    }
    private suspend fun loadCategories(){
        _categories.value = categoryRepository.getCategories()
    }
    private suspend fun insertInitialCategories(){
        if (categoryRepository.countCategories()==0){
            val categories = listOf(
                Category(
                    name = "Tachones (FG)",
                    image = R.drawable.manzana,
                    color = ultra_l_green
                ),
                Category(
                    name = "Turf (TF)",
                    image = R.drawable.carne,
                    color = ultra_l_red
                ),
                Category(
                    name = "Futsal (IC)",
                    image = R.drawable.leche,
                    color = ultra_l_blue
                ),
                Category(
                    name = "Mixtos (SG)",
                    image = R.drawable.pan,
                    color = ultra_l_yellow
                ),
                Category(
                    name = "Accesorios",
                    image = R.drawable.bebidas,
                    color = ultra_l_purple
                )
            )
            categoryRepository.insertCategories(categories)
        }
    }
}