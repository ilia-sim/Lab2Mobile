import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1mobile.R
import com.example.lab1mobile.ui.theme.BusinessCardTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import com.example.lab1mobile.model.Artwork
import androidx.compose.runtime.*

const val TABLET_SPEC = "spec:width=1280dp,height=800dp,dpi=240"
const val PHONE_SPEC = "spec:width=411dp,height=891dp"

val artworks = listOf(
    Artwork(
        id = 1,
        titleResId = R.string.mona_lisa,
        imageResId = R.drawable.mona_lisa,
        artistResId = R.string.mona_lisa_artist,
        yearResId = R.string.mona_lisa_year
    ),
    Artwork(
        id = 2,
        titleResId = R.string.mona_lisa,
        imageResId = R.drawable.mona_lisa,
        artistResId = R.string.mona_lisa_artist,
        yearResId = R.string.mona_lisa_year
    ),
    Artwork(
        id = 3,
        titleResId = R.string.mona_lisa,
        imageResId = R.drawable.mona_lisa,
        artistResId = R.string.mona_lisa_artist,
        yearResId = R.string.mona_lisa_year
    )
)

@Composable
fun BusinessCard() {
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val padding = dimensionResource(R.dimen.edges_padding)

            if (isLandscape) {
                LandscapeLayout(Modifier.safeContentPadding().padding(padding))
            } else {
//                PortraitLayout(Modifier.safeContentPadding().padding(padding))
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = TABLET_SPEC,
    locale = "ru",
)
@Preview(
    showBackground = true,
    showSystemUi = true,
    device = PHONE_SPEC,
    uiMode = 33,
)
@Composable
fun BusinessCardPreview() {
    val artworkIndex = remember { mutableIntStateOf(0) }

    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val padding = dimensionResource(R.dimen.edges_padding)

            if (isLandscape) {
                LandscapeLayout(
                    modifier = Modifier
                        .safeContentPadding()
                        .padding(padding)
                )
            } else {
                PortraitLayout(
                    modifier = Modifier
                        .safeContentPadding()
                        .padding(padding),
                    artworkIndex = artworkIndex
                )
            }
        }
    }
}

@Composable
fun PortraitLayout(
    modifier: Modifier = Modifier,
    artworkIndex: MutableState<Int>
) {
    val artwork = artworks[artworkIndex.value]

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        CenteredImage(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .size(dimensionResource(R.dimen.avatar_size)),
            artwork = artwork
        )
        ImageDescription(
            modifier = Modifier.fillMaxWidth(),
            artwork = artwork
        )
        BottonPanel(
            modifier = Modifier.fillMaxWidth(),
            artworkIndex = artworkIndex
        )
    }
}

@Composable
fun LandscapeLayout(modifier: Modifier = Modifier) {

}

@Composable
fun CenteredImage(
    modifier: Modifier,
    artwork: Artwork
) {
    val imageResId = artwork.imageResId
    val contentDescription = stringResource(artwork.titleResId)

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = contentDescription,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun ImageDescription(
    modifier: Modifier = Modifier,
    artwork: Artwork
) {
    val title = stringResource(artwork.titleResId)
    val artist = stringResource(artwork.artistResId)
    val year = stringResource(artwork.yearResId)

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = dimensionResource(R.dimen.big_font_size).value.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.name_color)
        )
        Spacer(Modifier.width(dimensionResource(R.dimen.spacing)))
        Text(
            text = artist + " (${year})",
            fontSize = dimensionResource(R.dimen.normal_font_size).value.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun BottonPanel(
    modifier: Modifier,
    artworkIndex: MutableState<Int>
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Button(
            onClick = {
                if (artworkIndex.value > 0)
                    artworkIndex.value--;
            }
        ) {
            Text(
                text = stringResource(R.string.prev_button)
            )
        }
        Button(
            onClick = {
                if (artworkIndex.value < artworks.size - 1)
                    artworkIndex.value++;
            }
        ) {
            Text(
                text = stringResource(R.string.next_button)
            )
        }
    }
}