import java.awt.Color
import java.awt.Graphics2D
import java.awt.Rectangle
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO


class ImageTools {
    fun loadImage(path: String): SpriteSheet {
        val bufferedImage = ImageIO.read(this::class.java.getResourceAsStream(path))
        val image = mutableMapOf<Pair<Int, Int>, Pixel>()

        for (x in 0 until bufferedImage.width) {
            for (y in 0 until bufferedImage.height) {
                image[x to y] = Pixel(x, y, bufferedImage.getRGB(x, y))
            }
        }

        return SpriteSheet(image)
    }

    fun writeImage(path: String, image: SpriteSheet) {
        val bufferedImage = BufferedImage(image.width, image.height, BufferedImage.TYPE_INT_ARGB);
        image.pixels.values.forEach {
            bufferedImage.setRGB(it.x, it.y, it.color)
        }
        ImageIO.write(bufferedImage, "png", File(path))
    }

    fun writeBoundingBoxes(path: String, sprites: List<Sprite>, width: Int, height: Int) {
        val bufferedImage = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        val graph: Graphics2D = bufferedImage.createGraphics()
        graph.color = Color.BLACK
        graph.fill(Rectangle(0, 0, width, height))
        graph.color = Color.white

        sprites.forEach {
            graph.fill(it.rectangle)
        }

        graph.dispose()
        ImageIO.write(bufferedImage, "png", File(path))
    }
}