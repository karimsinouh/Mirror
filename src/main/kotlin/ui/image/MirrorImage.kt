package ui.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import network.loadImage
import org.jetbrains.skija.Image
import utils.toByteArray
import javax.imageio.ImageIO

@Composable
fun Mirror(
    source:String,
    contentDescription:String?="",
    modifier:Modifier?=Modifier.fillMaxSize(),
    contentScale: ContentScale?= ContentScale.Crop,
    loading: @Composable ()->Unit,
    error: @Composable ()->Unit
){

    val bitmap= rememberSaveable{ mutableStateOf<ImageBitmap?>(null) }
    val state= rememberSaveable{ mutableStateOf(ImageState.LOADING) }


    //fetch the image from the url
    LaunchedEffect(source){
        val bufferedImage=loadImage(source)

        if (bufferedImage==null){
            state.value=ImageState.ERROR
        }else{
            val byteArray=bufferedImage.toByteArray()
            bitmap.value= Image.makeFromEncoded(byteArray).asImageBitmap()
            state.value=ImageState.SUCCESSFULLY
        }
    }


    Box(
        modifier=modifier!!,
        contentAlignment = Alignment.Center
    ) {
        when(state.value){

            ImageState.LOADING -> loading()

            ImageState.ERROR -> error()

            ImageState.SUCCESSFULLY -> {

                //show the actual image
                Image(
                    bitmap.value!!,
                    contentDescription!!,
                    contentScale = contentScale!!
                )
            }
        }
    }

}