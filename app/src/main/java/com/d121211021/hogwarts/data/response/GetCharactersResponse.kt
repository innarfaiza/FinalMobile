package com.d121211021.hogwarts.data.response

import com.d121211021.hogwarts.data.models.Characters
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetCharactersResponse (
    @SerialName("data")
    val data: List<Characters>,
    @SerialName("message")
    val message: String
)