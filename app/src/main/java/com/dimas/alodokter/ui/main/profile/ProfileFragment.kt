package com.dimas.alodokter.ui.main.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dimas.alodokter.core.data.SessionManager
import com.dimas.alodokter.databinding.FragmentProfileBinding
import com.dimas.alodokter.ui.login.LoginActivity
import org.koin.android.ext.android.inject

class ProfileFragment: Fragment() {

    private val sessionManager: SessionManager by inject()

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity!=null){

            binding.profileEmail.text = sessionManager.getEmail()

            binding.profileLogout.setOnClickListener {
                sessionManager.clearAccount()
                startActivity(Intent(requireActivity(), LoginActivity::class.java))
                requireActivity().finish()
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}