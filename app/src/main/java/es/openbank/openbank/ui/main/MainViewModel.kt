package es.openbank.openbank.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.openbank.domain.model.Hero
import es.openbank.usecases.LoadHero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val loadHero: LoadHero) : ViewModel() {

    private val _state: MutableStateFlow<MainState> = MutableStateFlow(MainState.Idle)
    val state: StateFlow<MainState>
        get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = MainState.Loading
             loadHero().fold(
                 onSuccess = {
                     _state.value = MainState.Success(it)
                 },
                 onFailure = {
                     _state.value = MainState.Error
                 }
             )
        }
    }

    sealed class MainState{
        object Idle : MainState()
        object Loading : MainState()
        object Error : MainState()
        data class Success(val heroes: List<Hero>): MainState()
    }
}