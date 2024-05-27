package ltd.ucode.panopticon.data.datasources

import ltd.ucode.panopticon.domain.entities.Picture

interface LocalDataSource {

    suspend fun isEmpty(): Boolean

    suspend fun getPictures(): List<Picture>

    suspend fun insertPictures(pictures: List<Picture>)
}