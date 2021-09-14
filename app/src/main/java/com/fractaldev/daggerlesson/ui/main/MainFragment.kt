package com.fractaldev.daggerlesson.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fractaldev.daggerlesson.R
import com.fractaldev.daggerlesson.databinding.FragmentMainBinding
import com.fractaldev.daggerlesson.ui.details.DetailsFragment
import kotlin.random.Random

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.test()
        viewModel.users.observe(viewLifecycleOwner) {
            println("test___ users: ${it.size}")
        }
        binding.buttonNext.setOnClickListener {
            val userId = Random.nextInt()
            println("test___ generated id: $userId")
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, DetailsFragment.newInstance(userId))
                .addToBackStack(null)
                .commit()
        }
    }

}