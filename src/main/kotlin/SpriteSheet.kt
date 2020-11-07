class SpriteSheet(val pixels: Map<Pair<Int, Int>, Pixel>) {
    val width by lazy { (pixels.keys.maxByOrNull { it.first }?.first ?: -1) + 1 }
    val height by lazy { (pixels.keys.maxByOrNull { it.second }?.second ?: -1) + 1 }

    fun replace(color: Int, replacement: Int){
        pixels.values.filter { it.color == color }.forEach { it.color = replacement }
    }

}