fun findSprites(image: SpriteSheet, backgroundColor: Int = 0): List<Sprite> {
    val closed = mutableListOf<Pixel>()
    val seed = image.pixels.values.firstOrNull { it.color != backgroundColor }
    val open = listOfNotNull(seed).toMutableList()

    val pixels = mutableListOf<Pixel>()

    while (open.isNotEmpty()) {
        val next = open.first()
        pixels.add(next)
        open.remove(next)
        closed.add(next)

        val neighbors = image.getNeighbors(next).filter { it.color != backgroundColor }.filter { !closed.contains(it) }
        open.addAll(neighbors)
    }

    return listOf(Sprite(pixels))
}