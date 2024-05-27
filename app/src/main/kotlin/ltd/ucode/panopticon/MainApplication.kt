package ltd.ucode.panopticon

import android.app.Application
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import ltd.ucode.panopticon.di.AppConfiguration
import ltd.ucode.panopticon.ui.theme.AndroidarchtemplateTheme

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppConfiguration.init(app = this)
    }
}

@Composable
fun PicturesApplication(content: @Composable () -> Unit) {
    AndroidarchtemplateTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}