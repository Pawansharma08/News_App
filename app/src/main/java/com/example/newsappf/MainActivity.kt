package com.example.newsappf

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsappf.Fragments.BreakingNewsfragment
import com.example.newsappf.Fragments.SavedNewsFragment
import com.example.newsappf.Fragments.SearchNewsfrag
import com.example.newsappf.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.NavigationMenu

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener{
            when (it.itemId) {
                R.id.breakingNewsfragment2 -> {
                    replacefrage(BreakingNewsfragment())

                }
                R.id.savedNewsFragment2 -> {
                    replacefrage(SavedNewsFragment())

                }
                R.id.searchNewsfrag2 -> {
                    replacefrage(SearchNewsfrag())
                }
            }
            true
        }
    }

    private fun replacefrage(frag:Fragment){

        val fragmentManager  = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.newsNavHostFragment,frag)
        fragmentTransaction.commit()
    }


}