package com.nasywa.foodiess.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.nasywa.foodiess.R
import com.nasywa.foodiess.databinding.ActivityMainBinding
import com.nasywa.foodiess.fragment.BreakfastFragment
import com.nasywa.foodiess.fragment.DessertFragment
import com.nasywa.foodiess.fragment.VegetarianFragment

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setContentView(mainBinding.root)
        setCurrentFragment(BreakfastFragment())
        mainBinding.navMain.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_Breakfast -> setCurrentFragment(BreakfastFragment())
                R.id.ic_Vegetarian -> setCurrentFragment(VegetarianFragment())
                R.id.ic_Dessert -> setCurrentFragment(DessertFragment())
            }
            true
        }
    }

    private fun setCurrentFragment(fragment:Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flMain,fragment)
            commit()

        }

    }
}