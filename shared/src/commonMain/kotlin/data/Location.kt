package data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("city")
    val city: String? = null,
    @SerialName("coordinates")
    val coordinates: Coordinates? = null,
    @SerialName("country")
    val country: String? = null,
    @SerialName("state")
    val state: String? = null,
    @SerialName("street")
    val street: Street? = null,
    @SerialName("timezone")
    val timezone: Timezone? = null
)