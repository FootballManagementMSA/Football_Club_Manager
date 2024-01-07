package com.example.feature_makeclub.presentation.ui_component.emblem

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.feature_makeclub.presentation.viewmodel.MakeClubViewModel
import com.example.ui_component.R

@Composable
fun EmblemSelectIconView(viewModel: MakeClubViewModel = hiltViewModel()) {
    val selectedImageUri = viewModel.selectedImageUri.collectAsState()
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            viewModel.updateSelectedImageUri(uri)
        }
    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(100.dp)
            .clickable {
                singlePhotoPickerLauncher.launch(
                    PickVisualMediaRequest(
                        ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                )
            }
    )
    {
        if (selectedImageUri.value == null) {
            Image(
                painter = painterResource(id = R.drawable.check_icon),
                contentDescription = "CheckIcon",
                modifier = Modifier.size(100.dp)
            )
        } else {
            AsyncImage(
                model = selectedImageUri.value,
                contentDescription = null,
                placeholder = painterResource(R.drawable.back_icon),
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }
}
@Preview
@Composable
fun EmblemSelectIconViewPreview() {
    EmblemSelectIconView()
}