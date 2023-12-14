package com.d121211021.hogwarts.data.repository

import com.d121211021.hogwarts.data.response.GetCharactersResponse
import com.d121211021.hogwarts.data.source.remote.ApiService

class CharactersRepository (private val apiService: ApiService) {

    suspend fun getCharacters(): GetCharactersResponse {
        return apiService.getCharacters()
    }
}