package com.d121211021.hogwarts.ui.activities.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.d121211021.hogwarts.MyApplication
import com.d121211021.hogwarts.data.models.Characters
import com.d121211021.hogwarts.data.repository.CharactersRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class  Success(val characters: List<Characters>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val charactersRepository: CharactersRepository): ViewModel() {

    //    initial state
    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getCharacters() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = charactersRepository.getCharacters()
            mainUiState = MainUiState.Success(result.data.orEmpty())
        } catch (e: IOException) {
            mainUiState = MainUiState.Error
        }
    }

    init {
        getCharacters()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val charactersRepository = application.container.charactersRepository
                MainViewModel(charactersRepository)
            }
        }
    }
}