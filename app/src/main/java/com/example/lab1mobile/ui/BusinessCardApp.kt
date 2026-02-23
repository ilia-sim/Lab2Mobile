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

const val TABLET_SPEC = "spec:width=1280dp,height=800dp,dpi=240"
const val PHONE_SPEC = "spec:width=411dp,height=891dp"

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
                LandscapeLayout(Modifier.safeContentPadding().padding(padding))
            } else {
                PortraitLayout(Modifier.safeContentPadding().padding(padding))
            }
        }
    }
}

@Composable
fun PortraitLayout(modifier: Modifier = Modifier) {

}

@Composable
fun LandscapeLayout(modifier: Modifier = Modifier) {

}