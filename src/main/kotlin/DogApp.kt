import javafx.stage.Stage
import tornadofx.App
import tornadofx.importStylesheet

class DogApp : App() {
    override val primaryView = MainView::class
    override fun start(stage: Stage) {
        stage.isResizable = false
        super.start(stage)
    }

    init {
        importStylesheet(Styles::class)
    }
}