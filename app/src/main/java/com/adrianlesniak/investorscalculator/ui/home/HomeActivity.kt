package com.adrianlesniak.investorscalculator.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import com.adrianlesniak.investorscalculator.R
import com.adrianlesniak.investorscalculator.ui.home.dashboard.DashboardFragment
import com.adrianlesniak.investorscalculator.ui.home.settings.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity() {

    companion object {
        const val ENTRY_FRAGMENT_ID = R.id.navigation_dashboard
    }

    private val onNavigationItemSelectedListener = OnNavigationItemSelectedListener { item ->
        when (item.itemId) {

            R.id.navigation_dashboard -> {
                replaceFragment(DashboardFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                replaceFragment(SettingsFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        nav_view.selectedItemId = ENTRY_FRAGMENT_ID
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.content_frame, fragment)
            .setTransition(TRANSIT_FRAGMENT_OPEN)
            .commit()
    }
}
