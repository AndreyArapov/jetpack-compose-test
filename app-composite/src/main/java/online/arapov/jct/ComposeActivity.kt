package online.arapov.jct

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen(Image.LIST_IMAGES)
        }
    }
}
