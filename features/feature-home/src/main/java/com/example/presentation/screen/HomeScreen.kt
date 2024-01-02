package com.example.presentation.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.coerceAtMost
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ui_component.CircleShapeClickableIcon
import com.example.ui_component.HorizontalSpacer
import com.example.ui_component.InfoItem
import com.example.ui_component.R
import com.example.ui_component.TopAppBar
import com.example.ui_component.VerticalSpacer
import com.example.ui_component.bigFont
import com.example.ui_component.darkGray
import com.example.ui_component.grayText
import com.example.ui_component.horizontalGradation
import com.example.ui_component.hugeFont
import com.example.ui_component.infoRow
import com.example.ui_component.largeIcon
import com.example.ui_component.mainTheme
import com.example.ui_component.mediumIcon
import com.example.ui_component.profileInfoButton
import com.example.ui_component.smallFont
import com.example.ui_component.tinyFont
import com.example.ui_component.verticalGradation
import com.example.ui_component.veryBigFont

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    val scrollState = rememberScrollState()
    val currentSchedule = remember {
        mutableStateListOf<Int?>()
    }
    BoxWithConstraints(
        Modifier
            .background(mainTheme)
            .fillMaxSize()
    ) {
        val height = remember { maxHeight }
        val width = remember { maxWidth }
        Log.e("size", "$height , $width")
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Column(Modifier.padding(20.dp)) {
                TopAppBar(
                    title = "마이페이지",
                    actionIcon = Icons.Default.Menu,
                    onBack = { navHostController.popBackStack() },
                    onAction = { Log.e("MyPage", "show menu") })
                Spacer(
                    modifier = Modifier.height(
                        (height / 20).coerceAtLeast(30.dp).coerceAtMost(60.dp)
                    )
                )
                ProfileView(height, width)
                Spacer(
                    modifier = Modifier.height(
                        (height / 20).coerceAtLeast(30.dp).coerceAtMost(60.dp)
                    )
                )
                MyInfoView(height)
                VerticalSpacer(value = 20)
            }
            ScheduleView(currentSchedule, width)
        }
    }
}

@Composable
fun ScheduleView(currentSchedule: SnapshotStateList<Int?>, width: Dp) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf("일정")

    Column(
        modifier = Modifier
            .height(400.dp)
            .fillMaxWidth()
    ) {
        ScrollableTabRow(
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 20.dp),
            edgePadding = 0.dp,
            selectedTabIndex = selectedTabIndex,
            indicator = { tabPositions ->

            },
            divider = {
                Box(
                    Modifier
                        .height(7.dp)
                        .background(horizontalGradation)
                ) {

                }
            },
            containerColor = mainTheme
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            text = title,
                            color = Color.White,
                            fontSize = smallFont,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    }
                )
            }
        }

        // Content for each tab
        when (selectedTabIndex) {
            0 -> {
                if (currentSchedule.isEmpty()) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(darkGray)
                                .height(1.dp)
                        )
                        Column(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .wrapContentSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "예정된 일정이 없습니다. \n 지금 일정을 만들어 보세요!",
                                textAlign = TextAlign.Center,
                                color = darkGray,
                                fontWeight = FontWeight.Bold
                            )
                            VerticalSpacer(value = 14)
                            Box(
                                modifier = Modifier
                                    .clickable {

                                    }
                            ) {
                                Row(
                                    Modifier
                                        .clip(
                                            RoundedCornerShape(30.dp)
                                        )
                                        .width(width / 2)
                                        .background(Color.White)
                                        .padding(8.dp)
                                        .align(Alignment.Center),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceEvenly
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.DateRange,
                                        contentDescription = ""
                                    )
                                    Text(text = "일정 생성", fontWeight = FontWeight.Bold)
                                    Icon(
                                        imageVector = Icons.Default.KeyboardArrowRight,
                                        contentDescription = ""
                                    )
                                }
                            }
                        }
                    }
                } else {

                }
            }
        }
    }
}

@Composable
@Preview
fun ScheduleViewPreview() {
    ScheduleView(SnapshotStateList(), 360.dp)
}


@Composable
fun MyInfoView(height: Dp) {
    Row(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .height((height / 10).coerceAtLeast(80.dp))
            .background(infoRow),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        InfoItem(title = "나이", content = "25")
        VerticalLine()
        InfoItem(title = "게임 수", content = "70")
        VerticalLine()
        InfoItem(title = "골 수", content = "35")
        VerticalLine()
        InfoItem(title = "주 포메이션", content = "NF")
        VerticalLine()
        InfoItem(title = "주발", content = "L")
    }
}

@Composable
fun VerticalLine() {
    Box(
        Modifier
            .fillMaxHeight()
            .padding(vertical = 16.dp)
            .width(1.dp)
            .background(grayText)
    )
}

@Composable
fun ProfileView(height: Dp, width: Dp) {
    Column(
        modifier = Modifier
            .height(
                (height / 3)
                    .coerceAtLeast(150.dp)
                    .coerceAtMost(200.dp)
            )
            .fillMaxWidth()
    ) {
        Row(Modifier) {
            ProfileInfo(
                Modifier
                    .weight(1f)
                    .fillMaxSize(),
                height, width
            )
            ProfileImage(
                Modifier
                    .weight(1f)
                    .fillMaxSize(),
                height, width
            )
        }
    }
}

@Composable
fun ProfileImage(modifier: Modifier = Modifier, height: Dp, width: Dp) {
    Box(modifier) {
        Box(
            modifier = Modifier
                .size(
                    (260.dp)
                        .coerceAtMost(width / 2 - 20.dp)
                )
                .clip(CircleShape)
                .background(verticalGradation)
                .align(Alignment.BottomEnd)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(3.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = R.drawable.default_profile_image),
                contentDescription = "profileImage"
            )
        }
    }
}

@Composable
fun ProfileInfo(modifier: Modifier = Modifier, height: Dp, width: Dp) {
    Column(modifier) {
        CircleShapeClickableIcon(
            size = if (height > 500.dp) largeIcon else mediumIcon,
            background = profileInfoButton,
            icon = R.drawable.league_icon
        ) {

        }
        Spacer(modifier = Modifier.height(10.dp))
        CircleShapeClickableIcon(
            size = if (height > 500.dp) largeIcon else mediumIcon,
            background = profileInfoButton,
            icon = R.drawable.league_icon
        ) {

        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(if (height > 500.dp) largeIcon else mediumIcon),
                painter = painterResource(id = R.drawable.cloth_icon),
                contentDescription = "cloth"
            )
            HorizontalSpacer(value = 10)
            Text(text = "07", fontSize = bigFont, style = TextStyle(color = Color.White))
        }
        VerticalSpacer(value = 10)
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "홍길동",
                fontSize = if (width > 390.dp) hugeFont else veryBigFont,
                style = TextStyle(color = Color.White)
            )
            HorizontalSpacer(value = 10)
            Text(
                text = "님의 페이지",
                fontSize = if (width > 390.dp) smallFont else tinyFont,
                style = TextStyle(color = Color.White)
            )
        }
    }
}

@Composable
@Preview
fun ProfileViewPreview() {
    ProfileView(300.dp, 200.dp)
}

@Composable
@Preview
fun ProfileInfoPreview() {
    ProfileInfo(modifier = Modifier.height(300.dp), 530.dp, 350.dp)
}

@Composable
@Preview
fun ProfileImagePreview() {
    ProfileImage(modifier = Modifier.height(300.dp), 530.dp, 350.dp)
}


@Composable
@Preview
fun MainHomeScreenPreview() {
    HomeScreen(navHostController = rememberNavController())
}