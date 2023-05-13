package com.ibnufebianproject.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ibnufebianproject.bottomnavigation.fragment.HomeFragment
import com.ibnufebianproject.bottomnavigation.fragment.NotificationFragment
import com.ibnufebianproject.bottomnavigation.fragment.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val notificationFragment = NotificationFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment (homeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
          when(it.itemId){
              R.id.menu_home -> makeCurrentFragment(homeFragment)
              R.id.menu_notification -> makeCurrentFragment(notificationFragment)
              R.id.menu_setting -> makeCurrentFragment(settingsFragment)
          }
            true

        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_nav, fragment)
            commit()
        }
    }
}

