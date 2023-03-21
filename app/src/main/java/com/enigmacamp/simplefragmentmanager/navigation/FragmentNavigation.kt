package com.enigmacamp.simplefragmentmanager.navigation

import android.os.Bundle

sealed class FragmentNavigation(
    val fragmentId: String,
) {
    data class NavToHome(val bundle: Bundle? = null) :
        FragmentNavigation(FragmentName.HOME_FRAGMENT)

    object NavToLogin : FragmentNavigation(FragmentName.LOGIN_FRAGMENT)

    data class NavToContactUs(
        val bundle: Bundle? = null,
        val backStack: String? = FragmentName.HOME_FRAGMENT
    ) :
        FragmentNavigation(FragmentName.CONTACT_US_FRAGMENT)

    data class NavToProfile(
        val bundle: Bundle? = null,
        val backStack: String? = FragmentName.HOME_FRAGMENT
    ) :
        FragmentNavigation(FragmentName.PROFILE_FRAGMENT)
}
