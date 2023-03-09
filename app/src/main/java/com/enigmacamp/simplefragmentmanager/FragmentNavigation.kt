package com.enigmacamp.simplefragmentmanager

import android.os.Bundle

interface FragmentNavigation {
    fun navigate(fragmentId: FragmentName, bundle: Bundle?)
}