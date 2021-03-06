import javafx.geometry.Pos
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val myBoxForImages by cssclass()
        val myBox by cssclass()
        val myButton by cssclass()
        val myBorderPane by cssclass()
    }

    init {
        myBoxForImages {
            padding = box(10.px)
        }
        myBorderPane {
            backgroundColor += c("29303E")
        }
        myBox {
            alignment = Pos.CENTER
            padding = box(10.px)
        }
        myButton {
            text {
                fitToWidth = true
                fontSize = 20.px
                fill = c("29303E")
            }
            prefWidth = 200.px
            prefHeight = 200.px
            backgroundColor += c("FD913C")
            and(hover) {
                backgroundColor += c("F05524")
            }
        }
    }
}