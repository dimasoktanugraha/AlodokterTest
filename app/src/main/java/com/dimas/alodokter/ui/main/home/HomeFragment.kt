package com.dimas.alodokter.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.dimas.alodokter.R
import com.dimas.alodokter.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject

class HomeFragment: Fragment() {

    private val homeViewModel: HomeViewModel by inject()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity!=null){

            val homeAdapter = HomeAdapter()
            binding.homeRv.apply {
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
                adapter = homeAdapter
            }
            homeAdapter.onItemClick = { food ->
                val toDetail = HomeFragmentDirections.actionHomeFragmentToDetailFragment(food.index)
                Navigation.findNavController(binding.root).navigate(toDetail)
            }

            homeViewModel.getListImage().observe(viewLifecycleOwner, { images ->
                if (images!=null){
                    homeAdapter.setData(images)
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}