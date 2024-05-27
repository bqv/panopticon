package ltd.ucode.panopticon.objectmothers

import ltd.ucode.panopticon.domain.entities.Picture

data class TestPicture(
    override val author: String,
    override val width: Int,
    override val downloadUrl: String,
    override val id: String,
    override val url: String,
    override val height: Int
) : Picture
