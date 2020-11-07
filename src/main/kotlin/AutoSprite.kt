fun main() {
    convertImage("/SpriteTest.png")
}

fun convertImage(path: String) {
    val imageTools = ImageTools()
    val image = imageTools.loadImage(path)
    val backgroundColor = findBackgroundColor(image)
    image.sprites = findSprites(image, backgroundColor)

    val transparentImage = image.replace(backgroundColor, 0)
    imageTools.writeImage("./converted/$path", transparentImage)
}


fun findBackgroundColor(image: SpriteSheet): Int {
    val pixelsByColor = image.pixels.values.groupBy { it.color }
    return pixelsByColor.entries.maxByOrNull { it.value.size }?.key ?: 0
}

fun calculateGrid() {

}

fun redistributeSprites() {

}


