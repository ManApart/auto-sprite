import org.testng.annotations.Test
import kotlin.test.assertEquals

class SpriteSheetTest {

    @Test
    fun findBackgroundColorSolidColor() {
        val image = buildSpriteSheet(
            listOf(
                listOf(0, 0, 0),
                listOf(0, 0, 0)
            )
        )

        assertEquals(0, findBackgroundColor(image))
    }

    @Test
    fun findBackgroundColorTwoColors() {
        val image = buildSpriteSheet(
            listOf(
                listOf(1, 1, 1),
                listOf(1, 0, 0)
            )
        )

        assertEquals(1, findBackgroundColor(image))
    }

}


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