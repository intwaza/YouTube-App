package com.example.youtubeclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.youtubeclone.fragments.exploration_fragment
import com.example.youtubeclone.fragments.home_fragment
import com.example.youtubeclone.fragments.subscriptions_fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment=home_fragment()
        val secondFragment=exploration_fragment()
        val thirdFragment=subscriptions_fragment()
        var bottomNavigationView= findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        setCurrentFragment(firstFragment)
        bottomNavigationView.setOnNavigationItemReselectedListener {
           when(it.itemId){
               R.id.nav_home->setCurrentFragment(firstFragment)
               R.id.nav_exploration->setCurrentFragment(secondFragment)
               R.id.nav_subscription->setCurrentFragment(thirdFragment)

           }
           true

       }
    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }
}