import javafx.scene.image.Image
import tornadofx.*

class OnClickImage(img: Image) : Fragment() {
    override val root = borderpane {
        center {
            scrollpane {
                imageview(img) {
                    maxWidth = 1000.0
                    maxHeight = 600.0
                }
            }
        }
        right {
            button("Save") {
                addClass(Styles.myButton)
            }
        }
    }
}
