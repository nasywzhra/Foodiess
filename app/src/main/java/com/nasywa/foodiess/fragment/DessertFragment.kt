package com.nasywa.foodiess.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nasywa.foodiess.R
import com.nasywa.foodiess.databinding.FragmentDessertBinding
import com.nasywa.foodiess.model.Recipes


class DessertFragment : Fragment() {
    private lateinit var dessertBinding: FragmentDessertBinding
    private val list : ArrayList<Recipes> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dessert, container, false)
    }

}