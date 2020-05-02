import com.google.gson.Gson
import javafx.embed.swing.SwingFXUtils
import javafx.scene.image.Image
import javafx.scene.input.Clipboard
import javafx.scene.input.ClipboardContent
import javafx.stage.FileChooser
import tornadofx.Controller
import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import java.net.URL
import javax.imageio.ImageIO

data class Response(
    var message: List<String>? = null,
    var status: String? = null
)

class DogController : Controller() {
    fun saveImageToFile(image: Image) {
        val fileChooser = FileChooser()
        val outputPath: File = fileChooser.showSaveDialog(null) ?: return
        val outputFile = File("$outputPath.jpg")
        val bImage: BufferedImage = SwingFXUtils.fromFXImage(image, null)
        try {
            ImageIO.write(bImage, "jpg", outputFile)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    fun copyToClipboard(imageUrl: String) {
        val content = ClipboardContent()
        content.putString(imageUrl)
        Clipboard.getSystemClipboard().setContent(content)
    }

    fun getImageUrls(num: Int): List<String> {
        val json = URL("https://dog.ceo/api/breeds/image/random/$num").readText()
        val parsedJson = Gson().fromJson(json, Response::class.java)
        return parsedJson?.message ?: emptyList()
    }
}
