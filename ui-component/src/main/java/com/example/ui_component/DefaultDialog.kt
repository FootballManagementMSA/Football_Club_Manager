package com.example.ui_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.ui_component.values.bigFont
import com.example.ui_component.values.smallFont

@Composable
fun DefaultDialog(title: String, userName: String, content: @Composable () -> Unit) {
    val config = LocalConfiguration.current
    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false),
    ) {
        Surface(
            modifier = Modifier
                .padding(16.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(20.dp)
                    .heightIn(min = 270.dp)
                    .height(config.screenHeightDp.dp / 3)
            ) {
                DialogTopView(title = title)
                Spacer(modifier = Modifier.weight(1f))
                DialogProfileView(userName = userName)
                Spacer(modifier = Modifier.weight(1f))
                content()
            }
        }
    }
}

@Composable
private fun DialogTopView(modifier: Modifier = Modifier, title: String) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title, fontSize = smallFont, fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.Default.Close, contentDescription = null)
    }
    VerticalSpacer(value = 10)
}

@Composable
private fun DialogProfileView(modifier: Modifier = Modifier, userName: String) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.default_profile_image),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        HorizontalSpacer(value = 10)
        Text(text = userName, fontSize = bigFont, fontWeight = FontWeight.Bold)
        HorizontalSpacer(value = 4)
        Text(text = "님")
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null
        )
    }
    VerticalSpacer(value = 10)
}
@Preview
@Composable
fun DefaultDialogPreview() {
    DefaultDialog("구단 가입 신청입니다.", "임성우") {}
}