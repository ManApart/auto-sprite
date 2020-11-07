class SpriteSheet(val pixels: Map<Pair<Int, Int>, Pixel>) {
    var sprites: List<Sprite> = listOf()

    val width by lazy { (pixels.keys.maxByOrNull { it.first }?.first ?: -1) + 1 }

    val height by lazy { (pixels.keys.maxByOrNull { it.second }?.second ?: -1) + 1 }

    fun replace(color: Int, replacement: Int){
        pixels.values.filter { it.color == color }.forEach { it.color = replacement }
    }

    fun getNeighbors(source: Pixel): List<Pixel> {
        return getNeighbors(source.x, source.y)
    }

    fun getNeighbors(x: Int, y: Int): List<Pixel> {
        return listOfNotNull(
            pixels[x+1 to y],
            pixels[x-1 to y],
            pixels[x to y+1],
            pixels[x to y-1]
        )
    }

}