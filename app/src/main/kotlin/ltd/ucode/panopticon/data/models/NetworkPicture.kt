package ltd.ucode.panopticon.data.models

import com.google.gson.annotations.SerializedName
import ltd.ucode.panopticon.domain.entities.Picture

data class NetworkPicture(
    @SerializedName("author") override val author: String = "",
    @SerializedName("width") override val width: Int = 0,
    @SerializedName("download_url") override val downloadUrl: String = "",
    @SerializedName("id") override val id: String = "",
    @SerializedName("url") override val url: String = "",
    @SerializedName("height") override val height: Int = 0
) : Picture