import kotlin.math.sqrt

// TODO - increments of 8
// TODO - variable sizes
fun calculateGrid(sprites: List<Sprite>): Grid {
    val width = sprites.maxByOrNull { it.rectangle.width }?.rectangle?.width ?: 0
    val height = sprites.maxByOrNull { it.rectangle.height }?.rectangle?.height ?: 0

    val columnsPerRow = sprites.size / sqrt(sprites.size.toFloat()).toInt()

    return Grid(width, height, columnsPerRow)
}