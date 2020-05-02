import javafx.scene.image.Image
import javafx.scene.image.ImageView
import tornadofx.*

class MainView : View("Doggos") {
    private val controller: DogController by inject()
    private val helperList = listOf(listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8))
    private var imageUrls = controller.getImageUrls(9)
    private var images = List(9) { Image(imageUrls[it]) }
    private val imageViews = List(9) { ImageView(images[it]) }
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
                                    fitWidth = 450.0
                                    fitHeight = 300.0
                                    onLeftClick {
                                        openInternalWindow(
                                            FullPhotoFragment(
                                                images[helperList[i][j]],
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
                    hbox {
                        addClass(Styles.myBox)
                        button("update Doggos") {
                            addClass(Styles.myButton)
                            action {
                                runAsync {
                                    updateImages()
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun updateImages() {
        imageUrls = controller.getImageUrls(9)
        images = List(9) { Image(imageUrls[it]) }
        for (i in 0..8) {
            imageViews[i].image = images[i]
        }
    }
}