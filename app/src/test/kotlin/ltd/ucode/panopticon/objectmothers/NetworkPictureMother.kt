package ltd.ucode.panopticon.objectmothers

import ltd.ucode.panopticon.data.models.NetworkPicture

object NetworkPictureMother {

    fun pictures() = (1..10).map { NetworkPicture(id = it.toString()) }
}
