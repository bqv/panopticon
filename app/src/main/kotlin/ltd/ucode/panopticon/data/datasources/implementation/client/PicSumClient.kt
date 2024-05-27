package ltd.ucode.panopticon.data.datasources.implementation.client

import ltd.ucode.panopticon.core.data.Result
import ltd.ucode.panopticon.data.models.NetworkPicture

class PicSumClient(private val service: PicSumService) {

    suspend fun fetchList(): Result<List<NetworkPicture>> = try {
        Result.success(service.fetchList())
    } catch (exception: Throwable) {
        Result.failure(ServiceError(exception.message.orEmpty()))
    }
}