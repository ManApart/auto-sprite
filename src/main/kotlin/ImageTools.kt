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
}