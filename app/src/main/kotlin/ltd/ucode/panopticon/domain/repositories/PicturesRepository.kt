package ltd.ucode.panopticon.domain.repositories

import ltd.ucode.panopticon.domain.entities.Picture

interface PicturesRepository {

    suspend fun getPictures(): List<Picture>
}