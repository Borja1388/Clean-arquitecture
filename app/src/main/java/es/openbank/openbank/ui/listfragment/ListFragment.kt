package es.openbank.openbank.ui.listfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import es.openbank.openbank.databinding.FragmentListBinding
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding: FragmentListBinding
        get() = _binding!!
    private val viewModel by viewModels<ListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.state.collect {

                binding.name.text = when (it) {
                    ListViewModel.ListState.Error -> "Error"
                    ListViewModel.ListState.Idle -> "Idle"
                    ListViewModel.ListState.Loading -> "Loading"
                    is ListViewModel.ListState.Success -> it.heroes.firstOrNull()?.name
                        ?: "Empty list"
                }
            }
        }
    }
}