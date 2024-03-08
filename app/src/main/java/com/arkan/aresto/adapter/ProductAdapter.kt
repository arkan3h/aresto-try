package com.arkan.aresto.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arkan.aresto.databinding.ItemProductBinding
import com.arkan.aresto.model.Product
import com.arkan.aresto.utils.toIndonesianFormat

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
    private val data = mutableListOf<Product>()

    fun submitData(items: List<Product>) {
        data.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    //counting data size
    override fun getItemCount(): Int  = data.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(item: Product) {
            binding.ivProductImage.setImageResource(item.image)
            binding.tvProductName.text = item.name
            binding.tvProductPrice.text = item.price.toIndonesianFormat()
        }
    }
}