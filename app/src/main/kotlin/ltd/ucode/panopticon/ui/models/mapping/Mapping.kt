package ltd.ucode.panopticon.ui.models.mapping

import ltd.ucode.panopticon.domain.entities.Picture
import ltd.ucode.panopticon.ui.models.PictureUiModel


internal fun List<Picture>.asUiModels() = map { it.asUiModel() }

internal fun Picture.asUiModel() =
    PictureUiModel(
        id = id,
        author = author,
        imageUrl = downloadUrl,
        height = height,
        width = width,
        link = url
    )