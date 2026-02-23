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
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Spacer(Modifier.height(0.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Avatar(Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer)
                .size(dimensionResource(R.dimen.avatar_size)))
            Spacer(Modifier.height(dimensionResource(R.dimen.spacing)))
            Name()
        }
        Contacts()
    }
}

@Composable
fun LandscapeLayout(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Spacer(Modifier.width(0.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Avatar(Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primaryContainer)
                .size(dimensionResource(R.dimen.avatar_size)))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Name()
        }
        Contacts()
    }
}

@Composable
fun Avatar(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.avatar),
        contentDescription = stringResource(R.string.avatar_description),
    )
}

@Composable
fun Name(modifier: Modifier = Modifier) {
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
fun Contacts(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom,
    ) {
        val spacing = dimensionResource(R.dimen.spacing)
        val fontSize = dimensionResource(R.dimen.normal_font_size).value.sp

        Text(
            text = stringResource(R.string.contacts),
            fontSize = fontSize,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.contact_color)
        )
        Spacer(Modifier.height(spacing))
        Contact(
            icon = Icons.Default.Email,
            description = stringResource(R.string.email_description),
            text = stringResource(R.string.email),
        )
        Spacer(Modifier.height(spacing))
        Contact(
            icon = Icons.Default.Phone,
            text = stringResource(R.string.phone_number),
            description = stringResource(R.string.phone_number_description),
        )
        Spacer(Modifier.height(spacing))
        Contact(
            icon = Icons.Default.AccountCircle,
            text = stringResource(R.string.telegram_username),
            description = stringResource(R.string.telegram_username_description),
        )
    }
}

@Composable
fun Contact(
    icon: ImageVector,
    description: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = description,
        )
        Spacer(Modifier.width(dimensionResource(R.dimen.spacing)))
        Text(
            text = text,
            fontSize = dimensionResource(R.dimen.normal_font_size).value.sp,
        )
    }
}