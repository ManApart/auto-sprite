import java.awt.Rectangle

class Sprite(val pixels: List<Pixel>) {
    val rectangle by lazy { calcBounds()}

    private fun calcBounds() : Rectangle {
        val minX = pixels.minByOrNull { it.x }?.x ?: 0
        val minY = pixels.minByOrNull { it.y }?.y ?: 0
        val maxX = pixels.maxByOrNull { it.x }?.x ?: 0
        val maxY = pixels.maxByOrNull { it.y }?.y ?: 0
        return Rectangle(minX, minY, maxX - minX, maxY - minY)
    }
}