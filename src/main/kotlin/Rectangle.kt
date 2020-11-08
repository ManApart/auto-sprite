class Rectangle(val x: Int = 0, val y: Int = 0, val maxX: Int = 0, val maxY: Int = 0) {
    //Add one because we're counting pixels and we're 0 indexed
    val width = maxX - x + 1
    val height = maxY - y + 1


    fun toAWTRect(): java.awt.Rectangle {
        return java.awt.Rectangle(x, y, maxX - x, maxY - y)
    }
}