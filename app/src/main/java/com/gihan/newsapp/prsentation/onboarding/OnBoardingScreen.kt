package com.gihan.newsapp.prsentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gihan.newsapp.prsentation.Dimens
import com.gihan.newsapp.prsentation.Dimens.pageIndicatorWidth
import com.gihan.newsapp.prsentation.OnBoardingPage
import com.gihan.newsapp.prsentation.common.NewsButton
import com.gihan.newsapp.prsentation.common.NewsTextButton
import com.gihan.newsapp.prsentation.onboarding.component.PageIndicator
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {

    Column(modifier = Modifier.fillMaxSize()) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonStates = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("back", "Next")
                    2 -> listOf("back", "GetStarted")
                    else -> listOf("", "")
                }
            }
        }
        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }
        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            val scope = rememberCoroutineScope()

            PageIndicator(
                modifier = Modifier.width(pageIndicatorWidth),
                pageSize = pages.size,
                selectPage = pagerState.currentPage
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (buttonStates.value[0].isNotEmpty()) {
                    NewsTextButton(text = buttonStates.value[0], onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                        }

                    })
                }

                NewsButton(text = buttonStates.value[1], onClick = {
                    scope.launch {
                        if (pagerState.currentPage == 3) {
                            //will go to main
                        } else {
                            pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                        }
                    }
                })

            }
        }
        Spacer(modifier = Modifier.weight(.5f))
    }
}