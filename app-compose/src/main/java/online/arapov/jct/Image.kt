package online.arapov.jct

import android.net.Uri
import androidx.compose.runtime.Stable

@Stable
data class Image(
    val id: Int,
    val uri: Uri
) {

    companion object {
        private val uriList = listOf<Uri>(
            Uri.parse("file:///android_asset/1.jpg"),
            Uri.parse("file:///android_asset/2.jpg"),
            Uri.parse("file:///android_asset/3.jpg"),
            Uri.parse("file:///android_asset/4.jpg"),
            Uri.parse("file:///android_asset/5.jpg"),
        )

        val LIST_IMAGES = List(100) {
            Image(it, uriList.random())
        }
    }
}
