fun findSprites(image: SpriteSheet, backgroundColor: Int = 0, minPixels: Int = 1, minAlpha: Int = 255): List<Sprite> {
    val seeds = image.pixels.values.filter { it.color.rgb != backgroundColor }.toMutableList()
    val sprites = mutableListOf<Sprite>()
    while (seeds.isNotEmpty()) {
        val sprite = findSprite(seeds.first(), image, backgroundColor, minAlpha)
        sprites.add(sprite)
        seeds.removeAll(sprite.pixels)
    }

    return sprites.filter { it.pixels.size >= minPixels }
}

private fun findSprite(seed: Pixel, image: SpriteSheet, backgroundColor: Int, minAlpha: Int): Sprite {
    val open = listOf(seed).toMutableList()
    val closed = mutableListOf<Pixel>()
    val pixels = mutableListOf<Pixel>()

    while (open.isNotEmpty()) {
        val next = open.first()
        pixels.add(next)
        open.remove(next)
        closed.add(next)

        val neighbors = image.getNeighbors(next)
            .filter { it.color.rgb != backgroundColor }
            .filter { it.color.alpha >= minAlpha }
            .filter { !closed.contains(it) }
            .filter { !open.contains(it) }
        open.addAll(neighbors)
    }
    return Sprite(pixels)
}
