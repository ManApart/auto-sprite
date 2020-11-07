fun main() {
    convertImage("/SpriteTest.png")
}

fun convertImage(path: String) {
    val imageTools = ImageTools()
    val image = imageTools.loadImage(path)
    val backgroundColor = findBackgroundColor(image)
    image.sprites = findSprites(image, backgroundColor)

    image.replace(backgroundColor, 0)
    imageTools.writeImage("./converted/$path", image)
}


fun findBackgroundColor(image: SpriteSheet): Int {
    val pixelsByColor = image.pixels.values.groupBy { it.color }
    return pixelsByColor.entries.maxByOrNull { it.value.size }?.key ?: 0
}

fun determineBoundingBoxes() {

}

fun calculateGrid() {

}

fun redistributeSprites() {

}


