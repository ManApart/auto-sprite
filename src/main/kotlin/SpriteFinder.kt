fun findSprites(image: SpriteSheet, backgroundColor: Int = 0): List<Sprite> {
    val seeds = image.pixels.values.filter { it.color != backgroundColor }.toMutableList()
    val sprites = mutableListOf<Sprite>()
    while (seeds.isNotEmpty()) {
        val sprite = findSprite(seeds.first(), image, backgroundColor)
        sprites.add(sprite)
        seeds.removeAll(sprite.pixels)
    }

    return sprites
}

private fun findSprite(seed: Pixel, image: SpriteSheet, backgroundColor: Int): Sprite {
    val open = listOf(seed).toMutableList()
    val closed = mutableListOf<Pixel>()
    val pixels = mutableListOf<Pixel>()

    while (open.isNotEmpty()) {
        val next = open.first()
        pixels.add(next)
        open.remove(next)
        closed.add(next)

        val neighbors = image.getNeighbors(next).filter { it.color != backgroundColor }.filter { !closed.contains(it) }
        open.addAll(neighbors)
    }
    return Sprite(pixels)
}
