import javafx.scene.image.Image
import tornadofx.*

class FullPhotoFragment(img: Image, imageUrl: String) : Fragment() {
    private val controller: DogController by inject()
    override val root = borderpane {
        addClass(Styles.myBorderPane)
        center {
            imageview(img) {
                isPreserveRatio = true
                fitHeight = 800.0
                fitWidth = 800.0
            }
        }
        right {
            vbox {
                addClass(Styles.myBox)
                hbox {
                    addClass(Styles.myBox)
                    button("Copy photo URL") {
                        addClass(Styles.myButton)
                        action {
                            controller.copyToClipboard(imageUrl)
                        }
                    }
                }
                hbox {
                    addClass(Styles.myBox)
                    button("Save") {
                        addClass(Styles.myButton)
                        action {
                            controller.saveImageToFile(img)
                        }
                    }
                }
            }
        }
    }
}
