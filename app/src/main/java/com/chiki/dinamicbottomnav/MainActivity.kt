package com.chiki.dinamicbottomnav

import android.os.Bundle
import android.view.MenuItem
import android.widget.CompoundButton
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.CompoundButtonCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.chiki.dinamicbottomnav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            setButtomNav(isChecked)
        }
        setButtomNav(false)
    }
    private fun setButtomNav(settings:Boolean){
        val navView: BottomNavigationView = binding.navView
        navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration:AppBarConfiguration = if(settings){
            AppBarConfiguration(
                setOf(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_calls,R.id.navigation_settings)
            )
        }else{
            AppBarConfiguration(
                setOf(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_calls,R.id.navigation_contacts)
            )
        }
        if (settings){
            navView.menu.removeItem(R.id.navigation_contacts)
            navView.menu.add(0,R.id.navigation_settings,0,"Settings").setIcon(R.drawable.ic_settings)
            navView.invalidate()
//            navView.menu.clear()
//            navView.inflateMenu(R.menu.bottom_nav_menu_with_settings)
        }
        else{
            navView.menu.removeItem(R.id.navigation_settings)
            navView.menu.add(0,R.id.navigation_contacts,0,"Contacts").setIcon(R.drawable.ic_contacts)
            navView.invalidate()
//            navView.menu.clear()
//            navView.inflateMenu(R.menu.bottom_nav_menu_with_contacts)
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

}