package com.hsyncnblk.bottom_nav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hsyncnblk.bottom_nav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home->replaceFragment(HomeFragment())
                R.id.nav_favorite->replaceFragment(FavoriteFragment())
                R.id.nav_person->replaceFragment(PersonFragment())
                R.id.nav_settings->replaceFragment(SettingsFragment())

                else->{

                }

            }
            true


        }



    }
    private fun replaceFragment(fragment:Fragment)
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment)
        fragmentTransaction.commit()
    }
}