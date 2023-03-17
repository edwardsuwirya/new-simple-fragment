package com.enigmacamp.simplefragmentmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.enigmacamp.simplefragmentmanager.navigation.NavigationUtilImpl

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fm = NavigationUtilImpl(supportFragmentManager)
        fm.navigate(FragmentName.LOGIN_FRAGMENT, null)
    }
}