package online.arapov.jct

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

private val MAX_HEIGHT = 300.dp
private val textStyle = TextStyle.Default.copy(
    color = Color.White,
    fontSize = 32.sp
)


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainScreen(list: List<Image>) {
    LazyColumn(
        modifier = Modifier
            .semantics {
                testTagsAsResourceId = true
            }
            .testTag("lazyColumn")
            .fillMaxSize()
    ) {
        items(list, key = { it.id }) { image ->
            ImageWithText(image)
        }
    }
}

@Composable
fun ImageWithText(image: Image) {
    Box(contentAlignment = Alignment.Center) {
        AsyncImage(
            model = image.uri,
            contentDescription = null,
            modifier = Modifier
                .height(MAX_HEIGHT)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BasicText(
            text = image.text,
            style = textStyle
        )
    }
}