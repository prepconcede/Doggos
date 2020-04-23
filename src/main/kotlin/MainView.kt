import tornadofx.*

class MainView : View("My View") {
    val controller: DogController by inject()
    var images = controller.getData(9)
    override val root = borderpane {
        center {
            gridpane {
                row {
                    imageview(images[0]) {
                        fitWidth = 300.0
                        fitHeight = 200.0
                    }
                    imageview(images[1]) {
                        fitWidth = 300.0
                        fitHeight = 200.0
                    }
                    imageview(images[2]) {
                        fitWidth = 300.0
                        fitHeight = 200.0
                    }
                }
                row {
                    imageview(images[3]) {
                        fitWidth = 300.0
                        fitHeight = 200.0
                    }
                    imageview(images[4]) {
                        fitWidth = 300.0
                        fitHeight = 200.0
                    }
                    imageview(images[5]) {
                        fitWidth = 300.0
                        fitHeight = 200.0
                    }
                }
                row {
                    imageview(images[6]) {
                        fitWidth = 300.0
                        fitHeight = 200.0
                    }
                    imageview(images[7]) {
                        fitWidth = 300.0
                        fitHeight = 200.0
                    }
                    imageview(images[8]) {
                        fitWidth = 300.0
                        fitHeight = 200.0
                    }
                }
                row {
                    button("vibe check") {
                        action {
                            images = controller.getData(9)
                        }
                    }
                }
            }
        }
    }
}