package com.example.skillbloomapp.ui.element.activity

import PostFragment
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.skillbloomapp.R
import com.example.skillbloomapp.databinding.ActivityMainBinding
import com.example.skillbloomapp.global.AppPref
import com.example.skillbloomapp.ui.element.fragment.CommunityFragment
import com.example.skillbloomapp.ui.element.fragment.HomeFragment
import com.example.skillbloomapp.ui.element.fragment.ProfileFragment
import com.example.skillbloomapp.ui.element.fragment.SaveFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val homeFragment = HomeFragment()
    private val communityFragment = CommunityFragment()
    private val postFragment = PostFragment()
    private val saveFragment = SaveFragment()
    private val profileFragment = ProfileFragment()

    private lateinit var activeFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        activeFragment = homeFragment
        fragmentTransaction.add(binding.lytFragment.id, homeFragment)
        fragmentTransaction.add(binding.lytFragment.id, communityFragment).hide(communityFragment)
        fragmentTransaction.add(binding.lytFragment.id, postFragment).hide(postFragment)
        fragmentTransaction.add(binding.lytFragment.id, saveFragment).hide(saveFragment)
        fragmentTransaction.add(binding.lytFragment.id, profileFragment).hide(profileFragment)

        fragmentTransaction.commit()

        binding.bottomNavigationView.setOnItemSelectedListener {
            handleOnNavigationItemSelected(it)
        }

    }

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
    }

}