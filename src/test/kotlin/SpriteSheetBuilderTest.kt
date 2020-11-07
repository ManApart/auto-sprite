import org.testng.annotations.Test
import java.awt.Rectangle
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

        val image = createSpriteSheet(Rectangle(0, 0, 8, 16), sprites)

        assertEquals(1, image.pixels[0 to 0]?.color)
        assertEquals(1, image.pixels[7 to 15]?.color)
        assertEquals(1, image.pixels[8 to 0]?.color)
        assertEquals(1, image.pixels[16 to 15]?.color)

    }

}