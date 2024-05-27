package ltd.ucode.panopticon.data.datasources.implementation

import ltd.ucode.panopticon.core.data.Failure
import ltd.ucode.panopticon.core.data.Success
import ltd.ucode.panopticon.data.datasources.RemoteDataSource
import ltd.ucode.panopticon.data.datasources.implementation.client.PicSumClient

internal class ServiceDataSource(private val client: PicSumClient) : RemoteDataSource {

    override suspend fun getPictures() = when (val result = client.fetchList()) {
        is Success -> result.out
        is Failure -> emptyList()
    }

}