package ltd.ucode.panopticon.data.datasources.implementation

import ltd.ucode.panopticon.data.datasources.LocalDataSource
import ltd.ucode.panopticon.data.datasources.implementation.database.PicSumDao
import ltd.ucode.panopticon.data.models.mapping.asDbEntities
import ltd.ucode.panopticon.domain.entities.Picture
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

internal class RoomDataSource(
    private val picSumDao: PicSumDao,
    private val dispatcher: CoroutineContext
) : LocalDataSource {

    override suspend fun isEmpty() = withContext(dispatcher) {
        picSumDao.count() <= 0
    }

    override suspend fun getPictures() = withContext(dispatcher) {
        picSumDao.getAll()
    }

    override suspend fun insertPictures(pictures: List<Picture>) = withContext(dispatcher) {
        picSumDao.insertPictures(pictures.asDbEntities())
    }
}


