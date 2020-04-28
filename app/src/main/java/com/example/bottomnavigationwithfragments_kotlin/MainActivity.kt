package com.example.bottomnavigationwithfragments_kotlin

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import fragments.DashboardFragment
import fragments.HomeFragment
import fragments.NotificationsFragment
import fragments.ProfileFragment

class MainActivity : AppCompatActivity()  {



    //create three objects for the fragments
    lateinit var homeFragment: HomeFragment
    lateinit var profileFragment: ProfileFragment
    lateinit var dashboardFragment: DashboardFragment
    lateinit var notificationsFragment: NotificationsFragment

    //declare the bottomNavigation view
    lateinit var bottomNavigationView: BottomNavigationView





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       // title=resources.getString(R.string.title_home)
        loadFragment(HomeFragment())



        //initialize the bottomNavigationView
        bottomNavigationView = findViewById(R.id.navigation)

        //assign the itemSelected listener to the bottomNavigation View
        bottomNavigationView.setOnNavigationItemSelectedListener {item ->
            //handle the switching of the different fragments in the bottomNavigation View
            when(item.itemId){
                R.id.navigation_home-> {
                    title =resources.getString(R.string.title_home)
                    loadFragment(HomeFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_profile-> {
                    title=resources.getString(R.string.title_profile)
                    loadFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_dashboard-> {
                    title=resources.getString(R.string.title_dashboard)
                    loadFragment(DashboardFragment())
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.navigation_notifications-> {
                    title=resources.getString(R.string.title_notifications)
                    loadFragment(NotificationsFragment())
                    return@setOnNavigationItemSelectedListener true
                }

            }
            false

        }
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.layout_frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}