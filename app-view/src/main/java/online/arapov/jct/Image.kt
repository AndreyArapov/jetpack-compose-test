package online.arapov.jct

import android.net.Uri
import com.github.javafaker.Faker

data class Image(
    val id: Int,
    val uri: Uri,
    val text: String
) {

    companion object {
        private val uriList = listOf<Uri>(
            Uri.parse("file:///android_asset/1.jpg"),
            Uri.parse("file:///android_asset/2.jpg"),
            Uri.parse("file:///android_asset/3.jpg"),
            Uri.parse("file:///android_asset/4.jpg"),
            Uri.parse("file:///android_asset/5.jpg"),
        )
        private val faker = Faker.instance().lebowski()
        val LIST_IMAGES = List(100) {
            Image(it, uriList.random(), faker.character())
        }
    }
}
