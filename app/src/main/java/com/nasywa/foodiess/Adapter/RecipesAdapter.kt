package com.nasywa.foodiess.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nasywa.foodiess.activity.DetailActivity
import com.nasywa.foodiess.databinding.ItemRecipeBinding
import com.nasywa.foodiess.model.Recipes

class RecipesAdapter (private val ListRecipe : ArrayList<Recipes>) : RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder>() {
    inner class RecipesViewHolder (val binnding : ItemRecipeBinding) :RecyclerView.ViewHolder(binnding.root)



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipesViewHolder {
        val binnding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return RecipesViewHolder(binnding)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        with(holder){
            with(ListRecipe[position]){
                Glide.with(holder.itemView.context).load(pictures).into(binnding.ivItemRecipe)
                binnding.tvItemName. text= name
                binnding.tvItemCategory.text = category
                binnding.tvItemNumber.text = number
                val mContext = holder.itemView.context
                holder.itemView.setOnClickListener {
                    val datasend = Recipes(
                        name = ListRecipe[position].name,
                        category = ListRecipe[position].category,
                        description = ListRecipe[position].description,
                        ingredients = ListRecipe[position].ingredients,
                        instructions = ListRecipe[position].instructions,
                        pictures = ListRecipe[position].pictures,
                        number = ListRecipe[position].number,
                        calories = ListRecipe[position].calories,
                        carbo = ListRecipe[position].carbo,
                        protein = ListRecipe[position].protein

                    )
                    val intentToDetail = Intent (mContext, DetailActivity::class.java)
                    intentToDetail.putExtra(DetailActivity.RECIPE_DATA,datasend)
                    mContext.startActivity(intentToDetail)
                }

            }
        }
    }

    override fun getItemCount(): Int = ListRecipe.size
}