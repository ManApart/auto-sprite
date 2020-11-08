fun createSpriteSheet(grid: Grid, sprites: List<Sprite>): SpriteSheet {
    var originX = -grid.width
    var originY = 0
    var column = 0

    val newSprites = sprites
        .sortedWith(compareBy({ it.pixels.first().y }, { it.pixels.first().x }))
        .map { sprite ->
            if (column >= grid.columns) {
                column = 0
                originX = -grid.width
                originY += grid.height
            }
            column += 1
            originX += grid.width

            val yOffset = grid.height - sprite.rectangle.height
            sprite.moveTo(originX, originY + yOffset)
        }

    return SpriteSheet(newSprites)
}