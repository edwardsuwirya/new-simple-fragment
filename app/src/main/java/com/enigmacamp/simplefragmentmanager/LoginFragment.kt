package com.enigmacamp.simplefragmentmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.enigmacamp.simplefragmentmanager.databinding.FragmentLoginBinding
import com.enigmacamp.simplefragmentmanager.navigation.FragmentName
import com.enigmacamp.simplefragmentmanager.navigation.FragmentNavigation
import com.enigmacamp.simplefragmentmanager.navigation.NavigationUtil

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var loginBinding: FragmentLoginBinding
    private var fragmentNav: NavigationUtil? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBinding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return loginBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginBinding.apply {
            btnLogin.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("name", "Enigma")
                fragmentNav?.navigate(FragmentNavigation.NavToHome(bundle))
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(navigation: NavigationUtil) = LoginFragment().apply {
            fragmentNav = navigation
        }
    }
}