package es.openbank.openbank.ui.listfragment

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
class ListViewModel @Inject constructor(private val loadHero: LoadHero) : ViewModel() {

    private val _state: MutableStateFlow<ListState> = MutableStateFlow(ListState.Idle)
    val state: StateFlow<ListState>
        get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = ListState.Loading
            loadHero().fold(
                onSuccess = {
                    _state.value = ListState.Success(it)
                },
                onFailure = {
                    _state.value = ListState.Error
                }
            )
        }
    }

    sealed class ListState{
        object Idle : ListState()
        object Loading : ListState()
        object Error : ListState()
        data class Success(val heroes: List<Hero>): ListState()
    }
}