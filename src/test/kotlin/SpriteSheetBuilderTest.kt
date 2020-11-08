import org.testng.annotations.Test
import kotlin.test.assertEquals

class SpriteSheetBuilderTest {

    @Test
    fun spritesAreCollapsedOntoAHorizontalGrid() {
        val sprites = listOf(
            Sprite(
                listOf(
                    Pixel(0, 0, 1),
                    Pixel(7, 15, 1)
                )
            ),
            Sprite(
                listOf(
                    Pixel(31, 0, 1),
                    Pixel(39, 15, 1)
                )
            )
        )

        val image = createSpriteSheet(Grid(8, 16, 10), sprites)

        assertEquals(1, image.pixels[0 to 0]?.color?.rgb)
        assertEquals(1, image.pixels[7 to 15]?.color?.rgb)
        assertEquals(1, image.pixels[8 to 0]?.color?.rgb)
        assertEquals(1, image.pixels[16 to 15]?.color?.rgb)

    }

    @Test
    fun spriteSheetsOnTwoRows() {
        val sprites = listOf(
            Sprite(
                listOf(
                    Pixel(0, 0, 1),
                    Pixel(7, 15, 1)
                )
            ),
            Sprite(
                listOf(
                    Pixel(31, 0, 1),
                    Pixel(39, 15, 1)
                )
            )
        )

        val image = createSpriteSheet(Grid(8, 16, 1), sprites)

        assertEquals(1, image.pixels[0 to 0]?.color?.rgb)
        assertEquals(1, image.pixels[7 to 15]?.color?.rgb)
        assertEquals(1, image.pixels[0 to 16]?.color?.rgb)
        assertEquals(1, image.pixels[8 to 31]?.color?.rgb)

    }

    @Test
    fun spritesAlignedToBottomNotTop() {
        val sprites = listOf(
            Sprite(
                listOf(
                    Pixel(0, 0, 1),
                    Pixel(7, 10, 1)
                )
            ),
            Sprite(
                listOf(
                    Pixel(31, 0, 1),
                    Pixel(39, 15, 1)
                )
            )
        )

        val image = createSpriteSheet(Grid(8, 16, 10), sprites)

        assertEquals(1, image.pixels[0 to 5]?.color?.rgb)
        assertEquals(1, image.pixels[7 to 15]?.color?.rgb)
        assertEquals(1, image.pixels[8 to 0]?.color?.rgb)
        assertEquals(1, image.pixels[16 to 15]?.color?.rgb)

    }

}