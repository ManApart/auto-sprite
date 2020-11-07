import org.testng.annotations.Test
import kotlin.test.assertEquals

class SpriteFinderTest {

    @Test
    fun findSingleSprite() {
        val image = buildSpriteSheet(
            listOf(
                listOf(0, 0, 0, 0, 0),
                listOf(0, 0, 1, 0, 0),
                listOf(0, 1, 1, 1, 0),
                listOf(0, 0, 1, 0, 0)
            )
        )
        val sprites = findSprites(image, 0)

        assertEquals(1, sprites.size)
        assertEquals(5, sprites.first().pixels.size)
    }
}