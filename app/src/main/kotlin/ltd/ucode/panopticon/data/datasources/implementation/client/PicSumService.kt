package ltd.ucode.panopticon.data.datasources.implementation.client

import ltd.ucode.panopticon.data.models.NetworkPicture
import retrofit2.http.GET

interface PicSumService {

    @GET("/pictures")
    suspend fun fetchList(): List<NetworkPicture>
}