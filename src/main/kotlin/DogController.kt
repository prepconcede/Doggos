import com.google.gson.Gson
import tornadofx.Controller
import java.net.URL

data class Response(
    var message: List<String>? = null,
    var status: String? = null
)

class DogController : Controller() {
    fun getData(num: Int): List<String> {
        val json = URL("https://dog.ceo/api/breeds/image/random/$num").readText()
        val parsedJson = Gson().fromJson(json, Response::class.java)
        return parsedJson?.message ?: emptyList()
    }
}