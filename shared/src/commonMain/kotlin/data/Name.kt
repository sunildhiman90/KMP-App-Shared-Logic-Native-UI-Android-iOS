package data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Name(
    @SerialName("first")
    val first: String? = null,
    @SerialName("last")
    val last: String? = null,
    @SerialName("title")
    val title: String? = null
)