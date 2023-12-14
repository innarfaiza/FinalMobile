package com.d121211021.hogwarts.data.source.remote

import com.d121211021.hogwarts.data.response.GetCharactersResponse
import retrofit2.http.GET


interface ApiService {
    @GET("api/characters/students")
    suspend fun getCharacters() : GetCharactersResponse
}