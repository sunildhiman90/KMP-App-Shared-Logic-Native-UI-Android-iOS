package data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomUserApiResponse(
    @SerialName("results")
    val results: List<RandomUser> = emptyList()
)