fun main() {
    convertImage("/SpriteTest.png")
}

fun convertImage(path: String) {
    val imageTools = ImageTools()
    val image = imageTools.loadImage(path)
    imageTools.writeImage("./converted/$path", image)
}




fun findBackgroundColor() {

}

fun createSilhouettes() {

}

fun determineBoundingBoxes() {

}

fun calculateGrid() {

}

fun redistributeSprites() {

}


