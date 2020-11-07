fun main() {
    convertImage("SpriteTest.png")
}

fun convertImage(path: String) {
    val imageTools = ImageTools()
    val image = imageTools.loadImage(path)
    val backgroundColor = findBackgroundColor(image)
    val sprites = findSprites(image, backgroundColor)

    imageTools.writeBoundingBoxes("./converted/bounding-$path", sprites, image.width, image.height)

    val grid = calculateGrid(sprites)

    val converted = createSpriteSheet(grid, sprites)
    imageTools.writeImage("./converted/$path", converted)
}

fun findBackgroundColor(image: SpriteSheet): Int {
    val pixelsByColor = image.pixels.values.groupBy { it.color }
    return pixelsByColor.entries.maxByOrNull { it.value.size }?.key ?: 0
}





