package com.dimas.alodokter.ui.main.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.dimas.alodokter.databinding.FragmentDetailBinding
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.ext.android.inject

class DetailFragment: Fragment() {

    private val detailViewModel: DetailViewModel by inject()
    val args: DetailFragmentArgs by navArgs()
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity!=null){
            val detailAdapter = DetailAdapter()
            val index = args.id



            detailViewModel.getListDetail(index).observe(viewLifecycleOwner, { images ->
                if (images != null) {
                    detailAdapter.setData(images)
                    binding.detailViewpager.adapter = detailAdapter
                    binding.detailViewpager.currentItem = 0
                    TabLayoutMediator(binding.detailTab, binding.detailViewpager)
                    { tab, position ->}.attach()
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}