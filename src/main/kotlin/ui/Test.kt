package ui

import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.error.MirrorDefaultError
import ui.image.Mirror
import ui.placeholder.MirrorDefaultPlaceholder

fun main()= Window {

    Box (contentAlignment = Alignment.Center,modifier = Modifier.fillMaxSize()){
        Mirror(
            "https://i1.sndcdn.comavatars-cUl8H1mQmakaKjf3-e1uOdQ-t500x500.jpg",
            loading = { MirrorDefaultPlaceholder()},
            error = { MirrorDefaultError() },
            modifier = Modifier.width(300.dp).height(300.dp)
        )
    }

}