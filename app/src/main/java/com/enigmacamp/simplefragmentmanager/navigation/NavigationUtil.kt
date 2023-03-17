package com.enigmacamp.simplefragmentmanager.navigation

import android.os.Bundle
import com.enigmacamp.simplefragmentmanager.FragmentName

interface NavigationUtil {
    fun navigate(fragmentId: FragmentName, bundle: Bundle?)
}