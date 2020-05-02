import javafx.scene.paint.Color
import tornadofx.Stylesheet
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val myButton by cssclass()
    }

    init {
        myButton {
            prefWidth = 200.px
            prefHeight = 80.px
            backgroundColor += Color.DARKORCHID
            and(hover) {
                backgroundColor += Color.GREEN
            }
        }
    }
}