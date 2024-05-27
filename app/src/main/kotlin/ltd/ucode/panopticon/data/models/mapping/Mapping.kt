package ltd.ucode.panopticon.data.models.mapping

import ltd.ucode.panopticon.data.models.PictureEntity
import ltd.ucode.panopticon.domain.entities.Picture

internal fun List<Picture>.asDbEntities() = this.map { it.asDbEntity() }

internal fun Picture.asDbEntity() = PictureEntity(
    author = author,
    width = width,
    downloadUrl = downloadUrl,
    id = id,
    url = url,
    height = height
)