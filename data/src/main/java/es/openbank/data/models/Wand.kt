package es.openbank.data.models

import com.google.gson.annotations.SerializedName
import es.openbank.domain.model.Wand

class WandDto (
    @SerializedName("wood")
    var wood   : String? = null,
    @SerializedName("core")
    var core   : String? = null,
    @SerializedName("length")
    var distance : Float? = null
)

fun WandDto.toDomain() =
    Wand(
        wood = wood ?: "",
        core = core ?: "",
        distance = distance ?: 0f
    )