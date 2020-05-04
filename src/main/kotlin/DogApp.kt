import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.App
import tornadofx.addStageIcon
import tornadofx.importStylesheet

class DogApp : App() {
    override val primaryView = MainView::class
    override fun start(stage: Stage) {
        stage.isResizable = false
        super.start(stage)
    }

    init {
        importStylesheet(Styles::class)
        addStageIcon(Image(javaClass.getResourceAsStream("/icon.jpg")))
    }
}