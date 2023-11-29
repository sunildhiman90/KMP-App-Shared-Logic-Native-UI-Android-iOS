package data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Dob(
    @SerialName("age")
    val age: Int? = null,
    @SerialName("date")
    val date: String? = null
)