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

const val TABLET_SPEC = "spec:width=1280dp,height=800dp,dpi=240"
const val PHONE_SPEC = "spec:width=411dp,height=891dp"

val artworks = listOf(
    Artwork(
        id = 1,
        title = "Mona Lisa",
        imageResId = R.drawable.avatar,
        artist = "dunno",
        year = 1728
    ),
    Artwork(
        id = 2,
        title = "Starry Night",
        imageResId = R.drawable.avatar,
        artist = "dunno",
        year = 1728
    ),
    Artwork(
        id = 3,
        title = "The Scream",
        imageResId = R.drawable.avatar,
        artist = "dunno",
        year = 1728
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
                PortraitLayout(Modifier.safeContentPadding().padding(padding))
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
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val padding = dimensionResource(R.dimen.edges_padding)

            if (isLandscape) {
                LandscapeLayout(Modifier
                    .safeContentPadding()
                    .padding(padding)
                )
            } else {
                PortraitLayout(Modifier
                    .safeContentPadding()
                    .padding(padding)
                )
            }
        }
    }
}

@Composable
fun PortraitLayout(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        CenteredImage(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .fillMaxWidth(),
//                .size(dimensionResource(R.dimen.avatar_size)),
            imageResId = R.drawable.avatar,
            contentDescription = "smth"
        )
        ImageDescription(
            modifier = Modifier.fillMaxWidth()
        )
        BottonPanel(
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun LandscapeLayout(modifier: Modifier = Modifier) {

}

@Composable
fun CenteredImage(
    modifier: Modifier,
    imageResId: Int,
    contentDescription: String?
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = contentDescription
        )
    }
}

@Composable
fun ImageDescription(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.person_name),
            fontSize = dimensionResource(R.dimen.big_font_size).value.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.name_color)
        )
        Spacer(Modifier.width(dimensionResource(R.dimen.spacing)))
        Text(
            text = stringResource(R.string.person_info),
            fontSize = dimensionResource(R.dimen.normal_font_size).value.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun BottonPanel(
    modifier: Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Button(
            onClick = { /* Handle button click */ }
        ) {
            Text(
                text = "Предыдущее"
            )
        }
        Button(
            onClick = { /* Handle button click */ }
        ) {
            Text(
                text = "Следующее"
            )
        }
    }
}