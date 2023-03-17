package com.enigmacamp.simplefragmentmanager.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.enigmacamp.simplefragmentmanager.*

class NavigationUtilImpl(private val fm: FragmentManager) : NavigationUtil {
    private val loginFragment by lazy {
        LoginFragment.newInstance(this)
    }
    private val homeFragment by lazy {
        HomeFragment.newInstance(this)
    }
    private val contactUsFragment by lazy {
        ContactUsFragment.newInstance()
    }

    private fun onFragmentTransaction(fragment: Fragment, tag: String, backStackTag: String?) {
        fm.beginTransaction().apply {
            replace(R.id.fl_container, fragment, tag)
            backStackTag?.let {
                addToBackStack(backStackTag)
            }
            commit()
        }
    }

    override fun navigate(fragmentId: FragmentName, bundle: Bundle?) {
        when (fragmentId) {
            FragmentName.HOME_FRAGMENT -> {
                homeFragment.arguments = bundle
                onFragmentTransaction(homeFragment, FragmentName.HOME_FRAGMENT.name, null)
            }
            FragmentName.CONTACT_US_FRAGMENT -> onFragmentTransaction(
                contactUsFragment,
                FragmentName.CONTACT_US_FRAGMENT.name,
                FragmentName.HOME_FRAGMENT.name
            )
            else -> onFragmentTransaction(loginFragment, FragmentName.LOGIN_FRAGMENT.name, null)
        }
    }
}