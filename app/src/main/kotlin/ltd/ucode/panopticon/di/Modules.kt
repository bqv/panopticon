package ltd.ucode.panopticon.di

import ltd.ucode.panopticon.core.data.service
import ltd.ucode.panopticon.data.datasources.LocalDataSource
import ltd.ucode.panopticon.data.datasources.RemoteDataSource
import ltd.ucode.panopticon.data.datasources.implementation.RoomDataSource
import ltd.ucode.panopticon.data.datasources.implementation.ServiceDataSource
import ltd.ucode.panopticon.data.datasources.implementation.client.PicSumClient
import ltd.ucode.panopticon.data.datasources.implementation.client.PicSumService
import ltd.ucode.panopticon.data.datasources.implementation.database.PicSumDataBase
import ltd.ucode.panopticon.data.repositories.PicSumRepository
import ltd.ucode.panopticon.domain.repositories.PicturesRepository
import ltd.ucode.panopticon.domain.usecases.GetPictures
import ltd.ucode.panopticon.ui.viewmodels.HomeViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * presentation layer definition module
 */
private val presentationModule = module {
    viewModel { HomeViewModel(getPictures = get<GetPictures>()) }
}


/**
 * domain layer definition module
 */
private val domainModule = module {
    factory { GetPictures(repository = get<PicturesRepository>()) }
}

/**
 * data layer definition module
 */
private val dataModule = module {

    single<PicSumService> { service("https://pictures.getsandbox.com:443") }

    single<PicSumClient> { PicSumClient(get<PicSumService>()) }

    factory<RemoteDataSource> { ServiceDataSource(client = get<PicSumClient>()) }

    factory<LocalDataSource> {
        RoomDataSource(
            picSumDao = PicSumDataBase.create(
                androidApplication()
            ).picSumDao(),
            dispatcher = Dispatchers.IO
        )
    }

    factory<PicturesRepository> {
        PicSumRepository(
            localDataSource = get<LocalDataSource>(),
            remoteDataSource = get<RemoteDataSource>()
        )
    }

}


internal val modules = listOf(
    presentationModule,
    domainModule,
    dataModule,
)
