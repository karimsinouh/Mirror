package ui.error

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MirrorDefaultError(){
    Box(
        modifier = Modifier.background(Color.Black.copy(alpha = 0.1f)).fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(imageVector = Icons.Outlined.Warning,contentDescription = null,tint = Color.Black.copy(alpha = 0.3f))
    }
}