import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.shape.Circle
import tornadofx.*

class MainView : View("Doggos") {
    private val refreshImageView = ImageView(Image(javaClass.getResource("/refresh.png").toURI().toString()))
    private val controller: DogController by inject()
    private val helperList = listOf(listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8))
    private var imageUrls: List<String> = controller.getImageUrls(9)
    private val imageViews = List(9) { ImageView(Image(imageUrls[it])) }
    override val root = borderpane {
        addClass(Styles.myBorderPane)
        center {
            gridpane {
                for (i in 0..2) {
                    row {
                        for (j in 0..2) {
                            hbox {
                                addClass(Styles.myBoxForImages)
                                add(imageViews[helperList[i][j]].apply {
                                    fitWidth = 400.0
                                    fitHeight = 266.6
                                    onLeftClick {
                                        openInternalWindow(
                                            FullPhotoFragment(
                                                Image(imageUrls[helperList[i][j]]),
                                                imageUrls[helperList[i][j]]
                                            )
                                        )
                                    }
                                })
                            }
                        }
                    }
                }
                right {
                    vbox {
                        addClass(Styles.myBox)
                        button("", refreshImageView) {
                            shape = Circle(1.0)
                            addClass(Styles.myButton)
                            action {
                                runAsync {
                                    updateImages()
                                }
                            }
                        }
                        text("Update Doggos") {
                            style {
                                fontSize = 28.px
                                fill = c("FD913C")
                            }
                        }
                    }

                }
            }
        }
    }

    private fun updateImages() {
        imageUrls = controller.getImageUrls(9)
        for (i in 0..8) {
            imageViews[i].image = Image(imageUrls[i])
        }
    }
}
