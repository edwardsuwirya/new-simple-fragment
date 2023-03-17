package com.enigmacamp.simplefragmentmanager

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.enigmacamp.simplefragmentmanager.databinding.FragmentHomeBinding
import com.enigmacamp.simplefragmentmanager.navigation.NavigationUtil


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private var name: String = ""
    private var fragmentNav: NavigationUtil? = null
    private lateinit var homeBinding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString("name") ?: ""
            Log.d("home-fragment", name)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        homeBinding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeBinding.apply {
            btnContactUs.setOnClickListener {
                fragmentNav?.navigate(FragmentName.CONTACT_US_FRAGMENT, null)
            }
            btnProfile.setOnClickListener {
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(navigation: NavigationUtil) = HomeFragment().apply {
            fragmentNav = navigation
        }

    }
}