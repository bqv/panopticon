package ltd.ucode.panopticon.data.datasources

import ltd.ucode.panopticon.domain.entities.Picture

interface RemoteDataSource {

    suspend fun getPictures(): List<Picture>
}