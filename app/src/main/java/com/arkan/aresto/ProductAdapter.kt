package com.arkan.aresto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arkan.aresto.databinding.ItemProductBinding
import com.arkan.aresto.model.Product
import java.text.DecimalFormat
import java.text.NumberFormat

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
            private val formatPrice : NumberFormat = DecimalFormat("#,###")
        fun bind(item: Product) {
            binding.ivProductImage.setImageResource(item.image)
            binding.tvProductName.text = item.name
            binding.tvProductPrice.text = buildString {
                append("Rp. ")
                append(formatPrice.format(item.price))
            }
        }
    }
}