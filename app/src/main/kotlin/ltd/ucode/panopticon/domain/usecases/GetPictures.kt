package ltd.ucode.panopticon.domain.usecases

import ltd.ucode.panopticon.domain.repositories.PicturesRepository

class GetPictures(private val repository: PicturesRepository) {

    suspend operator fun invoke() = repository.getPictures()
}