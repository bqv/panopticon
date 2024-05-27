package ltd.ucode.panopticon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import coil.annotation.ExperimentalCoilApi
import ltd.ucode.panopticon.core.presentation.openLink
import ltd.ucode.panopticon.ui.screen.HomeScreen

@ExperimentalCoilApi
@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PicturesApplication {
                HomeScreen {
                    openLink(it.link)
                }
            }
        }
    }
}


