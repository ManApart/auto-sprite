import java.awt.Color

class Pixel(val x: Int = 0, val y: Int = 0, color: Int = 0) {
    val color = Color(color, true)
//    val color = Color(color)

    override fun toString(): String {
        return "($x,$y) (${color.red}, ${color.green}, ${color.blue}, ${color.alpha})"

    }
}
