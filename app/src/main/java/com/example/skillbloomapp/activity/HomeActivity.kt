package com.example.skillbloomapp.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.skillbloomapp.R
import com.example.skillbloomapp.databinding.ActivityHomeBinding
import com.example.skillbloomapp.fragment.CommunityFragment
import com.example.skillbloomapp.fragment.HomeFragment
import com.example.skillbloomapp.fragment.PostFragment
import com.example.skillbloomapp.fragment.ProfileFragment
import com.example.skillbloomapp.fragment.SaveFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private val homeFragment = HomeFragment()
    private val communityFragment = CommunityFragment()
    private val postFragment = PostFragment()
    private val saveFragment = SaveFragment()
    private val profileFragment = ProfileFragment()

    private lateinit var activeFragment: Fragment

    private var isLoggedIn = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Show initial HomeFragment
//        showFragment(HomeFragment())

        // Handle bottom navigation item selection
//        binding.bottomNavigationView.setOnItemSelectedListener { item ->
//            handleOnNavigationItemSelected(item)
//        }

        // Add all fragments to the Activity
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        activeFragment = homeFragment
        fragmentTransaction.add(binding.lytFragment.id, homeFragment)
        fragmentTransaction.add(binding.lytFragment.id, communityFragment).hide(communityFragment)
        fragmentTransaction.add(binding.lytFragment.id, postFragment).hide(postFragment)
        fragmentTransaction.add(binding.lytFragment.id, saveFragment).hide(saveFragment)
        fragmentTransaction.add(binding.lytFragment.id, profileFragment).hide(profileFragment)

        fragmentTransaction.commit()

        // Handle bottom navigation view item click
        /*binding.bottomNavigationView.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                return handleOnNavigationItemSelected(item)
            }
        })*/

        /*binding.bottomNavigationView.setOnItemSelectedListener { item ->
            handleOnNavigationItemSelected(item)
        }*/

        binding.bottomNavigationView.setOnItemSelectedListener {
            handleOnNavigationItemSelected(it)
        }


    }

//    fun showProfileFragment(profile: Profile) {
//        Log.d("ruppite", "show profile")
//        profileFragment.profile = profile
//        val fragmentTransaction = supportFragmentManager.beginTransaction()
//        fragmentTransaction.remove(moreFragment)
//        fragmentTransaction.remove(loginFragment)
//        fragmentTransaction.add(binding.lytFragment.id, profileFragment)
//        fragmentTransaction.add(binding.lytFragment.id, moreFragment).hide(moreFragment)
//        fragmentTransaction.commit()
//    }

    private fun handleOnNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mnuHome -> showFragment(homeFragment)
            R.id.mnuCommunity -> showFragment(communityFragment)
            R.id.mnuPost -> showFragment(postFragment)
            R.id.mnuSave -> showFragment(saveFragment)
            else -> showFragment(profileFragment)
        }

        return true
    }



    private fun showFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.hide(activeFragment)
        fragmentTransaction.show(fragment)
        activeFragment = fragment
        fragmentTransaction.commit()

        /*supportFragmentManager.beginTransaction().apply {
            replace(binding.lytFragment.id, fragment)
            commit()
        }*/

        /*with (supportFragmentManager.beginTransaction()) {
            replace(binding.lytFragment.id, fragment)
            commit()
        }*/
    }

}