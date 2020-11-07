import org.testng.annotations.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

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

    @Test
    fun findNeighbors() {
        val image = buildSpriteSheet(
            listOf(
                listOf(1, 0, 1),
                listOf(0, 1, 0),
                listOf(1, 0, 1)
            )
        )
        val neighbors = image.getNeighbors(1, 1)

        assertNotNull(neighbors.firstOrNull{it.x == 0 && it.y == 1})
        assertNotNull(neighbors.firstOrNull{it.x == 1 && it.y == 0})
        assertNotNull(neighbors.firstOrNull{it.x == 1 && it.y == 2})
        assertNotNull(neighbors.firstOrNull{it.x == 2 && it.y == 1})
    }

    @Test
    fun findNeighborsOnEdge() {
        val image = buildSpriteSheet(
            listOf(
                listOf(1, 0, 1),
                listOf(0, 1, 0),
                listOf(1, 0, 1)
            )
        )
        val neighbors = image.getNeighbors(2, 1)

        assertNotNull(neighbors.firstOrNull{it.x == 1 && it.y == 1})
        assertNotNull(neighbors.firstOrNull{it.x == 2 && it.y == 0})
        assertNotNull(neighbors.firstOrNull{it.x == 2 && it.y == 2})
    }

}


