package ltd.ucode.panopticon.ui.models

sealed class HomeState

object Loading : HomeState()

data class Data(val values: List<PictureUiModel>) : HomeState()

object Error : HomeState()
