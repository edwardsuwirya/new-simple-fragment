package com.enigmacamp.simplefragmentmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.enigmacamp.simplefragmentmanager.navigation.FragmentName
import com.enigmacamp.simplefragmentmanager.navigation.FragmentNavigation
import com.enigmacamp.simplefragmentmanager.navigation.NavigationUtilImpl

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fm = NavigationUtilImpl(supportFragmentManager)
        fm.navigate(FragmentNavigation.NavToLogin)
    }
}