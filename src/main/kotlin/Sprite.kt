
class Sprite(val pixels: List<Pixel>) {
    val rectangle by lazy { calcBounds()}

    override fun toString(): String {
        return "Origin(${rectangle.x}, ${rectangle.y}), pixels: ${pixels.size}"
    }

    private fun calcBounds() : Rectangle {
        val minX = pixels.minByOrNull { it.x }?.x ?: 0
        val minY = pixels.minByOrNull { it.y }?.y ?: 0
        val maxX = pixels.maxByOrNull { it.x }?.x ?: 0
        val maxY = pixels.maxByOrNull { it.y }?.y ?: 0
        return Rectangle(minX, minY, maxX, maxY)
    }

    fun moveTo(x: Int, y: Int): Sprite {
        val offsetX = x - rectangle.x
        val offsetY = y - rectangle.y

        return Sprite(this.pixels.map { Pixel(it.x + offsetX, it.y + offsetY, it.color.rgb) })
    }
}