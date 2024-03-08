package com.arkan.aresto

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.arkan.aresto.databinding.ActivityMainBinding
import com.arkan.aresto.model.Category
import com.arkan.aresto.model.Product

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val categoryAdapter = CategoryAdapter()
    private val productAdapter = ProductAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setListCategory()
        setListProduct()
    }
    private fun setListCategory() {
        val dataCategory = listOf(
            Category(image = R.drawable.img_category_rice, name = "Nasi"),
            Category(image = R.drawable.img_category_noodle, name = "Mie"),
            Category(image = R.drawable.img_category_snack, name = "Snack"),
            Category(image = R.drawable.img_category_drink, name = "Minuman")
        )
        binding.rvCategory.apply {
            adapter = this@MainActivity.categoryAdapter
        }
        categoryAdapter.submitData(dataCategory)
    }

    private fun setListProduct() {
        val dataProduct = listOf(
            Product(image = R.drawable.img_grilled_chicken, name = "Ayam Bakar", price = 50000.00),
            Product(image = R.drawable.img_fried_chicken, name = "Ayam Goreng", price = 40000.00),
            Product(image = R.drawable.img_geprek_chicken, name = "Ayam Geprek", price = 40000.00),
            Product(image = R.drawable.img_chicken_guts_satay, name = "Sate Usus Ayam", price = 5000.00),
            Product(image = R.drawable.img_fried_rice, name = "Nasi Goreng", price = 20000.00),
            Product(image = R.drawable.img_fried_noodle, name = "Mie Goreng", price = 15000.00),
        )
        binding.layoutProduct.rvProduct.apply {
            adapter = this@MainActivity.productAdapter
        }
        productAdapter.submitData(dataProduct)
    }
}