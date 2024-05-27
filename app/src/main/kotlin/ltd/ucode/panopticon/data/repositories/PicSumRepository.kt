package ltd.ucode.panopticon.data.repositories

import ltd.ucode.panopticon.data.datasources.LocalDataSource
import ltd.ucode.panopticon.data.datasources.RemoteDataSource
import ltd.ucode.panopticon.domain.entities.Picture
import ltd.ucode.panopticon.domain.repositories.PicturesRepository

internal class PicSumRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : PicturesRepository {

    override suspend fun getPictures(): List<Picture> {
        if (localDataSource.isEmpty()) {
            val pictures = remoteDataSource.getPictures()
            localDataSource.insertPictures(pictures)
        }
        return localDataSource.getPictures()
    }

}