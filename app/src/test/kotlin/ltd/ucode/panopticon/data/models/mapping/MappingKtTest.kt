package ltd.ucode.panopticon.data.models.mapping


import ltd.ucode.panopticon.data.models.PictureEntity
import ltd.ucode.panopticon.objectmothers.PictureEntityMother
import ltd.ucode.panopticon.objectmothers.PictureMother
import ltd.ucode.panopticon.domain.entities.Picture
import org.hamcrest.core.IsEqual
import org.junit.Assert.assertThat
import org.junit.Test

class MappingKtTest {

    @Test
    fun asDbEntities() {
        val pictures = PictureMother.generate(size = 2)
        val entities = pictures.map { convertPictureToEntity(it) }
        val result = pictures.asDbEntities()
        assertThat(result, IsEqual(entities))
    }

    @Test
    fun asDbEntity() {
        val picture = PictureEntityMother.create()
        val entity = convertPictureToEntity(picture)
        val result = picture.asDbEntity()
        assertThat(result, IsEqual(entity))
    }

    private fun convertPictureToEntity(picture: Picture) =
        PictureEntity(
            id = picture.id,
            author = picture.author,
            width = picture.width,
            height = picture.height,
            url = picture.url,
            downloadUrl = picture.downloadUrl
        )
}
