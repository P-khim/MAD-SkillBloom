package com.example.skillbloomapp.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.skillbloomapp.R
import com.example.skillbloomapp.databinding.ActivityHomeBinding
import com.example.skillbloomapp.fragment.CommunityFragment
import com.example.skillbloomapp.fragment.HomeFragment
import com.example.skillbloomapp.fragment.PostFragment
import com.example.skillbloomapp.fragment.ProfileFragment
import com.example.skillbloomapp.fragment.SaveFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Show initial HomeFragment
        showFragment(HomeFragment())

        // Handle bottom navigation item selection
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            handleOnNavigationItemSelected(item)
        }
    }

    private fun handleOnNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mnuHome -> {
                showFragment(HomeFragment())
                true
            }
//            R.id.mnuCommunity -> {
//                showFragment(CommunityFragment())
//                true
//            }
//            R.id.mnuPost -> {
//                showFragment(PostFragment())
//                true
//            }
//            R.id.mnuSave -> {
//                showFragment(SaveFragment())
//                true
//            }
//            R.id.mnuProfile -> { // Ensure you have the correct ID for ProfileFragment
//                showFragment(ProfileFragment())
//                true
//            }
            else -> false
        }
    }

    private fun showFragment(fragment: HomeFragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.lytFragment.id, fragment)
        fragmentTransaction.commit()
    }
}

private fun FragmentTransaction.replace(id: Int, fragment: HomeFragment) {

}
