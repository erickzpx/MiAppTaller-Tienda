package com.example.miapptaller.ViewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.miapptaller.Data.model.Product
import com.example.miapptaller.Data.repository.ProductRepository
import com.example.miapptaller.R
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository): ViewModel() {
    //Obtener todos los productos
    val products: StateFlow<List<Product>> = repository.allProducts
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),emptyList())
    init {
        checkAndInsertInitialData()
    }

    private fun checkAndInsertInitialData() {
        viewModelScope.launch {
            if(repository.getProductCount()==0){
                val initialProducts = listOf(
                    Product(name = "Adidas Predator Elite", image = R.drawable.pechuga, price = 5299.0f, measure = "par", isOffer = true),
                    Product(name = "Nike Tiempo Legend", image = R.drawable.leche2, price = 3499.0f, measure = "par", isOffer = false),
                    Product(name = "Puma Future Ultimate", image = R.drawable.aguacate, price = 4199.0f, measure = "par", isOffer = true),
                    Product(name = "Espinilleras Nike Charge", image = R.drawable.galletas, price = 350.0f, measure = "par", isOffer = false)
                )
                initialProducts.forEach { repository.insertProduct(it) }
            }
        }
    }
}