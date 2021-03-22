package com.dimas.alodokter.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.dimas.alodokter.R
import com.dimas.alodokter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.main_nav_fragment)
        binding.mainBottomNav.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { controller: NavController?, destination: NavDestination, arguments: Bundle? ->
            when (destination.id) {
                R.id.detailFragment -> {
                    binding.mainBottomNav.visibility = View.GONE
                }
                else -> {
                    binding.mainBottomNav.visibility = View.VISIBLE
                }
            }
        }
    }
}