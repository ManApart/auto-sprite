import org.testng.annotations.Test
import kotlin.test.assertEquals

class GridMakerTest {

    @Test
    fun calculateBasicMax() {
        val sprites = listOf(
            Sprite(
                listOf(
                    Pixel(0, 0),
                    Pixel(10, 5)
                )
            ),
            Sprite(
                listOf(
                    Pixel(20, 20),
                    Pixel(22, 27)
                )
            )
        )

        val grid = calculateGrid(sprites)
        assertEquals(0, grid.x)
        assertEquals(0, grid.y)
        assertEquals(11, grid.width)
        assertEquals(8, grid.height)
    }
}