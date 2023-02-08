package online.arapov.jct

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

private val MAX_HEIGHT = 300.dp

@Composable
fun MainScreen(list: List<Image>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(list, key = { it.id }) { image ->
            AsyncImage(
                modifier = Modifier
                    .height(MAX_HEIGHT)
                    .fillMaxWidth(),
                model = image.uri,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}