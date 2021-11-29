package com.example.recipecatalog.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recipecatalog.R
import com.example.recipecatalog.adapter.RecipesAdapter
import com.example.recipecatalog.data.DataRecipes
import com.example.recipecatalog.data.Recipes
import com.example.recipecatalog.databinding.FragmentSeafoodBinding


class SeafoodFragment : Fragment() {

    private var binding: FragmentSeafoodBinding? = null
    private var listSeafood: ArrayList<Recipes> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSeafoodBinding.inflate(inflater, container, false)
        initData()
        return binding!!.root
    }

    private fun initData() {
        with(resources) {
            val name = getStringArray(R.array.name_seafood)
            val category = getStringArray(R.array.category_seafood)
            val description = getStringArray(R.array.description_seafood)
            val ingredients = getStringArray(R.array.ingredients_seafood)
            val instructions = getStringArray(R.array.instructions_seafood)
            val photo = getStringArray(R.array.photo_seafood)
            val price = getStringArray(R.array.price_seafood)
            val calories = getStringArray(R.array.calories_seafood)
            val carbo = getStringArray(R.array.carbo_seafood)
            val protein = getStringArray(R.array.protein_seafood)

            for (data in name.indices) {
                val recipe = Recipes(
                    name[data],
                    category[data],
                    description[data],
                    ingredients[data],
                    instructions[data],
                    photo[data],
                    price[data],
                    calories[data],
                    carbo[data],
                    protein[data]
                )
                listSeafood.add(recipe)
            }
        }


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.rvSeafood?.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = RecipesAdapter(DataRecipes.listDessert)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}