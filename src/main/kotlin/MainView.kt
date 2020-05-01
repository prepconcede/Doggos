import tornadofx.*

class MainView : View("My View") {
    private val controller: DogController by inject()
    private var images = controller.getData(9).asObservable()
    private var nums = listOf(listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8))
    override val root = borderpane {
        center {
            gridpane {
                for (i in 0..2) {
                    row {
                        for (j in 0..2) {
                            imageview(images[nums[i][j]]) {
                                fitWidth = 300.0
                                fitHeight = 200.0
                            }
                        }
                    }
                }
                row {
                    button("vibe check") {
                        action {
                            images = controller.getData(9).asObservable()
                        }
                    }
                }
            }
        }
    }
}