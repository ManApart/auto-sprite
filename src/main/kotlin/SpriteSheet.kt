class SpriteSheet(val pixels: Map<Pair<Int, Int>, Pixel>, var sprites: List<Sprite> = listOf()) {
    constructor(sprites: List<Sprite>) : this(spritesToPixels(sprites), sprites)

    val width by lazy { (pixels.keys.maxByOrNull { it.first }?.first ?: -1) + 1 }

    val height by lazy { (pixels.keys.maxByOrNull { it.second }?.second ?: -1) + 1 }

    fun replace(pixels: List<Pixel>): SpriteSheet {
        val newPixels = this.pixels.toMutableMap()

        pixels.forEach {
            newPixels[it.x to it.y] = it
        }

        return SpriteSheet(newPixels, sprites)
    }

    fun replace(color: Int, replacement: Int): SpriteSheet {
        val newPixels = pixels.entries.map {
            val newPixel = replaceColor(it.value, color, replacement)
            it.key to newPixel
        }.toMap()
        return SpriteSheet(newPixels, sprites)
    }

    private fun replaceColor(pixel: Pixel, search: Int, replacement: Int): Pixel {
        return if (pixel.color == search) {
            Pixel(pixel.x, pixel.y, replacement)
        } else {
            pixel
        }
    }

    fun getNeighbors(source: Pixel): List<Pixel> {
        return getNeighbors(source.x, source.y)
    }

    fun getNeighbors(x: Int, y: Int): List<Pixel> {
        return listOfNotNull(
            pixels[x + 1 to y],
            pixels[x - 1 to y],
            pixels[x to y + 1],
            pixels[x to y - 1]
        )
    }

}

private fun spritesToPixels(sprites: List<Sprite>): Map<Pair<Int, Int>, Pixel> {
    return sprites.flatMap {it.pixels}.associateBy { Pair(it.x, it.y) }
}