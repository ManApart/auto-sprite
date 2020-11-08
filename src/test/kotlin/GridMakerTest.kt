import org.testng.annotations.Test
import kotlin.test.assertEquals

class GridMakerTest {

    @Test
    fun calculateBasicMax() {
        val sprites = listOf(
            Sprite(
                listOf(
                    Pixel(0, 0),
                    Pixel(2, 9)
                )
            ),
            Sprite(
                listOf(
                    Pixel(20, 20),
                    Pixel(24, 22)
                )
            )
        )

        val grid = calculateGrid(sprites)
        assertEquals(5, grid.width)
        assertEquals(10, grid.height)
        assertEquals(2, grid.columns)
    }

    @Test
    fun calculateTwoRows() {
        val sprite =  Sprite(
            listOf(
                Pixel(0, 0),
                Pixel(9, 4)
            )
        )
        val sprites = (0 until 8).map { sprite }
        val grid = calculateGrid(sprites)

        assertEquals(8, sprites.size)

        assertEquals(10, grid.width)
        assertEquals(5, grid.height)
        assertEquals(4, grid.columns)
    }
}