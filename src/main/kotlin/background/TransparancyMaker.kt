package background

import ImageTools
import Pixel
import SpriteSheet
import calculateGrid
import createSpriteSheet
import findBackgroundColor
import findSprites
import java.awt.Color
import java.io.File
import java.lang.IllegalArgumentException

fun main() {
    File("./input").listFiles()!!.forEach {
        println("\nConverting ${it.name}")
        convertImage(it.path)
    }
}

fun convertImage(path: String) {
    val imageTools = ImageTools()
    val fileName = path.substring(1 + path.lastIndexOf("\\"), path.length)
    val name = fileName.substring(0, fileName.lastIndexOf("."))
    val extension = fileName.substring(fileName.lastIndexOf("."), fileName.length)
    val image = imageTools.loadImage(path)
    val backgroundColor = findBackgroundColor(image)

    val converted = image.replaceablePixelsWithAlpha(backgroundColor)
    imageTools.writeImage("./converted/$name$extension", converted)
}





