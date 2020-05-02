import javafx.scene.image.Image
import javafx.scene.image.ImageView
import tornadofx.*

class MainView : View("Doggos") {
    private val controller: DogController by inject()
    private val helperList = listOf(listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8))
    private var imageUrls = controller.getImageUrls(9)
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
        for (i in 0..8) {
            imageViews[i].image = Image(imageUrls[i])
        }
    }
}