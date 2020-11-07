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

    @Test
    fun findTwoSprites() {
        val image = buildSpriteSheet(
            listOf(
                listOf(1, 1, 0, 0, 0),
                listOf(1, 0, 1, 0, 0),
                listOf(0, 1, 1, 1, 0),
                listOf(0, 0, 1, 0, 0)
            )
        )
        val sprites = findSprites(image, 0)

        assertEquals(2, sprites.size)
        assertEquals(3, sprites.first().pixels.size)
        assertEquals(5, sprites.last().pixels.size)
    }

    @Test
    fun findNoSprites() {
        val image = buildSpriteSheet(
            listOf(
                listOf(0, 0, 0, 0, 0),
                listOf(0, 0, 0, 0, 0)
            )
        )
        val sprites = findSprites(image, 0)

        assertEquals(0, sprites.size)
    }
}