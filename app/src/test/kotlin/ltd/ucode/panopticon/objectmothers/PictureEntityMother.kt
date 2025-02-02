package ltd.ucode.panopticon.objectmothers

import ltd.ucode.panopticon.data.models.PictureEntity

object PictureEntityMother {

    fun create(id: Long = 1234) = PictureEntity(
        id = "$id",
        author = UnitTestUtils.randomString(),
        width = UnitTestUtils.randomInt(),
        height = UnitTestUtils.randomInt(),
        url = UnitTestUtils.randomString(),
        downloadUrl = UnitTestUtils.randomString()
    )


    fun generate(size: Int = 10) = (1..size).map { create(id = it.toLong()) }
}
