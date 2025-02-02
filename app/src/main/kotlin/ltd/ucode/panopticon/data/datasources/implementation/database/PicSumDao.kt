package ltd.ucode.panopticon.data.datasources.implementation.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ltd.ucode.panopticon.data.models.PictureEntity

@Dao
interface PicSumDao {

    @Query("SELECT * FROM picture")
    fun getAll(): List<PictureEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPictures(pictures: List<PictureEntity>)

    @Query("SELECT COUNT(id) FROM picture")
    fun count(): Int

}