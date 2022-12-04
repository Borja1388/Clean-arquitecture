package es.openbank.openbank.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import es.openbank.openbank.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            viewModel.state.collect{

                binding.name.text = when(it){
                    MainViewModel.MainState.Error -> "Error"
                    MainViewModel.MainState.Idle -> "Idle"
                    MainViewModel.MainState.Loading -> "Loading"
                    is MainViewModel.MainState.Success ->  it.heroes.firstOrNull()?.name ?: "Empty list"
                }
            }
        }
    }
}