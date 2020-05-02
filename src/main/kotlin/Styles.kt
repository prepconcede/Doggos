import javafx.scene.paint.Color
import tornadofx.Stylesheet
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
    }

    init {
        button {
            prefWidth = 200.px
            prefHeight = 80.px
            backgroundColor += Color.DARKORCHID
            and(hover) {
                backgroundColor += Color.GREEN
            }
        }
    }
}