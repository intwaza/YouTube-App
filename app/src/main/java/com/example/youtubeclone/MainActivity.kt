package com.example.youtubeclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeclone.fragments.exploration_fragment
import com.example.youtubeclone.fragments.home_fragment
import com.example.youtubeclone.fragments.subscriptions_fragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    lateinit var rvItems: RecyclerView
    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstFragment = home_fragment()
        val secondFragment = exploration_fragment()
        val thirdFragment = subscriptions_fragment()
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        setCurrentFragment(firstFragment)
        bottomNavigationView.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.nav_home -> setCurrentFragment(firstFragment)
                R.id.nav_exploration -> setCurrentFragment(secondFragment)
                R.id.nav_subscription -> setCurrentFragment(thirdFragment)

            }


        }
        displayYouTube()
    }
    fun displayYouTube() {
        var youTubeList = listOf(
            YouTubeList(
                "https://images.pexels.com/photos/6919994/pexels-photo-6919994.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Music is the best thing"
            ),
            YouTubeList(
                "https://images.pexels.com/photos/1701209/pexels-photo-1701209.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "Focus on what you are doing"
            ),
            YouTubeList(
                "https://images.pexels.com/photos/618612/pexels-photo-618612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "You want to do sport join us you will enjoy"
            ),
            YouTubeList(
                "https://images.pexels.com/photos/1007066/pexels-photo-1007066.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                "you can get develop your skills by joining us"
            )
        )
        rvItems = findViewById(R.id.rvItems)
        var youTubeAdapter = RvAdapterItems(youTubeList)
        rvItems.layoutManager = LinearLayoutManager(baseContext)
        rvItems.adapter = youTubeAdapter
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            commit()
        }


}




