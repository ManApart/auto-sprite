fun buildSpriteSheet(plan: List<List<Int>>): SpriteSheet {
    val image = mutableMapOf<Pair<Int, Int>, Pixel>()
    plan.indices.forEach { y ->
        plan[y].indices.forEach { x ->
            val planType = plan[y][x]
            image[x to y] = Pixel(x, y, planType)
        }
    }
    return SpriteSheet(image)
}