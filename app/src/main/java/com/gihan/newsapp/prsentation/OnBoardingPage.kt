package com.gihan.newsapp.prsentation

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Resources.Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.gihan.newsapp.R
import com.gihan.newsapp.prsentation.Dimens.MediumPadding1
import com.gihan.newsapp.prsentation.Dimens.MediumPadding2
import com.gihan.newsapp.prsentation.Dimens.smallPadding1
import com.gihan.newsapp.prsentation.onboarding.Page
import com.gihan.newsapp.prsentation.onboarding.component.PageIndicator
import com.gihan.newsapp.prsentation.onboarding.pages
import com.gihan.newsapp.ui.theme.NewsAppTheme

@Composable
fun OnBoardingPage(modifier: Modifier = Modifier, page: Page) {
    Column(modifier = modifier) {
        Image(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(.6f),
            painter = painterResource(id = page.image),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(MediumPadding1)
        )
        Text(
            text = page.title, modifier = modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.SemiBold),
            color = colorResource(id = R.color.display_small),
        )
        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(smallPadding1)
        )
        Text(
            text = page.description, modifier = modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium),
        )

    }

}

@Preview
@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun onBoardingPreview() {
    NewsAppTheme() {

        OnBoardingPage(page = pages[0])

    }

}