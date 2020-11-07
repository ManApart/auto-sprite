import java.awt.Rectangle

fun createSpriteSheet(grid: Rectangle, sprites: List<Sprite>): SpriteSheet {
    var originX = 0 - grid.width
    val originY = 0

    val newSprites = sprites.map {sprite ->
        originX += grid.width
        sprite.moveTo(originX, originY)
    }

    return SpriteSheet(newSprites)
}