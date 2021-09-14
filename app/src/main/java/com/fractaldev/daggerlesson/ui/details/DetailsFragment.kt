package com.fractaldev.daggerlesson.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fractaldev.daggerlesson.App
import com.fractaldev.daggerlesson.databinding.FragmentDetailsBinding
import com.fractaldev.daggerlesson.di.viewmodel.details.DetailsViewModelComponent
import javax.inject.Inject

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val userId by lazy {
        arguments?.getInt(KEY_ID) ?: -1
    }

    @Inject
    lateinit var factory: DetailsViewModelComponent.Factory
    private val viewModel: DetailsViewModel by lazy {
        ViewModelProvider(
            viewModelStore,
            DetailsViewModelFactory(userId, factory)
        )[DetailsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireContext().applicationContext as App).applicationComponent
            .inject(this)
        viewModel.detailsTest()
    }

    companion object {

        private const val KEY_ID = "id"

        fun newInstance(id: Int): DetailsFragment {
            return DetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(KEY_ID, id)
                }
            }
        }
    }
}