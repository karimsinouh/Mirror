package network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.awt.image.BufferedImage
import java.net.HttpURLConnection
import java.net.URL
import javax.imageio.ImageIO

private suspend fun loadImage(source:String): BufferedImage? = withContext(Dispatchers.IO){
    runCatching {
        val url= URL(source)
        val connection=url.openConnection() as HttpURLConnection
        connection.connectTimeout=5000
        connection.connect()

        val input=connection.inputStream
        val image= ImageIO.read(input)
        image
    }.getOrNull()
}