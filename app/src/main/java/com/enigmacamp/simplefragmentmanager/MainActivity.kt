package com.enigmacamp.simplefragmentmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), FragmentNavigation {
    private val loginFragment = LoginFragment.newInstance(this)
    private val homeFragment = HomeFragment.newInstance()
    private val contactUsFragment = ContactUsFragment.newInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigate(FragmentName.LOGIN_FRAGMENT, null)
    }

    private fun onFragmentTransaction(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_container, fragment)
            commit()
        }
    }

    override fun navigate(fragmentId: FragmentName, bundle: Bundle?) {
        when (fragmentId) {
            FragmentName.HOME_FRAGMENT -> {
                val fragment = homeFragment
                fragment.arguments = bundle
                onFragmentTransaction(homeFragment)
            }
            FragmentName.CONTACT_US_FRAGMENT -> onFragmentTransaction(contactUsFragment)
            else -> onFragmentTransaction(loginFragment)
        }
    }
}