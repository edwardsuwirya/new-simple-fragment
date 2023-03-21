package com.enigmacamp.simplefragmentmanager.navigation

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
    private val profileFragment by lazy {
        ProfileFragment.newInstance()
    }

    private fun onFragmentTransaction(
        fragment: Fragment,
        tag: String,
        backStackTag: String? = null
    ) {
        fm.beginTransaction().apply {
            replace(R.id.fl_container, fragment, tag)
            backStackTag?.let {
                addToBackStack(backStackTag)
            }
            commit()
        }
    }

    override fun navigate(fragmentNavigation: FragmentNavigation) {
        when (fragmentNavigation) {
            is FragmentNavigation.NavToHome -> {
                homeFragment.arguments = fragmentNavigation.bundle
                onFragmentTransaction(
                    homeFragment,
                    fragmentNavigation.fragmentId
                )
            }
            is FragmentNavigation.NavToLogin -> {
                onFragmentTransaction(
                    loginFragment,
                    fragmentNavigation.fragmentId,
                )
            }
            is FragmentNavigation.NavToContactUs -> onFragmentTransaction(
                contactUsFragment,
                fragmentNavigation.fragmentId,
                fragmentNavigation.backStack
            )
            is FragmentNavigation.NavToProfile -> onFragmentTransaction(
                profileFragment,
                fragmentNavigation.fragmentId,
                fragmentNavigation.backStack
            )
        }
    }
}