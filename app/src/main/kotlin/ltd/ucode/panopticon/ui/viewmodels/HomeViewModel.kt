package ltd.ucode.panopticon.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ltd.ucode.panopticon.domain.usecases.GetPictures
import ltd.ucode.panopticon.ui.models.Data
import ltd.ucode.panopticon.ui.models.Error
import ltd.ucode.panopticon.ui.models.HomeState
import ltd.ucode.panopticon.ui.models.Loading
import ltd.ucode.panopticon.ui.models.mapping.asUiModels
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class HomeViewModel(private val getPictures: GetPictures) : ViewModel() {

    private val _state = MutableLiveData<HomeState>()
    val state: LiveData<HomeState>
        get() = _state

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        _state.postValue(Error)
    }

    init {
        pictures()
    }

    private fun pictures() {
        viewModelScope.launch(exceptionHandler) {
            _state.postValue(Loading)
            val pictures = getPictures().asUiModels()
            _state.postValue(Data(values = pictures))
        }
    }

    fun retry() {
        pictures()
    }
}

