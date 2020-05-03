import javafx.scene.image.Image
import tornadofx.*

class FullPhotoFragment(img: Image, imageUrl: String) : Fragment("What a beautiful doggo!") {
    private val controller: DogController by inject()
    override val root = borderpane {
        addClass(Styles.myBorderPane)
        center {
            imageview(img) {
                addClass(Styles.myBoxForImages)
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
                    button("Copy to clipboard") {
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
